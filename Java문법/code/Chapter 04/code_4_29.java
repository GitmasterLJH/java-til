// 369게임 do-while문을 이용해 만든 예제

public class code_4_29 {
    public static void main(String[] args) {
        for(int i=1;i<=100;i++){
            System.out.printf("i=%d ",i);

            int tmp = i;

            do{
                if(tmp%10%3==0 && tmp%10!=0)
                    System.out.print("짝");
            }while((tmp/=10)!=0);
            System.out.println();
        }
    }
}
/*결과
--중간 생략--
i=95 짝
i=96 짝짝
i=97 짝
i=98 짝
i=99 짝짝
i=100
 */