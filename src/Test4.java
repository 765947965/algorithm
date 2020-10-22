import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test4 {
    public static void main(String[] args) throws IOException {//J613
//        int[] nums = new int[]{2, 1, 1, 2};
//        插入(nums);
//        for(int item : nums){
//            System.out.print(item + " ");
//        }
        //send(1,"www", 2, true, 89.2, "ss");
//        Integer a = 10000;
//        Integer b = 10000;
//        Integer c = 100;
//        Integer d = 100;
//        System.out.println("a == b is " + (a == b));
//        System.out.println("c == d is " + (c == d));
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(3);
//        list.add(5);
//        list.add(405);
//        list.add(889);
//        list.add(47);
//        list.add(15);
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        for(Integer item: list){
//            System.out.println(item);
//        }
//
/*        int int1 = 12;
        int int2 = 12;
        Integer Integer1 = new Integer(12);
        Integer Integer2 = new Integer(12);
        Integer Integer3 = new Integer(127);

        Integer a1 = 127;
        Integer b1 = 127;

        Integer a = 128;
        Integer b = 128;

        String s1 = "str";
        String s2 = "str";
        String str1 = new String("str");
        String str2 = new String("str");

        System.out.println("int1==int2:" + (int1 == int2));
        System.out.println("int1==Integer1:" + (int1 == Integer1));
        System.out.println("Integer1==Integer2:" + (Integer1 == Integer2));
        System.out.println("Integer3==b1:" + (Integer3 == b1));
        System.out.println("a1==b1:" + (a1 == b1));
        System.out.println("a==b:" + (a == b));


        System.out.println("s1==s2:" + (s1 == s2));
        System.out.println("s1==str1:" + (s1 == str1));
        System.out.println("str1==str2:" + (str1 == str2));*/
/*        String time = "15:58";
        String a = "c";
        String b = "c";
        String c = new String("c");
        String d = new String("c");
        String e = String.valueOf("c");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(c == d);
        System.out.println(a == e);*/
 /*       String aaaa = "HTTP://FSDFDS.FWERWERWE.FSDFDSF/aaffdfa.apk";
        System.out.println(aaaa.substring(aaaa.lastIndexOf("/") + 1));
        System.out.print("$SYS/brokers/emqx@127.0.0.1/clients/48cb8cb9861841f2ad8e3230c1bc68d9/connected".matches("\\$SYS/brokers/emqx@127.0.0.1/clients/\\S+/connected"));
  */
        List<AA> list = new ArrayList<>();
        list.add(new AA("1", new Date(System.currentTimeMillis() - 1000 * 60 * 50)));
        list.add(new AA("2", new Date(System.currentTimeMillis() - 1000 * 60 * 150)));
        list.add(new AA("3", new Date(System.currentTimeMillis() - 1000 * 60 * 10)));
        list.add(new AA("4", new Date(System.currentTimeMillis() - 1000 * 60 * 90)));
        Collections.sort(list, new Comparator<AA>() {
            @Override
            public int compare(AA o1, AA o2) {
                return ((Long)o1.getCreatDate().getTime()).compareTo((Long)o2.getCreatDate().getTime());
            }
        });
        for (AA item : list) {
            System.out.println(item.getName());
        }
//        File fl = new File("E:\\aa\\files\\Documents\\face");
//        for(File item : fl.listFiles()){
//            item.renameTo(new File(item.getParent(), item.getName() + ".png"));
//        }
    }

    public static class AA {
        private String name;
        private Date creatDate;

        public AA() {
        }

        public AA(String name, Date creatDate) {
            this.name = name;
            this.creatDate = creatDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getCreatDate() {
            return creatDate;
        }

        public void setCreatDate(Date creatDate) {
            this.creatDate = creatDate;
        }
    }

    public static int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + nums[0];
        int max = Math.max(dp[0], Math.max(dp[2], dp[1]));
        for (int i = 3; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 2], +dp[i - 3]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int sub = 0;
        int tempMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > tempMax) {
                tempMax = num;
            }
            sub = Math.max(num + sub, 0);
            if (sub > max) {
                max = sub;
            }
        }
        return tempMax > 0 ? max : tempMax;
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i - 1]);
            int temp = prices[i] - min;
            if (temp > max) {
                max = temp;
            }
        }
        return max;
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
                if (nums[k] > nums[j]) {
                    k = j;
                }
            }
            if (k != i) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void 插入(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

}
