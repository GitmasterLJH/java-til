//printf 예제2
public class code_2_5 {
    public static void main(String[] args) {
        String url ="www.codechobo.com";

        float f1 =.10f;
        float f2 = 1e1f;
        float f3 = 3.14e3f;
        double d = 1.23456789;

        System.out.printf("f1=%f, %e, %g%n",f1, f1,f1);
        System.out.printf("f1=%f, %e, %g%n",f2, f2,f2);
        System.out.printf("f1=%f, %e, %g%n",f3, f3,f3);

        System.out.printf("d=%f%n", d);
        System.out.printf("d=%14.10f%n",d); //14자리중 소수점 10자리

        System.out.printf("[12345678901234567890]%n");
        System.out.printf("[%s]%n",url);
        System.out.printf("[%20s]%n",url);
        System.out.printf("[%-20s]%n",url);
        System.out.printf("[%.8s]%n",url);  //8글자만 출력
    }
}
/* 결과
f1=0.100000, 1.000000e-01, 0.100000
f1=10.000000, 1.000000e+01, 10.0000
f1=3140.000000, 3.140000e+03, 3140.00
d=1.234568
d=  1.2345678900
[12345678901234567890]
[www.codechobo.com]
[   www.codechobo.com]
[www.codechobo.com   ]
[www.code]

 */