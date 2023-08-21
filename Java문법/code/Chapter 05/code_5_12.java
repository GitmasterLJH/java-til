// String 배열 선언과 생성

public class code_5_12 {
    public static void main(String[] args) {
        String [] names = {"Kim", "Park", "Yi"};

        for(int i=0; i<names.length;i++)
            System.out.println("names["+i+"]:"+names[i]);
        String temp = names[2];
        System.out.println("tmp:"+temp);
        names[0] = "Yu";

        for(String str : names)     //향상된 for문
            System.out.println(str);
    }
}
/* 결과
names[0]:Kim
names[1]:Park
names[2]:Yi
tmp:Yi
Yu
Park
Yi
 */