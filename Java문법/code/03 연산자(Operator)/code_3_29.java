// 비트 전환 연산자~ 예제

public class code_3_29 {
    public static void main(String[] args) {
        byte p = 10;
        byte n = -10;

        System.out.printf(" p  =%d \t%s\n",  p,  toBinaryString(p));
        System.out.printf("~p  =%d \t%s\n", ~p,  toBinaryString(~p));
        System.out.printf("~p+1=%d \t%s\n", ~p+1,toBinaryString(~p+1));
        System.out.printf("~~p =%d \t%s\n", ~~p,  toBinaryString(~~p));
        System.out.println();
        System.out.printf(" n  =%d\n",n);
        System.out.printf("~(n-1)=%d\n",~(n-1));

    }
    static String toBinaryString(int x){
        String zero = "00000000000000000000000000000000";
        String tmp = zero + Integer.toBinaryString(x);
        return tmp.substring(tmp.length()-32);
    }
}
/*결과
 p  =10 	00000000000000000000000000001010
~p  =-11 	11111111111111111111111111110101
~p+1=-10 	11111111111111111111111111110110
~~p =10 	00000000000000000000000000001010

 n  =-10
~(n-1)=10
 */