class Solution {
    public static int difff;
    private static long merge(int[] nums,int[] temp,int start,int mid,int end)
    {
        int i=start;
        int j=mid+1;
        int k=start;
        long reversePairs=0;
        while (i <= mid && j <= end){
            if ((long) nums[i] <= ((long)nums[j]+(long)difff)){
                reversePairs += (end - j + 1);
                i++;
            }else {
                j++;
            }
        }
        i=start;
        j=mid+1;
        while(i<=mid && j<=end)
        {
            if(nums[i]<nums[j])
            {
                temp[k++]=nums[i++];
            }else
            {
                temp[k++]=nums[j++];
            }
        }
        while(i<=mid)
        {
            temp[k++]=nums[i++];
        }
        while(j<=end)
        {
            temp[k++]=nums[j++];
        }
        //copying back the merged elements to the original arr
        for(i=start;i<=end;i++)
        {
            nums[i]=temp[i];
        }
        return reversePairs;
    }
    private static long mergeSort(int[] nums,int[] temp,int start,int end)
    {
        long reversePairs=0;
        if(start<end)
        {
            int mid=start+(end-start)/2;
            reversePairs+=mergeSort(nums,temp,start,mid);
            reversePairs+=mergeSort(nums,temp,mid+1,end);
            reversePairs+=merge(nums,temp,start,mid,end);
        }
        return reversePairs;
    }
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        difff=diff;
        int[] temp=new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            nums1[i]=nums1[i]-nums2[i];
        }
        long st= mergeSort(nums1,temp,0,nums1.length-1);
        return st;
    }
}