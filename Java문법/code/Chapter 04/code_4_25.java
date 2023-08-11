// 각 자리의 합을 구하는 예제

import java.util.*;

public class code_4_25 {
    public static void main(String[] args) {
        int num=0, sum=0;
        System.out.print("숫자를 입력하세요.(예:12345)>");

        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        num = Integer.parseInt(tmp);

        while(num!=0){
            sum += num%10;;
            System.out.printf("sum=%3d num=%d\n",sum,num);

            num /= 10;
        }
        System.out.println("각 자리수의 합:"+sum);
    }
}
/*결과
sum=  5 num=12345
sum=  9 num=1234
sum= 12 num=123
sum= 14 num=12
sum= 15 num=1
각 자리수의 합:15
 */