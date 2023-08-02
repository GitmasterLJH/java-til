//전위형 후위형의 차이를 알아보는 예제

public class code_3_2 {
    public static void main(String[] args) {
        int i=5, j=0;
        j=i++;
        System.out.println("j=i++; 실행 후 i=" + i +",j="+j);

        i=5;
        j=0;

        j=++i;
        System.out.println("j=i++; 실행 후 i=" + i +",j="+j);
    }
}
/* 결과
j=i++; 실행 후 i=6,j=5
j=i++; 실행 후 i=6,j=6
 */