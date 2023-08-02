// 쉬프트 연산자와 비트AND연산자를 이용해서 16진수를 끝에서부터 한자리씩 뽑아내는 예제

public class code_3_31 {
    public static void main(String[] args) {
        int dec = 1234;
        int hex = 0xABCD;
        int mask = 0xF;

        System.out.printf("hex=%X\n",hex);
        System.out.printf("%X\n",hex & mask);

        hex = hex >> 4;           //0x0ABC
        System.out.printf("%X\n", hex & mask);   //C추출

        hex = hex >> 4;           //0x00AB
        System.out.printf("%X\n", hex & mask);    //B추출
 
        hex = hex >> 4;           //0x000A
        System.out.printf("%X\n", hex & mask);      //A추출
    }
}

/*결과
hex=ABCD
D
C
B
A
 */
