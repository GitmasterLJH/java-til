// 버블 정렬 예제
public class code_5_10 {
    public static void main(String[] args) {
        int [] numArr = new int[10];

        for(int i=0; i<numArr.length;i++){
            System.out.print(numArr[i]=(int)(Math.random()*10));
        }
        System.out.println();

        for(int i=0;i<numArr.length-1;i++){
            boolean changed = false;  //자리바꿈 발생했는지 체크

            for(int j=0; j<numArr.length-1-i;j++) {
                if (numArr[j] > numArr[j + 1]) {
                    int temp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = temp;
                    changed = true;
                }
            }
                if(!changed) break;

                for(int k=0;k<numArr.length;k++)
                    System.out.print(numArr[k]);
                System.out.println();
            }
        }
}
/* 결과
7383960415
3738604159
3376041589
3360415789
3304156789
3031456789
0313456789
0133456789
 */