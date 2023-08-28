// 최대값과 최소값 예제(배열)
public class code_5_6 {
    public static void main(String[] args) {
        int [] score = {79, 88, 91, 33, 100, 55, 95};

        int max = score[0];
        int min = score[0];

        for(int i=1;i<score.length;i++){
            if(score[i]>max){
                max=score[i];
            }else if(score[i]<min){
                min = score[i];
            }
        }
        System.out.println("최댓값 :"+max);
        System.out.println("최솟값 :"+min);
    }
}
/* 결과
최댓값 :100
최솟값 :33
 */