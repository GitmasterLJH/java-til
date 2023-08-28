// 3개의 반복문이 중첩되어 있는 예제

public class code_4_19 {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++)
            for (int j = 1; j <= 3; j++)
                for (int k = 1; k <= 3; k++)
                    System.out.println("" + i + j + k);
    }
}
/*결과
111
112
113
--중간생략--
332
333

 */