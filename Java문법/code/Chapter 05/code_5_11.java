// 배열 빈도수 구하기 예제

public class code_5_11 {
    public static void main(String[] args) {
        int[] numArr = new int[10];
        int[] counter = new int[10];

        for(int i=0; i<numArr.length;i++){
            numArr[i] = (int)(Math.random()*10);
            System.out.print(numArr[i]);
        }
        System.out.println();

        for(int i=0;i<numArr.length;i++){
            counter[numArr[i]]++;     // i=0이면, counter[numArr[0]]++;-> counter[6]++;
        }
        for(int i=0;i<numArr.length;i++){
            System.out.println(i+"의 개수"+counter[i]);
        }
    }
}
/* 결과
6460220851
0의 개수2
1의 개수1
2의 개수2
3의 개수0
4의 개수1
5의 개수1
6의 개수2
7의 개수0
8의 개수1
9의 개수0
 */