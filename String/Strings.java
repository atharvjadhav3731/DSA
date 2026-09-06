public class Strings {
    public static boolean palindrome(String str)
    {
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i) != str.charAt(str.length()-1-i))
            {
                return false;
            }
            
        }
        return true;
    }
    public static float getshortedpath(String str)
    {
        int x=0 ,y=0;
        for(int i=0; i<str.length(); i++)
    {
        char dir = str.charAt(i);
        if(dir == 'S')
        {
            y--;
        }else if(dir == 'N')
        {
            y++;
        }else if(dir == 'E')
        {
            x++;
        }else
        {
            x--;
        }
        
    }
    int X = x*x;
        int Y = y*y;
        return (float)Math.sqrt(X+Y);
    }
    public static String substring(String str,int si,int ei){
        String substr = "";
        for(int i=si; i<ei; i++){
            substr += str.charAt(i);
        }
        return substr;

    }
    public static String comparestring(){
        String str [] = {"apple", "mango", "banana"};
        String largest = str[0];
        for(int i = 0 ; i< str.length; i++){
            if(largest.compareTo(str[i])<0){
                largest = str[i];
            }
        }
        System.out.println(largest);
        return largest;

    }
    public static String uppercase(String str){
        StringBuilder sb = new StringBuilder();
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1; i< str.length(); i++){
            if(str.charAt(i) == ' ' && i<str.length())
            {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static String compress(String str)
    {
        String newstr = "";
        for(int i=0; i<str.length(); i++){
            Integer count = 1;
            while(i<str.length() - 1 && str.charAt(i)== str.charAt(i+1))
                {
                    count ++;
                    i++;
                }
                newstr += str.charAt(i);
                if(count > 1){
                    newstr += count.toString();
                }
        }
        return newstr;

    }
    // public static Boolean validparanthesis(String str)
    {
        String open = "";
        for(int i=0 ; i< str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                open = open + ch;
            }else
            {
                  if (open.length() == 0) 
                {
                    return false;
                }
                 char last = open.charAt(open.length() - 1);

                if ((ch == ')' && last != '(') ||
                    (ch == ']' && last != '[') ||
                    (ch == '}' && last != '{'))
                {
                    return false;
                }
                open = open.substring(0, open.length() - 1);
            }
            return open.length() == 0;
        }
    }
    public String commonprefix(int str[])
    {
        int size = Math.min(str1,str2);
        
    }
    public static void main(String[] args) 
    {
        //String str = "racecar";   
        //System.out.println("Given String is Palindrome : "+palindrome(str));
        // String str = "WNEENESENNN";
        // System.out.println("Shortest path is :"+" "+ getshortedpath(str));
        // String str = "Helloworld";
        // System.out.println("Substring :"+" "+substring(str, 0, 4));
        // comparestring();
    //      StringBuilder sb = new StringBuilder();
    //     for(char ch = 'a'; ch <= 'z'; ch++){
    //         sb.append(ch);
           
    //     }
    //      System.out.println(sb);
    // 
    
        // String str = "my name is aj";
        // System.out.println(uppercase(str));
        // String str = "aaabbccd";
        // System.out.println(compress(str));

        // String str = "()[]{}";
        // System.out.println(validparanthesis(str));
        int str [] = {"flower","flow","fly"}; 

}
}
