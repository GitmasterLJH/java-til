public class MemberCall {
    int iv = 10;
    static int cv = 20;

    int iv2 = cv;
    // static int cv2 = iv2;  // 에러. 클래변수는 인스턴스 변수를 사용할 수 없음.
    static int cv2 = new MemberCall().iv2;

    static void staticMethod1(){
        System.out.println(cv);
       // System.out.println(iv); 에러. 클래스메서드 인스턴스 변수 사용불가
        MemberCall c = new MemberCall();
        System.out.println(c.iv);       // 객체를 생성한 후에야 인스턴스변수 참조가능
    }
    void instatnceMethod1(){
        System.out.println(cv);
        System.out.println(iv);     // 인스턴스 메서드는 인스턴스 변수 바로 사용 가능
    }
    static void staticMethod2(){
        staticMethod1();
        // insatnceMethod1();  에러. 클래스메서드에서는 인스턴스메서드를 호출할 수 없음.
        MemberCall c = new MemberCall();
        c.instatnceMethod1();  // 인스턴스를 생성한 후에야 호출할 수 있음.
    }
    void instanceMethod2(){     // 인스턴스 메서드에서는 모두 인스턴스 생성없이 바로 호출 가능
        staticMethod1();
        instatnceMethod1();
    }
    
}
