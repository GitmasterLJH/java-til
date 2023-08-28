//피연산자인 변수d의 값은 형변환 후에도 아무런 변화가 없다는 예제

public class code_2_12 {
    public static void main(String[] args) {
        double d = 85.4;
        int score = (int)d;
        System.out.println("score="+score);
        System.out.println("d="+d);
    }
}
/* 결과
score=85
d=85.4
 */