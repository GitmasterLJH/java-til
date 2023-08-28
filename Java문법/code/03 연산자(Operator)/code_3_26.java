// 효율적인 연산예제

public class code_3_26 {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;

        System.out.printf("a=%d, b=%d\n",a,b);
        System.out.printf("a!=0 || ++b!=0 = %b\n", a!=0 || ++b!=0);
        System.out.printf("a=%d, b=%d\n",a,b);
        System.out.printf("a==0 && ++b!=0 = %b\n", a==0 && ++b!=0);
        System.out.printf("a=%d, b=%d\n",a,b);
    }
}
/* 결과
a=5, b=0
a!=0 || ++b!=0 = true     좌측 피연산자가(a!=0) true여서 우측 피연산자 평가x
a=5, b=0
a==0 && ++b!=0 = false    좌측 피연산자가(a==0) false여서 우측 피연산자 평가 x
a=5, b=0
 */
