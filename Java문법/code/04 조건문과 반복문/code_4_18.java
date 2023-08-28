// 구구단 예제

public class code_4_18 {
    public static void main(String[] args) {
        for(int i=2;i<=9;i++){
            for(int j=1;j<=9;j++){
                System.out.printf("%d x %d = %d\n",i,j,i*j);
            }
        }
    }
}
/*결과
2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
2 x 4 = 8
--중간생략--
9 x 6 = 54
9 x 7 = 63
9 x 8 = 72
9 x 9 = 81
 */