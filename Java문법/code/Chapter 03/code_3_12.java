// char형 연산 예제

public class code_3_12 {
    public static void main(String[] args) {
        char c1 = 'a';
        char c2 = c1;
        char c3 = ' ';

        int i = c1 + 1; // 'a' + 1 = 97 + 1 = 98
        c3 = (char)(c1 + 1);
        c2++;
        c2++;

        System.out.println("i="+i);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);
    }
}
/* 결과
i=98
c2=c
c3=b
 */
