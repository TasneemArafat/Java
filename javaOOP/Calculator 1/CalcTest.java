public class CalcTest{
    public static void main(String[] args){
        Calculator test = new Calculator(10.5, '+',5.2);
        test.performOperation();
        System.out.println(test.getResult());
    }
}