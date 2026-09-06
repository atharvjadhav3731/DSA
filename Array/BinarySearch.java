import java.util.*;
public class BinarySearch
{
    public static int BSearch(int num [],int key)
    { int start = 0 , end = num.length -1;
        while(start<=end)
        {
            int mid = (start + end)/2;

            if(num[mid] == key){
                return mid;
            }
            if(num[mid] < key){
                start = mid + 1;
            }
            if(num[mid]> key){
                end = mid - 1;
            }
     }
        return -1;
    }
    public static void main(String[] args) {

        int num [] = {11,21,10,34,25,15};
        int key = 11;

        System.out.println("index for key is :" + BSearch(num,key));
 }
}
