// 로또번호생성 예제(배열)

public class code_5_8 {
    public static void main(String[] args) {
        int [] ball = new int[45];

        for(int  i=0;i<ball.length;i++)
            ball[i]=i+1;
        int tmp = 0;
        int j=0;

        for(int i=0;i<6;i++){
            j=(int)(Math.random()*45);
            tmp=ball[i];
            ball[i]=ball[j];
            ball[j]=tmp;
        }
        for(int i=0;i<6;i++)
            System.out.printf("ball[%d]=%d\n",i,ball[i]);
    }
}
/* 결과
ball[0]=14
ball[1]=18
ball[2]=40
ball[3]=34
ball[4]=13
ball[5]=37
 */