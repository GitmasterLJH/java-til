// 문자와 숫자 비교 연산 예제

public class code_3_21 {
    public static void main(String[] args) {
        System.out.printf("10 == 10.0f   \t %b\n", 10==10.0f);
        System.out.printf("'0'== 0       \t %b\n", '0'==0);
        System.out.printf("'A'== 65      \t %b\n", 'A'==65);
        System.out.printf("'A' > 'B'     \t %b\n", 'A' > 'B');
        System.out.printf("'A'+1 != 'B'  \t %b\n", 'A'+1 !='B');

    }
}
/* 결과
10 == 10.0f   	 true
'0'== 0       	 false
'A'== 65      	 true
'A' > 'B'     	 false
'A'+1 != 'B'  	 false
 */