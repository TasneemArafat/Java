public class BasicJavaRun{
    public static void main(String[] args){
        BasicJava sheet = new BasicJava();
        // sheet.printNums();
        // sheet.printOddNums();
        // sheet.printSum();
        int [] myArray = {3, 7,5,-7};
        // sheet.iterateArray(myArray);
        // sheet.arrayMax(myArray);
        // sheet.arrayAvg(myArray);
        // sheet.arrayOddNums();
        // System.out.println(sheet.greaterThanY(myArray,3));
        // sheet.squareTheValues(myArray);
        // sheet.eliminateNegatives(myArray);
        // sheet.MMA(myArray);
        int [] newArray;
        newArray = new int[4];
        newArray = sheet.shiftArray(myArray);
        for (int i =0; i<newArray.length;i++){
            System.out.println(newArray[i]);     
        }
    }
}