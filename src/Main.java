import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        //int a = 1000;
        //Integer b = new Integer(1000);
        //System.out.print(convert("LEETCODEISHIRING", 3));
        FontSpan fontSpan = FontSpan.format("0,,555,0100,,a");
        System.out.print(fontSpan.toString());
    }


    public int reverse(int x) {
        char[] values = String.valueOf(Math.abs(x)).toCharArray();
        StringBuilder stringBuilder = new StringBuilder(values.length);
        for (int i = values.length - 1; i >= 0; i--) {
            stringBuilder.append(values[i]);
        }
        try {
            int value = Integer.parseInt(stringBuilder.toString());
            if (x < 0) {
                return -value;
            }
            return value;
        } catch (Exception e) {
            return 0;
        }
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        if (numRows == 2) {
            char[] chars = s.toCharArray();
            StringBuilder[] values = new StringBuilder[numRows];
            for (int i = 0; i < chars.length; i++) {
                StringBuilder strb = values[i % 2];
                if (strb == null) {
                    strb = new StringBuilder();
                    values[i % 2] = strb;
                }
                strb.append(chars[i]);
            }
            StringBuilder result = new StringBuilder();
            for (StringBuilder item : values) {
                if (item != null) {
                    result.append(item);
                }
            }
            return result.toString();
        } else {
            StringBuilder value = new StringBuilder();
            char[] chars = s.toCharArray();
            int j = 0;
            for (int i = 0; i < chars.length; i++) {
                int temp = i % (numRows * 2 - 2);
                if (temp == numRows) {
                    value.append(" ");
                    value.append(chars[i]);
                    if (numRows == 3) {
                        value.append(" ");
                    }
                } else if (temp == numRows * 2 - 3) {
                    value.append(chars[i]);
                    value.append(" ");
                } else {
                    value.append(chars[i]);
                }
                j++;
            }
            StringBuilder[] values = new StringBuilder[numRows];
            chars = value.toString().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = i % (numRows * 2);
                if (index >= numRows) {
                    index = (numRows * 2) - 1 - index;
                }
                StringBuilder strb = values[index];
                if (strb == null) {
                    strb = new StringBuilder();
                    values[index] = strb;
                }
                strb.append(chars[i]);
            }
            StringBuilder result = new StringBuilder();
            for (StringBuilder item : values) {
                if (item != null) {
                    result.append(item);
                }
            }
            return result.toString().replace(" ", "");
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] values = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < values.length) {
            if (i >= nums1.length) {
                values[k] = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                values[k] = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                values[k] = nums1[i];
                i++;
            } else {
                values[k] = nums2[j];
                j++;
            }
            k++;
        }
        if (values.length == 1) {
            return values[0];
        } else if (values.length == 2) {
            return (values[0] + values[1]) / 2d;
        } else if (values.length % 2 == 0) {
            int end = values.length / 2;
            int start = end - 1;
            return (values[start] + values[end]) / 2d;
        } else {
            return values[values.length / 2];
        }
    }

    private static void similarity(String value1, String value2) {
        char[] a = value1.toCharArray();
        char[] b = value2.toCharArray();
        int[][] values = new int[a.length + 1][b.length + 1];
        for (int i = 0; i <= a.length; i++) {
            values[i][0] = i;
        }
        for (int i = 0; i <= b.length; i++) {
            values[0][i] = i;
        }
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    values[i][j] = values[i - 1][j - 1];
                } else {
                    values[i][j] = Math.min(values[i - 1][j - 1] + 1, Math.min(values[i][j - 1], values[i - 1][j] + 1));
                }
            }
        }
        System.out.println("1/" + values[a.length][b.length]);
    }

    // 最小公约数
    public static int getMineTimes(int a, int b) {
        int c = a;
        while (c % b != 0) {
            c += a;
        }
        return c;
    }

    // 立方根
    public static String getCubeRoot1(double input) {
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(Math.pow(input, 1.0 / 3.0));
    }

    // 立方根
    public static String getCubeRoot(double input) {
        /*在这里实现功能*/
        if (input == 0) {
            return "0";
        }
        double x0, x1;
        x0 = input;
        x1 = (2 * x0 + input / x0 / x0) / 3;//利用迭代法求解
        while (Math.abs(x1 - x0) > 0.000001) {
            x0 = x1;
            x1 = (2 * x0 + input / x0 / x0) / 3;
        }
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(x1);
    }

    // 倒序
    public static void reverseOrder(String str) {
        Stack<Character> stack = new Stack<>();
        for (char item : str.toCharArray()) {
            stack.push(item);
        }
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }

    // 最少负数
    public static void negativeNumber(String[] strs) {
        List<Integer> negativeList = new ArrayList<>();
        List<Integer> positiveNumberList = new ArrayList<>();
        float accumulate = 0;
        for (String item : strs) {
            item = item.trim();
            if (item.length() > 0) {
                try {
                    int value = Integer.parseInt(item);
                    if (value >= 0) {
                        positiveNumberList.add(value);
                        accumulate += value;
                    } else {
                        negativeList.add(value);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(negativeList.size());
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println(df.format(accumulate / (float) positiveNumberList.size()));
    }


    // 输出8
    public static void input8Length(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            springStr(strs[i]);
        }
    }

    private static void springStr(String value) {
        if (value.length() != 0) {
            int index = 0;
            while (index < value.length()) {
                int end = index + 8;
                if (end > value.length()) {
                    end = value.length();
                }
                StringBuilder outStr = new StringBuilder(value.substring(index, end));
                while (outStr.length() < 8) {
                    outStr.append("0");
                }
                System.out.println(outStr.toString());
                index = end;
            }
        }
    }

    // Redraiment
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            String[] data = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < data.length; i++) {
                arr[i] = Integer.parseInt(data[i]);
            }

            int[] brr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                brr[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i]) {
                        brr[i] = Math.max(brr[i], brr[j] + 1);
                    }
                }
            }

            int max = 0;
            for (int aBrr : brr) {
                if (max < aBrr) {
                    max = aBrr;
                }
            }

            System.out.println(max);
        }
    }
}
