//어떤 문자의 유니코드 알아내기 예제
public class code_2_7 {
    public static void main(String[] args) {
        char ch = 'A';
        int code = (int)ch;
        System.out.printf("%c=%d(%#X)%n",ch ,code,code);
        char hch = '가';  //char hch = 0xAC00;   char hch = '\uAC00' 같은표현
        System.out.printf("%c=%d(%#X)%n",hch,(int)hch,(int)hch);
    }
}
/* 결과
A=65(0X41)
가=44032(0XAC00)
 */