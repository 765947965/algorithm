package test;

import java.util.*;

public class Test5 {
    public static void main(String[] args) {
//        int[] value = new int[]{3, 2, 4};
//        for (int item : twoSum(value, 6)) {
//            System.out.print(item + " ");
//        }
        byte[] aa = new byte[24];
        aa[0] = 1;
        aa[1] = 1;
        aa[2] = 1;
        aa[3] = 1;
        aa[4] = 1;
        aa[5] = 1;
        aa[6] = 1;
        aa[7] = 1;
        aa[8] = 1;
        aa[9] = 1;
        aa[10] = 1;
        aa[11] = 1;
        aa[12] = 1;
        aa[13] = 1;
        aa[14] = 1;
        aa[15] = 1;
        aa[16] = 0;
        aa[17] = 1;
        aa[18] = 2;
        aa[19] = 3;
        aa[20] = 4;
        aa[21] = 5;
        aa[22] = 6;
        aa[23] = 7;
        for (byte item : yv12ToNv21(aa)) {
            System.out.print((int) item);
        }
    }

    // 适应于nv12和nv21相互转换
    // yv12: YYYYYYYY UUVV
    // NV21: YYYYYYYY VUVU
    public static byte[] yv12ToNv21(byte[] yv12) {
        byte[] nv21 = new byte[yv12.length];
        int ylength = 16;
        System.arraycopy(yv12, 0, nv21, 0, ylength);
        for (int i = 0; i < ylength / 4; i++) {
            nv21[ylength + i * 2] = yv12[ylength + ylength / 4 + i];
            nv21[ylength + i * 2 + 1] = yv12[ylength + i];
        }
        for(int i = 0; i<100;i++){
            System.out.print(i);
        }
        return nv21;
    }

    public static void nv21ConvertNv12(byte[] nv21, int width, int height) {
        byte tmp;
        for (int i = width * height; i < nv21.length; i++) {
            if ((i + 1) % 2 == 0) {
                tmp = nv21[i - 1];
                nv21[i - 1] = nv21[i];
                nv21[i] = tmp;
            }
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void NV21ToNV12(byte[] nv21, byte[] nv12, int width, int height) {
        if (nv21 == null || nv12 == null) return;

        int framesize = width * height;
        int i = 0, j = 0;

        System.arraycopy(nv21, 0, nv12, 0, framesize);

        for (i = 0; i < framesize; i++) {
            nv12[i] = nv21[i];
        }

        for (j = 0; j < framesize / 2; j += 2) {
            nv12[framesize + j - 1] = nv21[j + framesize];
        }

        for (j = 0; j < framesize / 2; j += 2) {
            nv12[framesize + j] = nv21[j + framesize - 1];
        }
    }


    private static byte[] NV21ToNV12(byte[] nv21, int width, int height) {
        if (nv21 == null) return null;
        byte[] nv12 = new byte[nv21.length];
        int framesize = width * height;
        int i = 0, j = 0;
        System.arraycopy(nv21, 0, nv12, 0, framesize);
        for (i = 0; i < framesize; i++) {
            nv21[i] = nv12[i];      //前面宽*高的数据是一样的
        }

        //NV12 宽*高 后的数据是：UVUVUV...，UV总的数据是 宽*高/2 。现在把V放在 宽*高 后的第一个位置，+2奇数位置。
        for (j = 0; j < framesize / 2; j += 2) {
            nv21[framesize + j - 1] = nv12[j + framesize];
        }

        //NV12 宽*高 后的数据是：UVUVUV...，UV总的数据是 宽*高/2 。现在把U放在 宽*高 后的第二个位置，+2偶数数位置。
        for (j = 0; j < framesize / 2; j += 2) {
            nv21[framesize + j] = nv12[j + framesize - 1];
        }

        return nv12;
    }


//    private static byte[] NV21ToNV12(byte[] nv21, int width, int height) {
//        if (nv21 == null) return null;
//        byte[] nv12 = new byte[nv21.length];
//        int framesize = width * height;
//        int i = 0, j = 0;
//        System.arraycopy(nv21, 0, nv12, 0, framesize);
//        for (j = 0; j < framesize / 2; j += 2) {
//            nv12[framesize + j + 1] = nv21[j + framesize];
//        }
//
//        for (j = 0; j < framesize / 2; j += 2) {
//            nv12[framesize + j] = nv21[j + framesize + 1];
//        }
//        return nv12;
//    }

    private static byte[] NV12ToNV21(byte[] nv12, int width, int height) {
        if (nv12 == null) return null;
        byte[] nv21 = new byte[nv12.length];
        int framesize = width * height;
        int i = 0, j = 0;
        System.arraycopy(nv12, 0, nv21, 0, framesize);
        for (j = 0; j < framesize / 2; j += 2) {
            nv21[framesize + j + 1] = nv12[j + framesize];
        }

        for (j = 0; j < framesize / 2; j += 2) {
            nv21[framesize + j] = nv12[j + framesize + 1];
        }
        return nv21;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        StringBuilder value1 = new StringBuilder();
        while (!stack1.isEmpty()) {
            value1.append(stack1.pop());
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        StringBuilder value2 = new StringBuilder();
        while (!stack2.isEmpty()) {
            value2.append(stack2.pop());
        }
        int value = Integer.parseInt(value1.toString()) + Integer.parseInt(value2.toString());
        Stack<Character> out = new Stack<>();
        for (char item : String.valueOf(value).toCharArray()) {
            out.push(item);
        }
        ListNode outValue = new ListNode(out.pop());
        ListNode temp = outValue;
        while (!out.isEmpty()) {
            temp.next = new ListNode(out.pop());
            temp = temp.next;
        }
        return outValue;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> list = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            list.put(target - item, i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (list.containsKey(temp)) {
                int value = list.get(temp);
                if (i != value) {
                    return new int[]{i, list.get(temp)};
                }
            }
        }
        return null;
    }

    public static void 冒泡(int[] nums) {
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

    public static void 选择(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[k]) {
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

    public static void 插入(int[] nums) {
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
