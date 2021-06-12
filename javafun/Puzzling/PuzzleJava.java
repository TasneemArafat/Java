import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class PuzzleJava{
    public static ArrayList<Integer> printArraySum(int [] array){
        int sum = 0;
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (int i =0; i<array.length;i++){
            sum += array[i];
            if(array[i]>10){
            newArray.add(array[i]);
            }
        }
        System.out.println(sum);
        return newArray;
    }

    public static ArrayList<String> shuffleArrayNames(ArrayList<String> array){
        Collections.shuffle(array);
        ArrayList<String> newArray = new ArrayList<String>();
        for (int i =0; i<array.size();i++){
            System.out.println(array.get(i));
            if(array.get(i).length()>5){
            newArray.add(array.get(i));
            }
        }
        return newArray;
    }

    public static void alphabetsArray(ArrayList<Character> array){
        Collections.shuffle(array);
        System.out.println(array.get(25));
        System.out.println(array.get(0));
        if((array.get(0))=='a' || (array.get(0))=='e' || (array.get(0))=='o' || (array.get(0))=='u' || (array.get(0))=='i'){
            System.out.println("First letter's a vowel");
        }
    }

    public static  ArrayList<Integer> tenRandoms(){
        ArrayList<Integer> array = new ArrayList<Integer>();
        Random r = new Random();
        // r.nextInt(high-low) + low
        for(int i = 0; i< 10; i++){
            array.add(r.nextInt(45)+55);
        }
        Collections.sort(array);
        System.out.println(array.get(0));
        System.out.println(array.get(9));
        return array;
    }

    public static String ranString(){
        ArrayList<Character> array = new ArrayList<Character>();
        Random letter = new Random();
        String word = new String();
        for(int i=0; i<5; i++){
            array.add((char)(letter.nextInt(26) + 'a'));
            word += array.get(i);
        }
        return word;
    }

    public static ArrayList<String> arrayOfStrings(){
        ArrayList<String> array = new ArrayList<String>();
        for(int i=0; i<10; i++){
            String newStr = ranString();
            array.add(newStr);
        }
        return array;
    }

}