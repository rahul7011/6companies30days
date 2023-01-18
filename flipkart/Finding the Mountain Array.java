/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    private static int findPivot(int target, MountainArray mountainArr) {
        int low = 0, high = mountainArr.length() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int bSearch(int low, int high, int target, MountainArray mountainArr) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int bSearch2(int low, int high, int target, MountainArray mountainArr) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int pivot = findPivot(target, mountainArr);
        if (mountainArr.get(pivot) < target) {
            return -1;
        }
        // System.out.println(pivot+" "+mountainArr.get(pivot));
        int p1 = bSearch(0, pivot, target, mountainArr);
        // System.out.println(p1);
        if (p1 != -1) {
            return p1;
        }
        int p2 = bSearch2(pivot + 1, mountainArr.length() - 1, target, mountainArr);
        // System.out.println(p2);
        return p2;
    }
}