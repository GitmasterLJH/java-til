// 임의의 값으로 배열 채우기 예제
import java.util.*;
public class code_5_9 {
    public static void main(String[] args) {
        int [] code = {-4, -1, 3, 6, 11};
        int [] arr = new int[10];

        for(int i=0;i<arr.length;i++){
            int tmp = (int)(Math.random()*code.length);
            arr[i]=code[tmp];
        }
        System.out.println(Arrays.toString(arr));
    }
}
/*결과
[6, -4, 6, 6, -4, 3, -4, 11, 11, -1]
 */