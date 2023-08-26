// main 메서드의 무한 호출

public class MainTest {
    public static void main(String[] args) {
        main(null);
    }
}
/* main메서드가 종료되지 않고 호출스택에 계속해서 쌓이게 되어 결국 호출스택의 메모리 한계에 넘게 되고
 StackOverflowError가 발생하여 프로그램은 비정상적으로 종료됨
 */