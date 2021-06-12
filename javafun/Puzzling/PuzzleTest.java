import java.util.ArrayList;
public class PuzzleTest{
    public static void main(String[] arg){
        PuzzleJava test = new PuzzleJava();
        int [] myArray = {3,5,1,2,7,9,8,13,25,32};
        System.out.println(test.printArraySum(myArray));
        ArrayList<String> namesArray = new ArrayList<String>();
        namesArray.add("Nancy");
        namesArray.add("Jinichi");
        namesArray.add("Fujibayashi");
        namesArray.add("Momochi");
        namesArray.add("Ishikawa");
        System.out.println(test.shuffleArrayNames(namesArray));

        ArrayList<Character> charArray = new ArrayList<Character>();
        for(char i = 'a'; i<='z'; i++){
            charArray.add(i);
        }
        test.alphabetsArray(charArray);

        System.out.println(test.tenRandoms());
        
        System.out.println(test.ranString());

        ArrayList<String> strArray = new ArrayList<String>();
        strArray = test.arrayOfStrings();
        System.out.println(strArray);
    }
}