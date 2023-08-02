// long타입 변수에 int 형 연산 값 담기 예제

public class code_3_8 {
    public static void main(String[] args) {
        int a = 1_000_000;
        int b = 2_000_000;

        long c = a*b;
        System.out.println(c);
    }
}
/* 결과
-1454759936

a*b의 결과가 이미 int타입 값이므로 long형으로 자동 형변환되어도 값은 변하지 않음.
올바른 결과를 얻으려면 (long)a *b ; 처럼 a또는 b의 타입을 long으로 형변환 해야한다.
 */
