// 커맨드 라인을 통해 입력받기 예제1

public class code_5_16 {
    public static void main(String[] args) {
        System.out.println("매개변수의 개수:"+args.length);
        for(int i=0;i<args.length;i++){
            System.out.println("args["+i+"]=\""+args[i]+"\"");
        }
    }
}
/* 결과
매개변수의 개수:2
args[0]="abc"
args[1]="123"
 */