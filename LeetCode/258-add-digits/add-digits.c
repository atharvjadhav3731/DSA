int addDigits(int num) 
{
    int iDigit = 0;
    int iSum = 0;
    while(num >= 10)
    {
        iSum = 0;
        while(num != 0)
        {
            iDigit = num % 10;
            iSum = iSum + iDigit;
            num = num / 10;
        } 
        num =iSum;
    }
return num;

}
