package code_7_30;

class DefaultMethodTest {
    public static void main(String[] args) {
        Child c = new Child();
        c.method1();
        c.method2();
        Myinterface.staticMethod();
        Myinterface2.staticMethod();
    }
}
class Child extends Parent implements Myinterface,Myinterface2{
    public void method1() {
        System.out.println("method1() in Child");
    }
}
class Parent{
    public void method2(){
        System.out.println("method2() in Parent");
    }
}

interface Myinterface{
    default void method1(){
        System.out.println("method()1 int Myinteface");
    }
    default void method2(){
        System.out.println("method()2 int Myinteface");
    }
    static void staticMethod(){
        System.out.println("staticMethod() in Myinterface");
    }
}
interface Myinterface2{
    default void method1(){
        System.out.println("method()1 int Myinteface2");
    }
    static void staticMethod(){
        System.out.println("staticMethod() in Myinterface2");
    }
}