// 1부터 몇까지 더하면 누적합계가 100을 넘지 않은 제일 큰수가 되는지 알아보는 예제

public class code_4_26 {
    public static void main(String[] args) {
        int sum =0;
        int i =0;

        while((sum+=++i)<=100){
            System.out.printf("%d - %d\n",i,sum);
        }
    }
}
/*결과
1 - 1
2 - 3
3 - 6
4 - 10
5 - 15
6 - 21
7 - 28
8 - 36
9 - 45
10 - 55
11 - 66
12 - 78
13 - 91
 */