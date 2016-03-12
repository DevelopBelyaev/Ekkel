package com.company;


class A{
    interface B {
        void f();
    }

    class BImpl implements B {

        @Override
        public void f() {

        }
    }

    class BImpl2 implements B {
        @Override
        public void f() {

        }
    }

    public interface C {
        void f();
    }

    class CImpl implements C {
        @Override
        public void f() {

        }
    }

    private class CImpl2 implements C {
        @Override
        public void f() {

        }
    }

    private interface D {
        void f();
    }

    private class DImpl implements D {
        @Override
        public void f() {

        }
    }

    public class DImpl2 implements D {
        @Override
        public void f() {

        }
    }

    public D getD() {
        return new DImpl2();
    }

    private D dRef;

    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }
}


interface E {
    interface G {
        void f();
    }

    interface H {
        void f();
    }

    void g();
}




public class Main {

    public class BImpl implements A.B {
        @Override
        public void f() {

        }
    }

    public class CImpl implements A.C {
        @Override
        public void f() {

        }
    }

    public class EImpl implements E {
        @Override
        public void g() {

        }
    }

    class EGImpl implements E.G {
        @Override
        public void f() {

        }
    }

    class EImpl2 implements E {
        @Override
        public void g() {

        }

        class EG implements E.G {
            @Override
            public void f() {

            }
        }
    }
    public static void main(String[] args) {
        A a = new A();
        
    }
}

