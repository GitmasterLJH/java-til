// 쉬프트 연산자 사용 예제

public class code_3_30 {
    static String toBinaryString(int x){
        String zero = "00000000000000000000000000000000";
        String tmp = zero + Integer.toBinaryString(x);
        return tmp.substring(tmp.length()-32);
    }
    public static void main(String[] args) {
     int dec = 8;

     System.out.printf("%d >> %d = %4d \t%s\n",dec,0,dec >> 0, toBinaryString(dec >> 0));

     System.out.printf("%d >> %d = %4d \t%s\n",dec,1,dec >> 1, toBinaryString(dec >> 1));

     System.out.printf("%d >> %d = %4d \t%s\n",dec,2,dec >> 2, toBinaryString(dec >> 2));

     System.out.printf("%d << %d = %4d \t%s\n",dec,0,dec << 0, toBinaryString(dec << 0));

     System.out.printf("%d << %d = %4d \t%s\n",dec,0,dec << 1, toBinaryString(dec << 1));

     System.out.printf("%d << %d = %4d \t%s\n",dec,0,dec << 2, toBinaryString(dec << 2));

     System.out.println();

     dec = -8;
     System.out.printf("%d >> %d = %4d \t%s\n",dec,0,dec >> 0, toBinaryString(dec >> 0));

     System.out.printf("%d >> %d = %4d \t%s\n",dec,1,dec >> 1, toBinaryString(dec >> 1));

     System.out.printf("%d >> %d = %4d \t%s\n",dec,2,dec >> 2, toBinaryString(dec >> 2));

     System.out.printf("%d << %d = %4d \t%s\n",dec,0,dec << 0, toBinaryString(dec << 0));

     System.out.printf("%d << %d = %4d \t%s\n",dec,0,dec << 1, toBinaryString(dec << 1));

     System.out.printf("%d << %d = %4d \t%s\n",dec,0,dec << 2, toBinaryString(dec << 2));

     System.out.println();

     dec = 8;
     System.out.printf("%d >> %2d = %4d \t%s\n",dec,0,dec >> 0, toBinaryString(dec >> 0));

     System.out.printf("%d >> %2d = %4d \t%s\n",dec,32,dec >>32, toBinaryString(dec >> 32));
    }
}
/* 결과
8 >> 0 =    8 	00000000000000000000000000001000
8 >> 1 =    4 	00000000000000000000000000000100
8 >> 2 =    2 	00000000000000000000000000000010
8 << 0 =    8 	00000000000000000000000000001000
8 << 0 =   16 	00000000000000000000000000010000
8 << 0 =   32 	00000000000000000000000000100000

-8 >> 0 =   -8 	11111111111111111111111111111000
-8 >> 1 =   -4 	11111111111111111111111111111100
-8 >> 2 =   -2 	11111111111111111111111111111110
-8 << 0 =   -8 	11111111111111111111111111111000
-8 << 0 =  -16 	11111111111111111111111111110000
-8 << 0 =  -32 	11111111111111111111111111100000
 */