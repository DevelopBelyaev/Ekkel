package com.company;

/**
 * Created by oleg on 07.03.16.
 */

interface Service {
    void method1();

    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {
    Implementation1() {

    }
    @Override
    public void method1() {
        System.out.println("impl1 method1");
    }

    @Override
    public void method2() {
        System.out.println("impl2 method2");
    }
}

class Implementation1Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Implementation1();
    }
}

class Implementation2 implements Service {
    Implementation2() {

    }
    @Override
    public void method1() {
        System.out.println("impl2 method1");
    }

    @Override
    public void method2() {
        System.out.println("impl2 method2");
    }
}

class Implementation2Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Implementation2();
    }
}

public class FactoryExample {
    public static void serviceConsumer(ServiceFactory serviceFactory) {
        Service service = serviceFactory.getService();
        service.method1();
        service.method2();
    }
    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());
        serviceConsumer(new Implementation2Factory());
    }
}
