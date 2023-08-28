// if문 예제

public class code_4_1 {
    public static void main(String[] args) {
        int x =0;
        System.out.printf("x=%d 일 때, 참인 것은\n",x);

        if(x==0) System.out.println("x==0");
        if(x!=0) System.out.println("x!=0");
        if(!(x==0)) System.out.println("!(x==0)");
        if(!(x!=0)) System.out.println("!(x!=0)");

        x=1;
        System.out.printf("x=%d 일 때, 참인 것은\n",x);

        if(x==0) System.out.println("x==0");
        if(x!=0) System.out.println("x!=0");
        if(!(x==0)) System.out.println("!(x==0)");
        if(!(x!=0)) System.out.println("!(x!=0)");
    }
}
/* 결과
x=0 일 때, 참인 것은
x==0
!(x!=0)
x=1 일 때, 참인 것은
x!=0
!(x==0)
 */
