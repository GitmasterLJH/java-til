// 3의 배수는 출력안하는 예제

public class code_4_31 {
    public static void main(String[] args) {
        for(int i=0;i<=10;i++){
            if(i%3==0)
                continue;
            System.out.println(i);
        }
    }
}
/*결과
1
2
4
5
7
8
10
 */