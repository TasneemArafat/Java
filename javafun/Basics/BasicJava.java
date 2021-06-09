import java.util.ArrayList;
import java.lang.Math;
public class BasicJava{
    public void printNums(){
        for (int i =1; i<= 255; i++){
            System.out.println(i);
        }
    }

    public void printOddNums(){
        for (int i =1; i<= 255; i++){
            if(i%2 != 0){
                System.out.println(i);
            }
        }
    }

    public void printSum(){
        int sum = 0;
        for (int i=0;i<=255;i++){
            sum+=i;
            System.out.println(String.format("New number: "+i+" Sum: "+sum));
        }
    }

    public void iterateArray(int [] X){
        for(int i=0; i<X.length;i++){
            System.out.println(X[i]);
        }
    }

    public void arrayMax(int [] X){
        int max = X[0];
        for(int i=0; i<X.length;i++){
            if(max < X[i]){
                max = X[i];
            }
        }
        System.out.println(max);
    }

    public void arrayAvg(int [] X){
        int sum = 0;
        int num;
        for(int i=0; i<X.length;i++){
            sum += X[i];
        }
        if (sum<0){
            sum = sum*-1;
        }
        double Average = sum/X.length;
        System.out.println(Average);
    }

    public void arrayOddNums(){
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (Integer i =1; i<= 255; i++){
            if(i%2 != 0){
                y.add(i);
            }
        }
        System.out.println(y);
    }

    public int greaterThanY(int [] X, int Y){
        int count = 0;
        for (int i =0; i<X.length; i++){
            if(X[i]>Y){
                count++;
            }
        }
        return count;
    }

    public void squareTheValues(int [] X){
        for (int i =0; i<X.length; i++){
            X[i]=X[i]*X[i];
            System.out.println(X[i]);
        }
    }

    public void eliminateNegatives(int [] X){
        for (int i =0; i<X.length; i++){
            if(X[i]<0){
                X[i]=0;
            }
            System.out.println(X[i]);
        }
    }

    public void MMA(int [] X){
        int max=X[0];
        int min = X[0];
        int sum = 0;
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (int i =0; i<X.length; i++){
            if(X[i]>max){
                max = X[i];
            }
            if(X[i]<min){
                min = X[i];
            }
            sum += X[i];
        }
        newArray.add(max);
        newArray.add(min);
        newArray.add(sum/X.length);
        System.out.println(newArray);
    }

    public static int[] shiftArray(int [] X){
        for (int i =0; i<X.length-1; i++){
            X[i] = X[i+1];
        }
        X[X.length-1]=0;
        return X;
    }
}