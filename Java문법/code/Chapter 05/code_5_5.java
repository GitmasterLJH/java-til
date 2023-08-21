// 총합과 평균 예제(배열)
public class code_5_5 {
    public static void main(String[] args) {
        int sum = 0;
        float average = 0;

        int[] score = {100, 88, 100, 100, 90};

        for (int i=0; i<score.length;i++){
            sum+= score[i];
        }
        average = sum / (float)score.length;

        System.out.println("총점 : "+sum);
        System.out.println("평균 : "+average);
    }
}
/* 결과
총점 : 478
평균 : 95.6
 */