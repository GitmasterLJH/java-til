class DeckTest {
    public static void main(String[] args) {
        Deck d = new Deck();
        Card1 c = d.pick(0);
        System.out.println(c);    // System.out.println(c.toString()); 과 같다.

        d.shuffle();
        c = d.pick(0);
        System.out.println(c);
    }
}
class Deck{
    final int CARD_NUM = 52;  //  카드의 개수
    Card1 cardArr[] = new Card1[CARD_NUM];

    Deck(){
        int i=0;
        for(int k=Card1.KIND_MAX;k>0;k--)
            for(int n=0;n<Card1.NUM_MAX;n++)
                cardArr[i++]= new Card1(k,n+1);
    }
    Card1 pick(int index){
        return cardArr[index];
    }
    Card1 pick(){
        int index = (int)(Math.random()*CARD_NUM);
        return pick(index);
    }

    void shuffle(){
        for(int i=0;i<cardArr.length;i++){
            int r = (int)(Math.random()*CARD_NUM);

            Card1 temp = cardArr[i];
            cardArr[i]=  cardArr[r];
            cardArr[r] = temp;
        }
    }

}
class Card1{
    static final int KIND_MAX = 4;
    static final int NUM_MAX = 13;

    static final int SPADE    = 4;
    static final int DIAMOND  = 3;
    static final int HEART    = 2;
    static final int CLOVER   = 1;
    int kind;
    int number;

    Card1(){
        this(SPADE,1);
    }
    Card1(int kind, int number){
        this.kind = kind;
        this.number =number;
    }
    public String toString(){
        String[] kinds = {"", "CLOVER","HEART","DIAMOND","SPADE"};
        String numbers = "0123456789XJQK"; // 숫자 10은 X로 표현

        return "kind : " +kinds[this.kind] + ", number : " + numbers.charAt(this.number);

    }
}
