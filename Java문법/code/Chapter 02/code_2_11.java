//float타입의 값이 실제로 어떻게 저장되는지 확인하는 예제

public class code_2_11 {
    public static void main(String[] args) {
        float f = 9.1234567f;
        int i = Float.floatToIntBits(f);

        System.out.printf("%f%n",f);
        System.out.printf("%X%n",i);
    }
}
/* 결과
9.123457
4111F9AE     잘려나간 첫 번째 자리의 값이 1이라서 반올림되어 4111F9AD의 2진수
              마지막 자리 두자리의 값이 01에서 10으로 1증가했기 떄문에 값이 다르다
 */