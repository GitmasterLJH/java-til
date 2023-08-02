// 곱하기,나누기 순서에 따른 결과값 차이

public class code_3_10 {
    public static void main(String[] args) {
        int a = 1000000;
        int result1 = a * a / a;
        int result2 = a / a * a;
        System.out.printf("%d * %d / %d = %d\n",a,a,a,result1);
        System.out.printf("%d * %d / %d = %d\n",a,a,a,result2);
    }
}
/* 결과
1000000 * 1000000 / 1000000 = -727
1000000 * 1000000 / 1000000 = 1000000

먼저 곱한경우 백만X백만=int형 범위를 넘어서기 떄문에 오버플로우가 발생해서
result1,2의 값이 다르게 나왔다.
 */
