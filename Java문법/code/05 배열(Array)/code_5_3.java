// for문 이용 배열 복사

public class code_5_3 {
    public static void main(String[] args) {
        int [] arr = new int[5];

        for(int i=0;i<arr.length;i++)
            arr[i] = i+1;
        System.out.println("[변경전]");
        System.out.println("arr.length:"+arr.length);
        for(int i=0;i<arr.length;i++)
            System.out.println("arr["+i+"]:"+arr[i]);
        int[] tmp = new int[arr.length*2];

        for(int i=0;i<arr.length;i++)
            tmp[i]=arr[i];

        arr = tmp;
        System.out.println("[변경후]");
        System.out.println("arr.length"+arr.length);
        for(int i=0;i<arr.length;i++)
            System.out.println("arr["+i+"]:"+arr[i]);
    }
}
/* 결과
[변경전]
arr.length:5
arr[0]:1
arr[1]:2
arr[2]:3
arr[3]:4
arr[4]:5
[변경후]
arr.length10
arr[0]:1
arr[1]:2
arr[2]:3
arr[3]:4
arr[4]:5
arr[5]:0
arr[6]:0
arr[7]:0
arr[8]:0
arr[9]:0
 */