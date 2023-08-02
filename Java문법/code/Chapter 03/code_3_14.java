// 1씩 증가시키며 문자를 출력하는 예제

public class code_3_14 {
    public static void main(String[] args) {
        char c = 'a';
        for(int i=0;i<26;i++){
            System.out.print(c++);
        }
        System.out.println();

        c='A';
        for(int i=0;i<26;i++){
            System.out.print(c++);
        }
        System.out.println();

        c='0';
        for(int i=0;i<10;i++){
            System.out.print(c++);
        }
        System.out.println();
    }
}
/* 결과
abcdefghijklmnopqrstuvwxyz
ABCDEFGHIJKLMNOPQRSTUVWXYZ
0123456789
 */