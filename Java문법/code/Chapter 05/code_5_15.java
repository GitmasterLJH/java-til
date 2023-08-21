// 문자열을 모스부호로 변환하는 예제

public class code_5_15 {
    public static void main(String[] args) {
        String source = "SOSHELP";
        String[] morse = {".-", "-...", "-.-.", "-..", "."
                        ,"..-.", "--.", "....","..",".---"
                        ,"-.-", ".-..", "--", "-.", "---"
                        ,".--.", "--.-", ".-.", "...", "-"
                        ,"..-", "...-", ".--", "-..-", "-.--"
                        , "--.."};
        String result ="";

        for(int i=0;i< source.length();i++){
            result+=morse[source.charAt(i)-'A'];
        }
        System.out.println("source:"+source);
        System.out.println("morse:"+result);
        
    }
}
/*결과
source:SOSHELP
morse:...---.........-...--.
 */