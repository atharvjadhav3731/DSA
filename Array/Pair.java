public class Pair {

    public static void printpair(int num[])
    {
        for(int i=0; i<num.length; i++)
        {
            int current = num[i];
            for(int j=i+1; j<num.length; j++)
            System.out.println("("+num[i]+","+num[j]+")");
        }
    }     

    public static void main(String A[]){
        int num [] ={2,4,6,8};

        printpair(num);

    }
    

}
