class ReturnTest {
    public static void main(String[] args) {
        ReturnTest r = new ReturnTest();

        int result = r.add(3, 5);
        System.out.println(result);

        int[] reuslt2 = {0};
        r.add(3, 5, reuslt2);
        System.out.println(reuslt2[0]);
    }
    int add(int a, int b){
        return a+b;
    }
    void add(int a, int b, int[] result){
        result[0]= a+b;
    }
}
