// 배열의 출력 예제

import java.util.*;

public class code_5_2 {
    public static void main(String[] args) {
        int[] iArr1 = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = {100, 95, 80, 70, 60};
        char[] chArr = {'a', 'b', 'c', 'd'};

        for(int i=0;i<iArr1.length;i++){
            iArr1[i]=i+1;
        }
        for(int i=0;i<iArr2.length;i++){
            iArr2[i]=(int)(Math.random()*10)+1;
        }

        for(int i=0;i<iArr1.length;i++){
            System.out.print(iArr1[i]+",");
        }
        System.out.println();
        System.out.println(Arrays.toString(iArr2));
        System.out.println(Arrays.toString(iArr3));
        System.out.println(Arrays.toString(chArr));
        System.out.println(iArr3);
        System.out.println(chArr);
    }
}
/* 결과
1,2,3,4,5,6,7,8,9,10,
[3, 9, 6, 8, 7, 8, 7, 1, 3, 6]
[100, 95, 80, 70, 60]
[a, b, c, d]
[I@27973e9b
abcd
 */