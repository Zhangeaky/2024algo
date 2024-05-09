package aleetcode.problem.instrument;

import java.lang.instrument.Instrumentation;

public class ObjectSizeCalculator {

    private static volatile Instrumentation instrumentation;

    public static void premain(String agentArgs, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object obj) {
        if (instrumentation == null) {
            throw new IllegalStateException("Instrumentation environment not initialized.");
        }
        return instrumentation.getObjectSize(obj);
    }

    static class MerchantSettleFilter {
        private String merchantId;

        private String paymentMethod;

        private String payProvider;

        private String brand;

        private String exchangeable;

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getPayProvider() {
            return payProvider;
        }

        public void setPayProvider(String payProvider) {
            this.payProvider = payProvider;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getExchangeable() {
            return exchangeable;
        }

        public void setExchangeable(String exchangeable) {
            this.exchangeable = exchangeable;
        }
    }

    public static void main(String[] args) {
        // 创建一个对象
        MerchantSettleFilter filter = new MerchantSettleFilter();
        filter.setExchangeable("Y");
        filter.setBrand("MASTERCARD");
        filter.setPaymentMethod("ONLINE_BANKING_WERTYUJHGFDFGH");
        filter.setPayProvider("AYDEN_AYDEN_AYDEN");


        // 获取对象的大小
        long size = getObjectSize(filter);

        // 打印对象的大小
        System.out.println("Object size: " + size + " bytes");
    }
}


