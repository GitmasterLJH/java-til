// 조건 연산자를 이용해서 변수의 절대값을 구한 후 부호를 붙여 출력 예제

public class code_3_32 {
    public static void main(String[] args) {
        int x, y, z;
        int absX, absY, absZ;
        char signX, signY, signZ;

        x = 10;
        y = -5;
        z= 0;

        absX = x>=0 ? x : -x;
        absY = y>=0 ? y : -y;
        absZ = z>=0 ? z : -z;

        signX = x > 0 ? '+' : (x==0 ? ' ' : '-');
        signY = y > 0 ? '+' : (y==0 ? ' ' : '-');
        signZ = z > 0 ? '+' : (z==0 ? ' ' : '-');

        System.out.printf("x=%c%d\n", signX,absX);
        System.out.printf("x=%c%d\n", signY,absY);
        System.out.printf("x=%c%d\n", signZ,absZ);
    }
}
/*결과
x=+10
x=-5
x= 0
 */
