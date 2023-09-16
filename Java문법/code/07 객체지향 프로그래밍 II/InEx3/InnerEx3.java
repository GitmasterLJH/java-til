package InEx3;

class InnerEx3 {
    private int outerIv = 0;
    static  int outerCv = 0;

    class InstanceInner{

        int iiv  = outerIv;  // 외부 클레스의 private멤버도 접근가능하다.
        int iiv2 = outerCv;
    }
    static class StaticInner{
        //  static클래스는 외부 클래스의 인스턴스 멤버에 접근 불가
        // int siv = outerIv;
        static int scv= outerCv;
    }
    void myMethod(){
        int lv = 0;
        final int Lv = 0; // JDK 1.8부터 final 생략 가능

        class LocalInner{
            int liv = outerIv;
            int liv2 = outerCv;
            // 외부클래스의 지역변수는 fianl이 붙은 변수(상수)만 접근이가능
            int liv3 = lv;// 에러!(JDK1.8부터 에러가 아님, 왜냐하면 lv의 값이 변하지 않았기에 final이 생략된것으로 침)
            int liv4 = Lv;//OK
        }
    }
}
