// 리터럴 간의 연산 예제

public class code_3_13 {
    public static void main(String[] args) {
        char c1 = 'a';

        // char c2 = c1+1; 컴파일 에러
        char c2 = 'a'+1;   // 컴파일러가 미리 덧셈연산을 수행함 -> char c2 = 'b';
        System.out.println(c2);
    }
}
/*결과
b
 */