// 변수 flag를  true에서 false로 바꿔 반복을 멈추는 예제

import java.util.*;

public class code_4_27 {
    public static void main(String[] args) {
        int num;
        int sum=0;
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("합계를 구할 숫자를 입력하세요.(끝내려면 0을 입력)");

        while(flag){
            System.out.print(">>");

            String tmp = scanner.nextLine();
            num = Integer.parseInt(tmp);

            if(num!=0){
                sum+=num;
            }else{
                flag = false;
            }
        }
        System.out.println("합계 :"+sum);
    }
}
/*결과
합계를 구할 숫자를 입력하세요.(끝내려면 0을 입력)
>>100
>>200
>>300
>>400
>>0
합계 :1000
 */