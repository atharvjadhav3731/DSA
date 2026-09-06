class RotatedSearch
{
    public static int search(int nums[], int key) 
    {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) 
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] == key) 
            {
                return mid;
            }
            if (nums[start] < nums[mid]) //left sort
            {
                if (nums[start] <= key && key <= nums[mid]) //binary search
                {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else // rightsort
            {
                if (nums[mid] <= key && key >= nums[end]) //binary search
                {
                    start = mid + 1;
                } else 
                {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums [] ={4,5,6,7,0,1,2};
        int key = 7;

        System.out.println("The key is at :"+search(nums,key));
    }

}