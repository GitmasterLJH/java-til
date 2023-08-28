// if-else문 예제

import java.util.*;
public class code_4_3 {
    public static void main(String[] ags){
        System.out.print("숫자를 하나 입력하세요>");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if(input==0){
            System.out.println("입력하신 숫자는 0입니다.");
        }else{
            System.out.println("입력하신 숫자는 0이아닙니다.");
        }
    }
}
/* 결과
숫자를 하나 입력하세요>5
입력하신 숫자는 0이아닙니다.
 */
