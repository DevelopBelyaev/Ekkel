package com.company.Chapter10.InnerClasses;

/**
 * Created by oleg on 12.03.16.
 */
interface Service {
    void method1();

    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation1();
        }
    };

    @Override
    public void method1() {
        System.out.println("Imp1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Imp2 method2");
    }
}

class Implementation2 implements Service {

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };

    @Override
    public void method1() {
        System.out.println("Imp2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Imp2 method2");
    }
}

public class Factories {

    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);
    }
}
