package InEx2;

class InnerEx2 {
    class InstatnceInner{}
    static class StaticInner{}

    // 인스턴스멤버는 같은 클래스에 있는 인스턴스멤버와 static멤버 모두 직접 접근이 가능하다.
    InstatnceInner iv = new InstatnceInner();
    StaticInner iv2 = new StaticInner();

    // static 멤버는 static멤버 간에만 서로 직접 접근이 가능하다.
    static StaticInner cv = new StaticInner();
    // static InstatnceInner cv2 = new InstatnceInner();  에러, static멤버에서 instance멤버 접근

    static void staticMethod(){
        // static멤버는 인스턴스멤버에 접근할 수 없다.
        // InstatnceInner oj1 = new InstatnceInner();
        StaticInner obj2 = new StaticInner();

        // 굳이 접근하려면 아래와 같이 객체를 생성해야 한다.
        // 인스턴스클래스는 외부 클래스를 먼저 생성해야만 생성할 수 있다.
        InnerEx2 outer = new InnerEx2();
        InstatnceInner obj1 = outer.new InstatnceInner();
    }
    void instanceMethod(){
        // 인스턴스메서드에서는 인스턴스멤버와 static멤버 모두 접근 가능하다.
        InstatnceInner obj1 = new InstatnceInner();
        StaticInner obj2 = new StaticInner();
        // 메서드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근할 수 없다.
        // LocalInner lv = new LocalInner();

    }
    void myMethod(){
        class LocalInner{}
        LocalInner lv = new LocalInner();
    }
}
