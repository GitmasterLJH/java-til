//형변환 한것과 안한 것의 차이 예제

public class code_3_9 {
    public static void main(String[] args) {
        long a = 1_000_000 * 1_000_000;
        long b = 1_000_000 * 1_000_000L;
        System.out.println("a= "+a);
        System.out.println("b="+b);
    }
}
/* 결과
a= -727379968
b=1000000000000

a는 int끼리의 연산이여서 오버플로우가 발생
b는 연산 결과가 long타입이기 때문에 올바른 결과를 얻음
 */