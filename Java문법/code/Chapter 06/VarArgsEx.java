public class VarArgsEx {
    public static void main(String[] args) {
        String[] strArr = {"100","200","300"};

        System.out.println(concatenate("","100","200","300"));
        System.out.println(concatenate("-",strArr));
        System.out.println(concatenate(",",new String[]{"1", "2","3"}));
        System.out.println("["+concatenate(",",new String[0])+"]");
        System.out.println("["+concatenate(",")+"]");

    }
    static String concatenate(String delim, String ... args){
        String result = "";

        for(String str :args){
            result += str + delim;
        }
        return result;
    }
}
/* Line 7
concatenate 함수는 가변인자를 받아들이는데,
이 경우 아무 문자열도 전달되지 않았으므로 args 배열은 비어있습니다.
따라서 for 루프는 실행되지 않고, result는 초기값인 빈 문자열 그대로 반환됩니다.
 */
