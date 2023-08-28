// int형과 double형간의 나눗셈 예제

public class code_3_17 {
    public static void main(String[] args) {
        double pi = 3.141592;
        double shortPi = (int)(pi * 1000 + 0.5) / 1000.0;

        System.out.println(shortPi);
    }
}
/*결과
3.142
 */