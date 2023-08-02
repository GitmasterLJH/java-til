// 사칙연산의 피연산자로 문자를 사용한 예제

public class code_3_11 {
    public static void main(String[] args) {
        char a = 'a';
        char d = 'd';
        char zero = '0';
        char two = '2';

        System.out.printf("'%c' - '%c' = %d\n",d,a,d-a);
        System.out.printf("'%c' - '%c' = %d\n",two,zero,two-zero);
        System.out.printf("'%c'=%d\n",a, (int)a);
        System.out.printf("'%c'=%d\n",d, (int)d);
        System.out.printf("'%c'=%d\n",zero, (int)zero);
        System.out.printf("'%c'=%d\n",two, (int)two);
    }
}
/* 결과
'd' - 'a' = 3
'2' - '0' = 2
'a'=97
'd'=100
'0'=48
'2'=50
 */