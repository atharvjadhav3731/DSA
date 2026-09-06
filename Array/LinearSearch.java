import java.util.*;
public class LinearSearch {

    public static int Search(int number[],int key){
        for(int i=0; i<number.length; i++)
        {
            if(number[i]== key)
            {
                return i;
            }
            
        }
        return -1;
    }
    


public static void main (String A[]){
    int number [] = {1,2,33,45,66,10,22,48};
    int key = 10;

    int index = Search(number, key);
    if(index == -1)
    {
        System.out.println("not found");
    }
    System.out.println("Index is :"+index);
}

}
