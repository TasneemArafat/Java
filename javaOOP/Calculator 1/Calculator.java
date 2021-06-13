public class Calculator{
    private double opernadOne;
    private double operandTwo;
    private char operation;
    private double result;

    public Calculator(double operandOne, char operation, double operandTwo){
        setOperandOne(operandOne);
        this.opernadOne = operandOne;
        setOperation(operation);
        this.operation = operation;
        setOperandTwo(operandTwo);
        this.operandTwo = operandTwo;
    }
    public double getOperandOne(){
        return this.opernadOne;
    }

    public void setOperandOne(double input){
        opernadOne = input;
    }

    public double getOperandTwo(){
        return this.operandTwo;
    }

    public void setOperandTwo(double input){
        operandTwo = input;
    }

    public char getOperation(){
        return this.operation;
    }

    public void setOperation(char input){
        if(input == '+' || input == '-'){
        operation = input;
        }
        else{
            System.out.println("Operation Not Available!, please choose either (+) or (-).");
        }
    }

    public void performOperation(){
        if(operation == '+'){
            result = getOperandOne() + getOperandTwo();
        }

        if(operation == '-'){
            result = getOperandOne() - getOperandTwo();
        }
    }

    public double getResult(){
        return this.result;
    }

}