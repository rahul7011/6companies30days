class Solution {
    private static void display(int[]a)
    {
        for(int x:a)
            System.out.print(x+" ");
        System.out.println("-------");
    }
    private static int[] merger(int[]a,int[]b)
    {
        // display(a);
        // display(b);
        int[] full=new int[a.length+b.length];
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length)
        {
            if(a[i]<b[j])
            {
                full[k]=a[i];
                i++;
            }else
            {
                full[k]=b[j];
                j++;
            }
            k++;
        }
        while(i<a.length)
        {
            full[k]=a[i];
            i++;
            k++;
        }
        while(j<b.length)
        {
            full[k]=b[j];
            j++;
            k++;
        }
        // System.out.println("$$$");
        // display(full);
        return full;
    }
    private static int partition(int[] nums,int pivot,int left,int right)
    {
        int i=left;
        while(left<=right)
        {
            if(nums[left]<=pivot)
            {
                int temp=nums[left];
                nums[left]=nums[i];
                nums[i]=temp;
                i++;
                left++;
            }else
            {
                left++;
            }
        }
        // System.out.println(pivot);
        // display(nums);
        return i-1;
    }
    private static void quickSort(int[] nums,int left,int right)
    {
        if(left<=right)
        {
            int pivotPosition=partition(nums,nums[right],left,right);
            quickSort(nums,left,pivotPosition-1);
            quickSort(nums,pivotPosition+1,right);
        }
    }
    private static int[] mergeSort(int[] nums,int left,int right)
    {
        if(left==right)
        {
            return new int[]{nums[left]};
        }
        int mid=left+(right-left)/2;
        int[] fHalf=mergeSort(nums,left,mid);
        int[] sHalf=mergeSort(nums,mid+1,right);
        int[] complete=merger(fHalf,sHalf);
        return complete;
    }
    private static int[] countSort(int[] nums){
        int max=(int)-1e9;
        int min=(int)1e9;
        for(int x:nums)
        {
            max=Math.max(max,x);
            min=Math.min(min,x);
        }
        int[] freq=new int[max-min+1];
        for(int x:nums)
        {
            freq[x-min]++;
        }
        int pre=0;
        for(int i=0;i<freq.length;i++)
        {
            pre+=freq[i];
            freq[i]=pre;
        }
        int[] finalArr=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--)
        {
            finalArr[freq[nums[i]-min]-1]=nums[i];
            freq[nums[i]-min]--;
        }
        return finalArr;
    }
    public int[] sortArray(int[] nums) {
        // return mergeSort(nums,0,nums.length-1);
        // quickSort(nums,0,nums.length-1);
        // return nums;
        return countSort(nums);
    }
}