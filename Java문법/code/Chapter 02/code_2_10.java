//float 정밀도 확인 예제

public class code_2_10 {
    public static void main(String[] args) {
        float f = 9.12345678901234567890f;
        float f2 = 1.2345678901234567890f;
        double d = 9.12345678901234567890d;

        System.out.printf("       123456789012345678901234%n");
        System.out.printf("f   : %f%n",f);
        System.out.printf("f   : %24.20f%n",f);
        System.out.printf("f2  : %24.20f%n",f2);
        System.out.printf("d   : %24.20f%n",d);
    }
}
/* 결과
       123456789012345678901234
f   : 9.123457
f   :   9.12345695495605500000     원래 저장하려는 값은 9.12345678901234567890인데
f2  :   1.23456788063049320000             저장된 값은 9.12345695495605500000으로 float정밀도가 7자리여서 원래의 값에서
d   :   9.12345678901234600000          7자리의 값만 오차없이 저장되었음
 */