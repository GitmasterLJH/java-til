//printf 다양한 지시자 사용 예제
public class code_2_4 {
    public static void main(String[] args) {
        byte b =1;
        short s=2;
        char c='A';

        int finger =10;
        long big = 100_000_000L;
        long hex = 0xFFFF_FFFF_FFFF_FFFFL;

        int octNum =010;    //8진수 10, 10진수로 8
        int hexNum =0x10;  // 16진수 10, 10진수로 16
        int binNum =0b10;  // 2진수 10, 10진수로 2

        System.out.printf("b=%d%n",b);
        System.out.printf("s=%d%n",s);
        System.out.printf("c=%c, %d %n",c,(int)c);  //char타입을 int타입으로 형변환
        System.out.printf("finger=[%5d]%n",finger);
        System.out.printf("finger=[%-5d]%n",finger);
        System.out.printf("finger=[%05d]%n",finger);
        System.out.printf("big=%d%n",big);
        System.out.printf("hex=%#x%n",hex);  //%x와 %o에 #을 사용하면 접두사 0x와 0이 각각 붙는다.%X는 접두사와 영문자를 대문자로 출력
        System.out.printf("octNum=%o, %d%n",octNum, octNum);
        System.out.printf("hexNum=%x, %d%n",hexNum,hexNum);
        //정수를 2진 문자열로 변환해줌
        System.out.printf("binNum=%s, %d%n", Integer.toBinaryString(binNum),binNum);
    }
}
/* 결과
b=1
s=2
c=A, 65
finger=[   10]
finger=[10   ]
finger=[00010]
big=100000000
hex=0xffffffffffffffff
octNum=10, 8
hexNum=10, 16
binNum=10, 2
 */