class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] index_in_b  = new int[len];
        for(int i = 0;i<len;i++){
            index_in_b[nums2[i]] = i;
        }
        List<Integer> index_in_b_Sorted = new ArrayList();
        long[] prea = new long[len];
        for(int i = 0;i<len;i++){
            int idxInB = index_in_b[nums1[i]];
        int idx_In_List = 0-Collections.binarySearch(index_in_b_Sorted,idxInB)-1;
            prea[i] = idx_In_List;
        index_in_b_Sorted.add(idx_In_List,idxInB); 
        }
        index_in_b_Sorted.clear();
        long[] sufa = new long[len];
        for(int i = len-1;i>=0;i--){
            int idxInB = index_in_b[nums1[i]];
            int idx_In_List = 0-Collections.binarySearch(index_in_b_Sorted,idxInB)-1;
            sufa[i] = index_in_b_Sorted.size()-idx_In_List;
            index_in_b_Sorted.add(idx_In_List,idxInB);             
        }
        long ans = 0;
        for(int i = 0;i<len;i++){
            ans+=prea[i]*sufa[i];
        }
        return ans;
    }
}