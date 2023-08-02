// byte형 덧샘 컴파일 에러

public class code_3_6 {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
      // byte c = a + b;
       // System.out.println(c);

    }
}
/* 결과
java: incompatible types: possible lossy conversion from int to byte

피연산자들의 자료형을 int 형으로 변환한 다음 연산을 수행해서 a+b 는 int형인데 4byte 값을
1byte 변수에 형변환없이 저장하려고 했기 때문에 에러가 발생
(byte)(a+b); 로 바꿔야 에러 해결
 */