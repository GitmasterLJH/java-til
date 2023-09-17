class ExceptionEx7 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);
        }catch (ArithmeticException ae){
            if(ae instanceof ArithmeticException)
                System.out.println("true");
            System.out.println("ArithmeticException");
        }catch (Exception e){
            System.out.println("Exception");    // 1번째 catch문에 쓰인 참조변수를 제외하고(ArithmeticException) 모든 예외가 처리된다.
        }
        System.out.println(6);
    }
}