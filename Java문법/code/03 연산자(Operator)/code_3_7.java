// int형을 byte형으로 변환 하는 경우 예제

public class code_3_7 {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 30;
        byte c = (byte)(a*b);
        System.out.println(c);
    }
}
/* 결과
44

10 * 30 = 300이지만 큰 자료형에서 작은 자료형으로 변환할때 데이터 손실이 생김
 */