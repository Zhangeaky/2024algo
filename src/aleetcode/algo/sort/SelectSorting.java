package aleetcode.algo.sort;

import java.util.Arrays;

public class SelectSorting {

    public int[] sorting(int[] input) {

        if (input== null) {
            return null;
        }

        for (int i=0; i<input.length; i++) {
            int min = input[i];
            int index = i;
            for (int j=i; j<input.length; j++) {
                if (input[j] < min) {
                    min = input[j];
                    index = j;
                }
            }

            // 交换第i个数据与 剩余数组中最小值的位置。
            if (index == i) {
                continue;
            }
            int temp = input[index];
            input[index] = input[i];
            input[i] = temp;
        }

        return input;
    }

    public static void main(String[] args) {
        SelectSorting ss = new SelectSorting();
        Arrays.stream(ss.sorting(new int[]{8, 9, 13, 5, 4, 127, 2, 1})).forEach(x -> System.out.print(x+","));
        System.out.println();
    }

}
