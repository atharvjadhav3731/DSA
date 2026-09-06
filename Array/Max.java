import java.util.*;
public class Max {
    
    public static int Max(int num[])
    {
        int largest = Integer.MIN_VALUE;
        for(int i=0; i <num.length; i++)
        {
            if(largest < num[i] ){
                largest = num[i];
            }

        } 
        return largest;
    }   


    public static void main(String[] args) {

        int num [] = {11,21,10,34,25,15};

   
        System.out.println("Largest number is :"+ Max(num));
        
    }
}
