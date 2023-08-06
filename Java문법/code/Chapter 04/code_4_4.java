// if-else if문 예제

import java.util.Scanner;

public class code_4_4 {
    public static void main(String[] args) {
        int score = 0;
        char grade = ' ';

        System.out.print("점수를 입력하세요.>");
        Scanner scanner = new Scanner(System.in);
        score = scanner.nextInt();

        if(score >=90){
            grade = 'A';
        }else if(score >=80){
            grade = 'B';
        }else if(score >=70){
            grade = 'C';
        }else{
            grade = 'D';
        }
        System.out.println("당신의 학점은 "+ grade +"입니다.");
    }
}
/* 결과
점수를 입력하세요.>63
당신의 학점은 D입니다.
 */