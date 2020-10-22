package test;

import java.util.TreeSet;

public class Test2 {
    public static void main(String[] args) {
        int[] value = new int[]{3, 5, 1, 9, 6, 4, 8};
        insert(value);
        for (int item : value) {
            System.out.print(item + " ");
        }
        //System.out.println(Integer.parseInt("5.0".split("\\.")[0]));
    }

    public boolean containsDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                int tempCut = nums[j] - nums[j - 1];
                if (tempCut == 0) {
                    return true;
                } else if (tempCut < 0) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return false;
    }

    public static void bubble(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void select(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[k] > nums[j]) {
                    k = j;
                }
            }
            if (k != i) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
    }

    public static void insert(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
