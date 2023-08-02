// int형과 float형간의 나눗셈 예제

public class code_3_16 {
    public static void main(String[] args) {
        float pi =3.141592f;
        float shortPi =(int)(pi*1000)/1000f;
        System.out.println(shortPi);
    }
}
/* 결과
3.141
 */