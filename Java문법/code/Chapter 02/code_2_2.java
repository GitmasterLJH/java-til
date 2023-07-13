// x 와 y의 값을 바꾸는 예제
public class code_2_2 {
    public static void main(String[] args) {
        int x=10,y=20;
        int temp=0;
        System.out.println("x:"+ x + " y: "+ y);
        temp=x;
        x=y;
        y=temp;
        System.out.println("x:"+ x + " y: "+ y);
    }
}
/* 결과
x:10 y: 20
x:20 y: 10

 */