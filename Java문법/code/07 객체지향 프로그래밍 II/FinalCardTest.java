class FinalCardTest {
    public static void main(String[] args) {
        Card c = new Card("Heart",10);
//      c.NUMBER = 5;     에러!! cannot assign a value to final variable NUMBER
        System.out.println(c.KIND);
        System.out.println(c.NUMBER);
        System.out.println(c);  // System.out.println(c.toString());
    }
}
class Card{
    final int NUMBER;
    final String KIND;
    static int width = 100;
    static int height = 250;

    Card(String kind, int num){
        KIND = kind;
        NUMBER = num;
    }
    Card(){
        this("Heart",1);
    }
    public String toString(){
        return KIND + " "+ NUMBER;
    }
}