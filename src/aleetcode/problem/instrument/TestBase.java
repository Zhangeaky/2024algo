package aleetcode.problem.instrument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestBase {

    public static void execute(String[] args) throws Exception {

        TestBase test = new TestBase();
        String currentDirectory = test.getCurrentDirectory();
        System.out.println(currentDirectory);
        File file = new File(currentDirectory);
        File parent = new File(file.getParent());
        System.out.println(parent.getAbsoluteFile());

        List<File> classFiles = getClassFiles(parent);
        System.out.println(classFiles);

        // 使用自定义的类加载器加载该类
        List<? extends Class<?>> classList = classFiles.stream().map(ff -> {
            byte[] classBytes = null;
            Class<?> clazz = null;
            try {
                classBytes = Files.readAllBytes(ff.toPath());
                clazz = new CustomClassLoader().defineClass(classBytes);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return clazz;
        }).collect(Collectors.toList());

        System.out.println(classList);

        List<Class<?>> targetClass = new ArrayList<>();
        for (Class<?> clazz : classList) {
            if (clazz.getAnnotation(Solution.class) !=null) {
                targetClass.add(clazz);
            }
        }
        System.out.println(targetClass);

    }

    static class CustomClassLoader extends ClassLoader {
        public Class<?> defineClass(byte[] classBytes) {
            return defineClass(null, classBytes, 0, classBytes.length);
        }
    }

    public static List<File> getClassFiles(File directory) {
        List<File> classFiles = new ArrayList<>();
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // 递归调用，获取子目录下的类文件
                        classFiles.addAll(getClassFiles(file));
                    } else if (file.getName().endsWith(".class")) {
                        // 过滤出类文件
                        classFiles.add(file);
                    }
                }
            }
        }
        return classFiles;
    }

    public String getCurrentDirectory() {
        // 获取当前类的类加载器
        ClassLoader classLoader = getClass().getClassLoader();
        // 获取当前类的全限定名，并将"."替换为"/"
        String className = getClass().getName().replace('.', '/');
        // 获取当前类文件的URL
        java.net.URL url = classLoader.getResource(className + ".class");
        // 获取文件路径
        String path = url.getPath();
        // 去除路径中的文件协议前缀"file:/"
        if (path.startsWith("file:/")) {
            path = path.substring(6);
        }
        // 解码路径中的特殊字符
        try {
            path = java.net.URLDecoder.decode(path, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        // 在IDE环境中，路径末尾会包含类文件名，需要去除类文件名部分
        if (path.endsWith(".jar") || path.endsWith(".class")) {
            int lastSeparatorIndex = path.lastIndexOf(File.separator);
            if (lastSeparatorIndex != -1) {
                path = path.substring(0, lastSeparatorIndex);
            }
        }
        // 返回文件夹路径
        return path;
    }

}
