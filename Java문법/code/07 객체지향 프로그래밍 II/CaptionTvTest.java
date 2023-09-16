class CaptionTvTest {
    public static void main(String[] args) {
        CaptionTv ctv = new CaptionTv();    // 자손 클래스의 인스턴스 생성
        ctv.channel = 10;   // 조상 클래스로부터 상속받은 멤버
        ctv.channelUp();    // 조상 클래스로부터 상속받은 멤버
        System.out.println(ctv.channel);
        ctv.displayCaption("Hello, World");
        ctv.caption = true;
        ctv.displayCaption("Hello,World");
    }
}

class Tv1{
    boolean power; // 전원상태(on/off)
    int channel; // 채널

    void power()    { power = !power;}
    void channelUp()    { ++channel;}
    void channelDown()  { --channel;}
}
class CaptionTv extends Tv1{
    boolean caption;    // 캡션상태(on/off)
    void displayCaption(String text){
        if(caption){
            System.out.println(text);
        }
    }
}
