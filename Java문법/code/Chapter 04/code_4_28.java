// do-while문 예제

import java.util.Scanner;

public class code_4_28 {
    public static void main(String[] args) {
        int input =0, answer =0;

        answer = (int)(Math.random()*100)+1;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("1과 100사이의 정수를 입력하세요.>");
            input = scanner.nextInt();

            if(input>answer){
                System.out.println("더 작은 수로 다시 시도해보세요.");
            }else if(input<answer) {
                System.out.println("더 큰 수로 다시 시도해보세요.");
            }
        }while(input!=answer);
        System.out.println("정답입니다.");
    }
}
/*결과
1과 100사이의 정수를 입력하세요.>50
더 작은 수로 다시 시도해보세요.
1과 100사이의 정수를 입력하세요.>25
더 작은 수로 다시 시도해보세요.
1과 100사이의 정수를 입력하세요.>12
더 작은 수로 다시 시도해보세요.
1과 100사이의 정수를 입력하세요.>6
더 큰 수로 다시 시도해보세요.
1과 100사이의 정수를 입력하세요.>8
정답입니다.
 */