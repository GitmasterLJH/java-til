// 중첩 if문 예제

import java.util.*;
public class code_4_5 {
    public static void main(String[] args) {
        int score = 0;
        char grade = ' ', opt = '0';

        System.out.print("점수를 입력해주세요.>");

        Scanner scanner = new Scanner(System.in);
        score = scanner.nextInt();

        System.out.printf("당신의 점수는 %d입니다.\n", score);

        if(score>=90){
            grade ='A';
            if(score>=98){         //90점 이상 중에서 98점 이상은 A+
                opt='+';
            }else if (score<94){   //90점 이상 중에서 94점 미만은 A-
                opt='-';
            }
        }else if(score>=80){
            grade ='B';
            if(score>=88){           //80점 이상 중에서 88점 이상은 B+
                opt='+';
            }else if (score<84){     ////80점 이상 중에서 84점 미만은 B-
                opt='-';
            }
        }else {
            grade ='C';
        }
        System.out.printf("당신의 학점은 %c%c입니다,\n",grade,opt);
    }
}
/*결과
점수를 입력해주세요.>82
당신의 점수는 82입니다.
당신의 학점은 B-입니다,
 */