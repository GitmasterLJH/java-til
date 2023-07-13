// float, double 정밀도 차이에 의한 값의 차이

public class code_2_14 {
    public static void main(String[] args) {
        float f = 9.1234567f;
        double d =9.1234567;
        double d2 = (double)f;

        System.out.printf("f =%20.18f\n",f);
        System.out.printf("d =%20.18f\n",d);
        System.out.printf("d2=%20.18f\n",d2);
    }
}
/* 결과
f =9.123456954956055000    f와 d에 같은 값을 저장했지만 정밀도 차이때문에 서로 다른 값이 저장됨
d =9.123456700000000000
d2=9.123456954956055000
 */