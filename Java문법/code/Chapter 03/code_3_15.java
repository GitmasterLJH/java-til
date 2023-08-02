//소문자를 대문자로 변경하는 예제

public class code_3_15 {
    public static void main(String[] args) {
        char lowerCase = 'a';
        char upperCase = (char)(lowerCase - 32);
        System.out.println(upperCase);
    }
}
/* 결과
A
 */
