import javafx.concurrent.Task;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;

public class Solution {


    public static void main(String[] args) {
        String a = "afdfewrewvcxwe329423fdsfsddf111111test3";
        long time = System.currentTimeMillis();
        //System.out.println(generateParenthesis2(15).toString());
//        System.out.println(divide(-2147483648,
//                -1
//        ));
//        List<List<Integer>> result = permute(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
//        int size = 0;
//        for (List<Integer> item : result) {
//            size += 1;
//        }
//        System.out.print(result.size());
//        System.out.print(new Solution().canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}));
//        File file = new File("C:\\Users\\76594\\Desktop\\1\\files\\Documents\\face");
//        for (File fl : file.listFiles()) {
//            fl.renameTo(new File(fl.getAbsolutePath() + ".jpg"));
//        }
//        System.out.print(new Solution().multiply("9", "9"));
        /*int[][] aa = new int[9][9];
        aa[0][1] = 3;
        aa[0][7] = 9;
        aa[1][5] = 4;
        aa[2][3] = 5;
        aa[3][1] = 2;
        aa[4][4] = 7;
        aa[5][8] = 5;
        aa[6][2] = 8;
        aa[6][6] = 6;
        aa[7][0] = 1;
        aa[8][8] = 9;
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                System.out.print(aa[i][j] + " ");
            }
        }
        System.out.println();
        new Solution().solveSudoku(aa);
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                System.out.print(aa[i][j] + " ");
            }
        }*/
/*        int[][] intervals = new int[3][2];
        intervals[0][0] = 1;
        intervals[0][1] = 4;
        intervals[1][0] = 0;
        intervals[1][1] = 2;
        intervals[2][0] = 3;
        intervals[2][1] = 5;
     *//*   intervals[3][0] = 15;
        intervals[3][1] = 18;*//*
        new Solution().merge(intervals);*/

        Solution solution = new Solution();
        /*Map<Integer, Integer> map = new HashMap<>();
        int[] arrays = new int[100];
        arrays[23] = 1;
        for (int i = 0; i < 1000000; i++) {

            solution.luanXu(arrays);
            for (int j = 0; j < arrays.length; j++) {
                if (arrays[j] == 1) {
                    if (map.containsKey(j)) {
                        map.put(j, map.get(j) + 1);
                    } else {
                        map.put(j, 1);
                    }
                }
            }
        }
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            System.out.println(item.getKey() + ":" + item.getValue());
        }*/
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    private Map<Integer[], Integer> trapMap = new HashMap<>();

    public int trap(int[] height) {
        int total = 0;
        if (height.length < 3) {
            return 0;
        }
        int[] maxLeft = new int[height.length];
        maxLeft[0] = height[0];
        int[] maxRight = new int[height.length];
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < maxLeft.length; i++) {
            // 备份左边的最大值
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        for (int j = maxRight.length - 2; j >= 0; j--) {
            // 备份右边的最大值
            maxRight[j] = Math.max(height[j], maxRight[j + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            total += Math.max(0, Math.min(maxLeft[i - 1], maxRight[i + 1]) - height[i]);
        }
        return total;
    }

    public int shipWithinDays(int[] weights, int D) {
        int min = 0;
        int max = 0;
        for (int item : weights) {
            if (item > min) {
                min = item;
            }
            max += item;
        }
        while (min < max) {
            int middle = (min + max) / 2;
            if (conFinish(weights, D, middle)) {
                max = middle;
            } else {
                min = middle;
            }
        }
        return min;
    }

    private boolean conFinish(int[] weights, int D, int weight) {
        int temp = 0;
        for (int item : weights) {
            if (item > weight) {
                return false;
            }
            if (temp + item > weight) {
                D--;
                temp = item;
            } else {
                temp += item;
            }
        }
        return D > 0;
    }

    private Random random = new Random();

    public void luanXu(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int rand = random.nextInt(arrays.length - i) + i;
            int temp = arrays[i];
            arrays[i] = arrays[rand];
            arrays[rand] = temp;
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int cut = 0;
        int jump = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1 - jump][1]) {
                if (intervals[i][1] > intervals[i - 1 - jump][1]) {
                    intervals[i - 1 - jump][1] = intervals[i][1];
                }
                intervals[i][0] = Integer.MIN_VALUE;
                jump += 1;
                cut++;
            } else {
                jump = 0;
            }
        }
        int[][] result = new int[intervals.length - cut][2];
        for (int i = 0, j = 0; i < intervals.length; i++) {
            if (intervals[i][0] != Integer.MIN_VALUE) {
                result[j][0] = intervals[i][0];
                result[j][1] = intervals[i][1];
                j++;
            }
        }
        return result;
    }

    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int[] arrays1 = new int[num1.length()];
        int[] arrays2 = new int[num2.length()];
        for (int i = num1.length() - 1, j = 0; i >= 0; i--, j++) {
            arrays1[j] = Integer.parseInt(String.valueOf(chars1[i]));
        }
        for (int i = num2.length() - 1, j = 0; i >= 0; i--, j++) {
            arrays2[j] = Integer.parseInt(String.valueOf(chars2[i]));
        }
        int[] value = new int[num2.length() + num1.length() + 4];
        for (int i = 0; i < arrays1.length; i++) {
            for (int j = 0; j < arrays2.length; j++) {
                int sum = arrays1[i] * arrays2[j];
                int tenValue = sum / 10;
                int gw = sum % 10;
                if (gw > 0) {
                    plus(value, i + j, gw);
                }
                if (tenValue > 0) {
                    plus(value, i + j + 1, tenValue);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean start = false;
        for (int i = value.length - 1; i >= 0; i--) {
            if (start) {
                stringBuilder.append(value[i]);
            } else {
                if (value[i] > 0) {
                    start = true;
                    stringBuilder.append(value[i]);
                }
            }
        }
        if (!start) {
            return "0";
        }
        return stringBuilder.toString();
    }

    private void plus(int[] value, int index, int num) {
        int tempValue = value[index];
        int sum = tempValue + num;
        int tenValue = sum / 10;
        int gw = sum % 10;
        value[index] = gw;
        if (tenValue > 0) {
            plus(value, index + 1, tenValue);
        }
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                sum++;
            }
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                if (temp == k) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> value = new ArrayList<>();
        pancakeSortPlay(arr, arr.length, value);
        return value;
    }

    private void pancakeSortPlay(int[] arr, int size, List<Integer> value) {
        if (size > 1) {
            int index = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[index]) {
                    index = i;
                }
            }

            int i = 0;
            int j = index;
            if (j > 0) {
                value.add(index + 1);
                while (i < j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }
            i = 0;
            j = size - 1;
            value.add(size);
            while (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            for (i = 1; i < size - 1; i++) {
                if (arr[i] < arr[i - 1]) {
                    pancakeSortPlay(arr, size - 1, value);
                    break;
                }
            }
        }
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (i + 1 >= nums.length || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public void solveSudoku(int[][] board) {
        backtrack(board, 0, 0);
    }

    boolean backtrack(int[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // 穷举到最后一列的话就换到下一行重新开始。
            return backtrack(board, i + 1, 0);
        }
        if (i == m) {
            // 找到一个可行解，触发 base case
            return true;
        }

        if (board[i][j] != 0) {
            // 如果有预设数字，不用我们穷举
            return backtrack(board, i, j + 1);
        }

        for (int ch = 1; ch <= 9; ch++) {
            // 如果遇到不合法的数字，就跳过
            if (!isValid(board, i, j, ch))
                continue;

            board[i][j] = ch;
            // 如果找到一个可行解，立即结束
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = 0;
        }
        // 穷举完 1~9，依然没有找到可行解，此路不通
        return false;
    }

    boolean isValid(int[][] board, int r, int c, int n) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[r][i] == n) return false;
            // 判断列是否存在重复
            if (board[i][c] == n) return false;
            // 判断 3 x 3 方框是否存在重复
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n)
                return false;
        }
        return true;
    }

    long cptMin = Integer.MAX_VALUE;

    public long cpt(int pt1, int pt2, int pt3) {
        cptPlay2(pt1, pt2, pt3, 0, 0, 0);
        return cptMin;
    }

    public void cptPlay2(int pt1, int pt2, int pt3, int ps1, int ps2, int ps3) {
        long[] nums = new long[]{pt1, pt2, pt3};
        Arrays.sort(nums);
        long sum = pt1 + pt2 + pt3;

        // 能够构成三角形，可完全平分
        if (nums[0] + nums[1] > nums[2]) {
            cptMin = (sum + 2) / 3;
            return;
        }
        // 不能构成三角形，平分最长边的情况
        if (2 * (nums[0] + nums[1]) < nums[2]) {
            cptMin = (nums[2] + 1) / 2;
            return;
        }
        // 不能构成三角形，但依然可以完全平分的情况
        cptMin = (sum + 2) / 3;
    }


    public void cptPlay(int pt1, int pt2, int pt3, int ps1, int ps2, int ps3) {
        if (pt1 == 0 && pt2 == 0 && pt3 == 0) {
            cptMin = Math.min(cptMin, Math.max(ps1, Math.max(ps2, ps3)));
        } else {
            if (pt1 > 0) {
                // 先吃PT1
                cptPlay(pt1 - 1, pt2, pt3, ps1 + 1, ps2, ps3);
                cptPlay(pt1 - 1, pt2, pt3, ps1, ps2, ps3 + 1);
            } else if (pt2 > 0) {
                // 再吃PT2
                cptPlay(pt1, pt2 - 1, pt3, ps1 + 1, ps2, ps3);
                cptPlay(pt1, pt2 - 1, pt3, ps1, ps2 + 1, ps3);
            } else {
                // 最后吃PT3
                cptPlay(pt1, pt2, pt3 - 1, ps1, ps2, ps3 + 1);
                cptPlay(pt1, pt2, pt3 - 1, ps1, ps2 + 1, ps3);
            }
        }
    }

    public class NestedIterator implements Iterator<Integer> {
        private LinkedList<Integer> values = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            play(nestedList);
        }

        private void play(List<NestedInteger> nestedList) {
            if (nestedList != null) {
                for (NestedInteger item : nestedList) {
                    if (item != null) {
                        if (item.isInteger()) {
                            values.add(item.getInteger());
                        } else {
                            play(item.getList());
                        }
                    }
                }
            }
        }

        @Override
        public Integer next() {
            return values.poll();
        }

        @Override
        public boolean hasNext() {
            return !values.isEmpty();
        }
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public String removeDuplicateLetters(String s) {
        char[] sArray = s.toCharArray();
        boolean[] sList = new boolean[256];
        StringBuilder strb = new StringBuilder();
        Stack<Character> task = new Stack<>();
        for (int i = sArray.length - 1; i >= 0; i--) {
            char item = sArray[i];
            if (!sList[item]) {
                sList[item] = true;
                task.push(item);
            }
        }
        while (!task.isEmpty()) {
            strb.append(task.pop());
        }
        return strb.toString();
    }

    public int search(String pat, String txt) {
        char[] patArray = pat.toCharArray();
        char[] txtArray = txt.toCharArray();
        for (int i = 0; i < txt.length() - pat.length(); i++) {
            for (int j = 0; j < pat.length(); j++) {
                if (txtArray[i + j] == patArray[j]) {
                    if (j == pat.length() - 1) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    // 有N部操作，最多可以输出多少A，只能按A、CTRL+A、CTRL+C、CTRLL+V
    public int maxA(int N) {
        // N步操作，每步操作最多可以获取多少个A
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            // 最少可以有这么多个A
            dp[i] = dp[i - 1] + 1;
            // j代表第几次按下的ctrl+c
            for (int j = 2; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[N];
    }

    public boolean stoneGame(int[] piles) {
        return stoneGamePlay(piles, 0, piles.length - 1, 0, 0, 0);
    }

    private boolean stoneGamePlay(int[] piles, int start, int end, int index, int ylkNums, int lNums) {
        if (start <= end) {
            if (index % 2 == 0) {
                if (piles[start] > piles[end]) {
                    return stoneGamePlay(piles, start + 1, end, index + 1, ylkNums + piles[start], lNums);
                } else {

                    return stoneGamePlay(piles, start, end - 1, index + 1, ylkNums + piles[end], lNums);
                }
            } else {
                if (piles[start] > piles[end]) {
                    return stoneGamePlay(piles, start + 1, end, index + 1, ylkNums, lNums + piles[start]);
                } else {
                    return stoneGamePlay(piles, start, end - 1, index + 1, ylkNums, lNums + piles[end]);
                }
            }
        } else {
            return ylkNums > lNums;
        }
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] arrays = s.toCharArray();
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int j = 2; j <= s.length(); j++) {
            for (int i = j - 1; i >= 1; i--) {
                if (arrays[i - 1] == arrays[j - 1]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[1][s.length()];
    }


    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        char[] arrays1 = text1.toCharArray();
        char[] arrays2 = text2.toCharArray();
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (arrays1[i - 1] == arrays2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public int maxCoins(int[] nums) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int item : nums) {
            list.add(item);
        }
        maxCoinsPlay(list, 0);
        return maxCoinsSum;
    }

    private int maxCoinsSum;


    private void maxCoinsPlay(LinkedList<Integer> list, int total) {
        if (list.size() == 1) {
            int temp = total + list.get(0);
            System.out.println(temp);
            if (temp > maxCoinsSum) {
                maxCoinsSum = temp;
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                int value = list.get(i);
                int temp;
                if (i == 0) {
                    temp = value * list.get(i + 1);
                } else if (i == list.size() - 1) {
                    temp = value * list.get(i - 1);
                } else {
                    temp = value * list.get(i - 1) * list.get(i + 1);
                }
                list.remove(i);
                maxCoinsPlay(list, total + temp);
                list.add(i, value);
            }
        }
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        } else if (word1 == null) {
            return word2.length();
        } else if (word2 == null) {
            return word1.length();
        } else {
            char[] chars1 = word1.toCharArray();
            char[] chars2 = word2.toCharArray();
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i <= word1.length(); i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= word2.length(); j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (chars1[i - 1] == chars2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i - 1][j - 1] + 1);
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }

    private Map<String, Integer> values = new HashMap<>();

    private int minPlay(char[] chars1, char[] chars2, int index1, int index2) {
        if (index1 < 0 && index2 < 0) {
            return 0;
        } else if (index1 < 0) {
            return index2 + 1;
        } else if (index2 < 0) {
            return index1 + 1;
        } else {
            String key = index1 + ":" + index2;
            if (values.containsKey(key)) {
                return values.get(key);
            }
            if (chars1[index1] == chars2[index2]) {
                int value = minPlay(chars1, chars2, index1 - 1, index2 - 1);
                values.put(key, value);
                return value;
            } else {
                int value = Math.min(Math.min(minPlay(chars1, chars2, index1, index2 - 1) + 1, minPlay(chars1, chars2, index1 - 1, index2) + 1), minPlay(chars1, chars2, index1 - 1, index2 - 1) + 1);
                values.put(key, value);
                return value;
            }
        }
    }

    public int change2(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public boolean canPartition2(int[] nums) {
        int total = 0;
        for (int item : nums) {
            total += item;
        }
        if (total % 2 == 1) {
            return false;
        }
        total = total / 2;
        boolean[][] dp = new boolean[nums.length + 1][total + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][total];
    }

    public int maxSubArray(int[] nums) {
        // 以自己结为的最大值
        int[] dp = new int[nums.length];
        System.arraycopy(nums, 0, dp, 0, nums.length);
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            // 要不只包含自己，要不包含自己和前一个总和的最大值
            int temp = Math.max(dp[i], dp[i] + dp[i - 1]);
            dp[i] = temp;
            if (temp > result) result = temp;
        }
        return result;
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // 至少只包含自己的长度是1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 如果num[j]<nums[i]证明最长序列至少可以在nums[j]的基础上再加1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int item : dp) {
            if (item > result) {
                result = item;
            }
        }
        return result;
    }

    public int findTargetSumWays2(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        // 由转换可以理解为，nums中有多少数可以组合相加得到(s+sum(nums))/2
        //sum(A) - sum(B) = target
        //sum(A) = target + sum(B)
        //sum(A) + sum(A) = target + sum(B) + sum(A)
        //2 * sum(A) = target + sum(nums)
        // 定义背包问题，背包大小为nums.length,有nums[]个物品可以放入，有多少种放法，可以让放入背包的物品重量为(s+sum(nums))/2
        int total = 0;
        for (int item : nums) total += item;
        int target = (S + total) / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j - nums[i - 1] >= 0) {
                    // 背包能放下nums[i-1]
                    // 此时有两种情况，即放下nums[i-1]和不放下nums[i-1]两种情况之和
                    dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i - 1]];
                } else {
                    // 背包不能放下nums[i-1]，取不能放下该值得值
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

    private int result = 0;
    private final List<String> list = new ArrayList<>();

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        play(nums, 0, 0, S);
        return result;
    }

    private void play(int[] nums, int temp, int index, int s) {
        if (index >= nums.length) {
            if (temp == s) {
                result += 1;
            }
        } else {
            int value = nums[index];
            if (!list.contains(temp + ":" + value)) {
                // 备忘录
                list.add(temp + ":" + value);
                play(nums, temp + value, index + 1, s);
                play(nums, temp - value, index + 1, s);
            }
        }
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        Boolean[][] resultMap = new Boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            resultMap[i][i] = true;
        }
        int start = 0;
        int end = 0;
        char[] arrays = s.toCharArray();
        int middle = 0;
        int i;
        int j;
        while (middle < s.length()) {
            i = middle;
            j = middle;
            while (i >= 0 && j < s.length()) {
                if (j != i && resultMap[i][j] == null) {
                    boolean result;
                    if (j == i + 1) {
                        result = arrays[i] == arrays[j];
                    } else {
                        result = resultMap[i + 1][j - 1] && arrays[i] == arrays[j];
                    }
                    resultMap[i][j] = result;
                    if (result) {
                        if (j - i > end - start) {
                            start = i;
                            end = j;
                        }
                    }
                }
                i--;
                j++;
            }
            i = middle;
            j = middle + 1;
            while (i >= 0 && j < s.length()) {
                if (j != i && resultMap[i][j] == null) {
                    boolean result;
                    if (j == i + 1) {
                        result = arrays[i] == arrays[j];
                    } else {
                        result = resultMap[i + 1][j - 1] && arrays[i] == arrays[j];
                    }
                    resultMap[i][j] = result;
                    if (result) {
                        if (j - i > end - start) {
                            start = i;
                            end = j;
                        }
                    }
                }
                i--;
                j++;
            }
            middle++;
        }
        return new String(arrays, start, end + 1 - start);
    }

    private boolean isSame(char[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] != array[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int coinChange(int[] coins, int amount) {
        /*if (amount == 0 || coins.length == 0) {
            return 0;
        }
        // 定义状态转移数组，选择到哪个硬币，拼凑到目标金额最少的零钱个数
        int[] status = new int[amount + 1];
        //  date base status[...][0] = 0
        // 状态转移
        for (int j = 1; j <= amount; j++) {
            status[j] = -1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // 如果背包还能放下coins[i-1](此处i-1只是取值用的)
                if (j - coins[i - 1] >= 0) {
                    // 如果不放硬币coins[i-1],去上一个值J
                    int noSize = status[j];
                    // 如果放硬币，取上一个值J-coins[i-1]
                    int inSize = status[j - coins[i - 1]];
                    if (noSize == -1 && inSize >= 0) {
                        status[j] = inSize + 1;
                    } else if (noSize >= 0 && inSize == -1) {
                        status[j] = noSize;
                    } else if (noSize == -1 && inSize == -1) {
                        status[j] = -1;
                    } else {
                        status[j] = Math.min(noSize, inSize + 1);
                    }
                } else {
                    // 背包不能放下了，取不放如coins[i-1]的值历史值
                    //status[j] = status[j];
                }
            }
        }
        return status[amount];*/
        if (amount == 0 || coins.length == 0) {
            return 0;
        }
        // 定义状态转移数组，选择到哪个硬币，拼凑到目标金额最少的零钱个数
        int[][] status = new int[coins.length + 1][amount + 1];
        //  date base status[...][0] = 0
        // 状态转移
        for (int j = 1; j <= amount; j++) {
            status[0][j] = -1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] == j) {
                    status[i][j] = 1;
                } else {
                    status[i][j] = -1;
                }
            }
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // 如果背包还能放下coins[i-1](此处i-1只是取值用的)
                if (j - coins[i - 1] >= 0) {
                    // 如果不放硬币coins[i-1],去上一个值J
                    int noSize = status[i - 1][j];
                    // 如果放硬币，取上一个值J-coins[i-1]
                    int inSize = status[i][j - coins[i - 1]];
                    if (noSize == -1 && inSize >= 0) {
                        status[i][j] = inSize + 1;
                    } else if (noSize >= 0 && inSize == -1) {
                        status[i][j] = noSize;
                    } else if (noSize == -1 && inSize == -1) {
                        status[i][j] = -1;
                    } else {
                        status[i][j] = Math.min(noSize, inSize + 1);
                    }
                } else {
                    // 背包不能放下了，取不放如coins[i-1]的值
                    status[i][j] = status[i - 1][j];
                }
            }
        }
        return status[coins.length][amount];
    }

    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins.length == 0) {
            return 0;
        }
        // 使用多少个硬币，拼凑出多少金额的方法数；
        int[][] values = new int[coins.length + 1][amount + 1];
        // value[0][...]应该都为0，因为不使用硬币拼不出任何金额
        // value[...][0]应该都为1，因为拼出金额为0，只有一种办法
        for (int i = 0; i <= coins.length; i++) {
            values[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // 如果背包大小还能装下con[i-1]这种硬币
                if (j - coins[i - 1] >= 0) {
                    // 使用i种硬币拼凑出j金额的方法数
                    // 不使用i这种硬币的方法数应该等于不使用i-1这种硬币拼凑出j金额的总数
                    int noUse = values[i - 1][j];
                    // 使用了i这种硬币，方法数应该等于使用了i这种硬币，金额刚好等于j-cons[i-1]这种组合的方法数
                    int use = values[i][j - coins[i - 1]];
                    values[i][j] = noUse + use;
                } else {
                    values[i][j] = values[i - 1][j];
                }
            }
        }
        // 返回最大硬币使用数，拼出amout的方法种类
        return values[coins.length][amount];
    }


    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int total = 0;
        for (int item : nums) {
            total += item;
        }
        if (total % 2 != 0) {
            return false;
        }
        total = total / 2;
        boolean[][] arrays = new boolean[nums.length][total + 1];
        for (int i = 0; i < nums.length; i++) {
            // 目标拼凑值为0，肯定是可以成功的
            arrays[i][0] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - nums[i] < 0) {
                    // 背包装不下了,取前一个能装下到J的值
                    arrays[i][j] = arrays[i - 1][j];
                } else {
                    // 不装入或者装入
                    arrays[i][j] = arrays[i - 1][j] || arrays[i - 1][j - nums[i]];
                }
            }
        }
        return arrays[nums.length - 1][total];
    }


    public static int cIndex(String str, String rex) {
        Boolean[][] isXT = new Boolean[str.length()][rex.length()];
        char[] strArray = str.toCharArray();
        char[] rexArray = rex.toCharArray();
        for (int i = 0; i <= str.length() - 1; i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (rex.equals(str.substring(i, j))) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public static List<List<Integer>> huishu(int[] nums) {
        List<Integer> value = new LinkedList<Integer>();
        for (int item : nums) {
            value.add(item);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempValue = new ArrayList<>();
        huishuPlay(value, result, tempValue);
        return result;
    }

    private static void huishuPlay
            (List<Integer> value, List<List<Integer>> result, List<Integer> tempValue) {
        if (value.isEmpty()) {
            result.add(new ArrayList<>(tempValue));
        } else {
            for (int i = 0; i < value.size(); i++) {
                int temp = value.get(i);
                tempValue.add(temp);
                value.remove(i);
                huishuPlay(value, result, tempValue);
                value.add(i, temp);
                tempValue.remove(tempValue.size() - 1);
            }
        }
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }
        long dividendL = dividend;
        long divisorL = divisor;
        boolean isF = (dividendL < 0 && divisorL > 0) || (dividendL > 0 && divisorL < 0);
        dividendL = Math.abs(dividendL);
        divisorL = Math.abs(divisorL);
        int sValue = 0;
        while (dividendL >= divisorL) {
            dividendL -= divisorL;
            if (sValue < Integer.MAX_VALUE) {
                sValue++;
            }
        }
        return isF ? -sValue : sValue;
    }

    /*int coinChange(int[] coins, int amount) {
        if (coins == null) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 获取历史值，根据历史值计算最小的适配的新值
                if (i - coin >= 0 && dp[i - coin] < min) {
                    min = dp[i - coin] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }*/

    /*int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int nums = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int temp = coins[0];
            if (amount >= temp) {
                amount = amount - temp;
                i++;
                nums++;
            }
        }
        return amount == 0 ? nums : -1;
    }*/

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int p = nums.length;
        for (int i = 0; i < nums.length && i < p; i++) {
            if (nums[i] == val) {
                p--;
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                // 步进减一(原地)，检查新移动过来的数是否还是和val相等
                i--;
            }
        }
        return p;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= 1) {
            return 1;
        }
        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[p]) {
                if (p + 1 != i) {
                    nums[p + 1] = nums[i];
                }
                p += 1;
            }
        }
        return p + 1;
    }

    private static void move(int[] nums, int index) {
        int temp = nums[index];
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = temp;
    }

    /*public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        list.add(temp.val);
        while (temp.next != null) {
            list.add(temp.next.val);
            temp = temp.next;
        }
        List<Integer> listDx = new ArrayList<>();
        while (k <= list.size()) {
            List<Integer> listTemp = list.subList(0, k);
            for (int i = listTemp.size() - 1; i >= 0; i--) {
                listDx.add(listTemp.get(i));
            }
            list = list.subList(k, list.size());
        }
        if (list.size() > 0) {
            listDx.addAll(list);
        }
        ListNode reNode = new ListNode();
        temp = reNode;
        int i = 0;
        while (i < listDx.size()) {
            temp.val = listDx.get(i);
            if (i < listDx.size() - 1) {
                temp.next = new ListNode();
                temp = temp.next;
            }
            i++;
        }
        return reNode;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 先交换
        ListNode node = head.next;
        head.next = swapPairs(node.next);
        node.next = head;
        return node;
    }*/


    /*public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0 || lists[0] == null) {
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>(Arrays.asList(lists));
        int index = 0;
        // 取出第一个最小的值
        for (int i = 1; i < listNodes.size(); i++) {
            if (listNodes.get(i) != null && listNodes.get(i).val < listNodes.get(index).val) {
                index = i;
            }
        }
        // 定义第一个最小的值
        ListNode value = listNodes.get(index);
        // 删除集合中的该值
        listNodes.remove(index);
        if (value.next != null) {
            // 如果该节点还有下一个节点，把下一个节点加入集合中，
            listNodes.add(value.next);
        }
        // 如果集合中还有值，继续迭代
        if (listNodes.size() > 0) {
            value.next = mergeKLists(listNodes.toArray(new ListNode[0]));
        }
        return value;
    }*/

    public static List<String> generateParenthesis2(int n) {
        List<String> value = new ArrayList<>();
        play2("", n, n, value);
        return value;
    }

    public static void play2(String s, int left, int right, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(s);
        }
        // 左括号的剩余量要小于右括号，即左括号比右括号用的多
        if (left <= right) {
            // 到目前为止，如右括号比左括号用的多，是错误的
            if (left > 0) {
                play2(s + "(", left - 1, right, list);
            }
            if (right > 0) {
                play2(s + ")", left, right - 1, list);
            }
        }
    }


    public static List<String> generateParenthesis(int n) {
        List<String> value = new ArrayList<>();
        play(n * 2, 0, value, new StringBuilder());
        return value;
    }

    private static void play(int n, int index, List<String> list, StringBuilder strb) {
        if (index == n) {
            String value = strb.toString();
            if (check(value)) {
                list.add(value);
            }
        } else {
            play(n, index + 1, list, strb.append('('));
            strb.deleteCharAt(strb.length() - 1);
            play(n, index + 1, list, strb.append(')'));
            strb.deleteCharAt(strb.length() - 1);
        }
    }

    private static boolean check(String value) {
        char[] arrays = value.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character item : arrays) {
            if (item == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty() || stack.pop() != item) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    /*public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result;
        ListNode temp1;
        ListNode temp2;
        if (l2.val < l1.val) {
            result = l2;
            temp1 = l1;
            temp2 = l2.next;
        } else {
            result = l1;
            temp1 = l1.next;
            temp2 = l2;
        }
        ListNode tempNode = result;
        while (temp1 != null || temp2 != null) {
            if (temp1 != null && temp2 != null) {
                if (temp2.val < temp1.val) {
                    tempNode.next = temp2;
                    temp2 = temp2.next;
                } else {
                    tempNode.next = temp1;
                    temp1 = temp1.next;
                }
            } else if (temp1 != null) {
                tempNode.next = temp1;
                temp1 = temp1.next;
            } else {
                tempNode.next = temp2;
                temp2 = temp2.next;
            }
            tempNode = tempNode.next;
        }
        return result;
    }*/

    public boolean isValid(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] inputs = s.toCharArray();
        for (char item : inputs) {
            if (item == '(') {
                stringBuilder.append('(');
            } else if (item == '[') {
                stringBuilder.append('[');
            } else if (item == '{') {
                stringBuilder.append('{');
            } else if (item == ')') {
                if (stringBuilder.length() == 0) {
                    return false;
                }
                if (stringBuilder.charAt(stringBuilder.length() - 1) == '(') {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                } else {
                    return false;
                }
            } else if (item == ']') {
                if (stringBuilder.length() == 0) {
                    return false;
                }
                if (stringBuilder.charAt(stringBuilder.length() - 1) == '[') {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                } else {
                    return false;
                }
            } else if (item == '}') {
                if (stringBuilder.length() == 0) {
                    return false;
                }
                if (stringBuilder.charAt(stringBuilder.length() - 1) == '{') {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                } else {
                    return false;
                }
            }
        }
        return stringBuilder.length() == 0;
    }

    /*public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }
        n = size - n;
        if (n == 0) {
            return head.next;
        }
        int index = 0;
        temp = head;
        while (index != n - 1) {
            temp = temp.next;
            index++;
        }
        // 此时 temp为要删除的节点的上一个节点
        // 取值要删除的节点的下一个节点;
        ListNode next = temp.next.next;
        temp.next = temp.next.next;
        return head;
    }*/

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去重复
                continue;
            }
            // 计算最小值,如果最小值大于目标值，跳过，后面的不再计算
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                continue;
            }
            // 计算最大值，如果最大值小于目标值，跳过，后面的不再计算
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    // 去重复
                    continue;
                }
                // 计算最小值,如果最小值大于目标值，跳过，后面的不再计算
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    continue;
                }
                // 计算最大值，如果最大值小于目标值，跳过，后面的不再计算
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) {
                    continue;
                }

                int value1 = nums[i];
                int value2 = nums[j];
                int index3 = j + 1;
                int index4 = nums.length - 1;
                while (index3 < index4) {
                    if (index3 > j + 1 && nums[index3] == nums[index3 - 1]) {
                        // 去重
                        index3++;
                        continue;
                    }
                    if (index4 < nums.length - 1 && nums[index4] == nums[index4 + 1]) {
                        // 去重
                        index4--;
                        continue;
                    }
                    int value3 = nums[index3];
                    int value4 = nums[index4];
                    int temp = value1 + value2 + value3 + value4;
                    if (temp == target) {
                        List<Integer> tempValue = new ArrayList<>();
                        tempValue.add(value1);
                        tempValue.add(value2);
                        tempValue.add(value3);
                        tempValue.add(value4);
                        result.add(tempValue);
                        index3++;
                        index4--;
                    } else {
                        if (temp > target) {
                            index4--;
                        } else {
                            index3++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Character, Character[]> value = new HashMap<>();
        value.put('2', new Character[]{'a', 'b', 'c'});
        value.put('3', new Character[]{'d', 'e', 'f'});
        value.put('4', new Character[]{'g', 'h', 'i'});
        value.put('5', new Character[]{'j', 'k', 'l'});
        value.put('6', new Character[]{'m', 'n', 'o'});
        value.put('7', new Character[]{'p', 'q', 'r', 's'});
        value.put('8', new Character[]{'t', 'u', 'v'});
        value.put('9', new Character[]{'w', 'x', 'y', 'z'});
        char[] input = digits.toCharArray();
        List<String> result = new ArrayList<>();
        getValue(input, 0, value, result, "");
        return result;
    }

    private void getValue(char[] input, int index, Map<Character, Character[]> value, List<String> list, String
            temp) {
        for (char item : value.get(input[index])) {
            if (index == input.length - 1) {
                list.add(temp + item);
            } else {
                getValue(input, index + 1, value, list, temp + item);
            }
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        int result = nums[0] + nums[1] + nums[2];
        int value = Math.abs(result - target);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int tempResult = nums[i] + nums[j] + nums[k];
                    int tempValue = Math.abs(tempResult - target);
                    if (tempValue < value) {
                        result = tempResult;
                        value = tempValue;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> values = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> value = new ArrayList<>();
                        value.add(nums[i]);
                        value.add(nums[j]);
                        value.add(nums[k]);
                        values.add(value);
                    }
                }
            }
        }
        return values;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String syStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String db = strs[i];
            if (!db.startsWith(syStr)) {
                while (syStr.length() > 0) {
                    syStr = syStr.substring(0, syStr.length() - 1);
                    if (db.startsWith(syStr)) {
                        break;
                    }
                }
                if (syStr.length() == 0) {
                    return "";
                }
            }
        }
        return syStr;
    }

    public static int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        String[] lm = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] mValue = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int value = 0;
        int i = 0;
        while (s.length() > 0 && i < lm.length) {
            if (s.startsWith(lm[i])) {
                value += mValue[i];
                s = s.substring(lm[i].length());
            } else {
                i++;
            }
        }
        return value;
    }

    public String intToRoman(int num) {
        StringBuilder strb = new StringBuilder();
        int mValue = num / 1000;
        if (mValue > 0) {
            for (int i = 0; i < mValue; i++) {
                strb.append("M");
            }
        }
        num = num % 1000;
        mValue = num / 100;
        if (mValue > 0) {
            if (mValue == 1) {
                strb.append("C");
            } else if (mValue == 2) {
                strb.append("CC");
            } else if (mValue == 3) {
                strb.append("CCC");
            } else if (mValue == 4) {
                strb.append("CD");
            } else if (mValue == 5) {
                strb.append("D");
            } else if (mValue == 6) {
                strb.append("DC");
            } else if (mValue == 7) {
                strb.append("DCC");
            } else if (mValue == 8) {
                strb.append("DCCC");
            } else if (mValue == 9) {
                strb.append("CM");
            }
        }
        num = num % 100;
        mValue = num / 10;
        if (mValue > 0) {
            if (mValue == 1) {
                strb.append("X");
            } else if (mValue == 2) {
                strb.append("XX");
            } else if (mValue == 3) {
                strb.append("XXX");
            } else if (mValue == 4) {
                strb.append("XL");
            } else if (mValue == 5) {
                strb.append("L");
            } else if (mValue == 6) {
                strb.append("LX");
            } else if (mValue == 7) {
                strb.append("LXX");
            } else if (mValue == 8) {
                strb.append("LXXX");
            } else if (mValue == 9) {
                strb.append("XC");
            }
        }
        num = num % 10;
        mValue = num;
        if (mValue > 0) {
            if (mValue == 1) {
                strb.append("I");
            } else if (mValue == 2) {
                strb.append("II");
            } else if (mValue == 3) {
                strb.append("III");
            } else if (mValue == 4) {
                strb.append("IV");
            } else if (mValue == 5) {
                strb.append("V");
            } else if (mValue == 6) {
                strb.append("VI");
            } else if (mValue == 7) {
                strb.append("VII");
            } else if (mValue == 8) {
                strb.append("VIII");
            } else if (mValue == 9) {
                strb.append("IX");
            }
        }
        return strb.toString();
    }

    public int maxArea(int[] height) {
        int max = Math.min(height[0], height[1]);
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int are = (j - i) * Math.min(height[i], height[j]);
                if (are > max) {
                    max = are;
                }
            }
        }
        return max;
    }

    public boolean isMatch2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s.equals(p)) {
            return true;
        }
        if (s.isEmpty()) {
            return p.endsWith("*") && p.length() <= 2;
        }
        if (p.isEmpty()) {
            return false;
        }
        char[] sArrays = s.toCharArray();
        char[] pArrays = p.toCharArray();
        char[] sdArrays = new char[sArrays.length];
        char[] pdArrays = new char[pArrays.length];
        for (int i = sArrays.length - 1, j = 0; i >= 0; i--, j++) {
            sdArrays[j] = sArrays[i];
        }
        for (int i = pArrays.length - 1, j = 0; i >= 0; i--, j++) {
            pdArrays[j] = pArrays[i];
        }
        boolean isX = false;
        char cx = 0;
        int sIndex = 0;
        int pIndex = 0;
        while (sIndex < sdArrays.length && pIndex < pdArrays.length) {
            char sdc = sdArrays[sIndex];
            char pdc = pdArrays[pIndex];
            if (sdc == pdc) {
                isX = false;
                sIndex += 1;
                pIndex += 1;
            } else {
                if (pdc == '.') {
                    isX = false;
                    pIndex += 1;
                } else if (pdc == '*') {
                    isX = true;
                    cx = pdArrays[pIndex + 1];
                    pIndex += 2;
                    if (pIndex >= pdArrays.length) {
                        for (char item : sdArrays) {
                            if (item != cx) {
                                return false;
                            }
                        }
                        return true;
                    }
                } else {
                    if (isX) {
                        if (cx == sdc) {
                            sIndex += 1;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return sIndex == s.length() && pIndex == p.length();
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s.equals(p)) {
            return true;
        }
        if (s.isEmpty() || p.isEmpty()) {
            return false;
        }
        int sIndex = 0;
        int pIndex = 0;
        char[] sArrays = s.toCharArray();
        char[] pArrays = p.toCharArray();
        boolean isX = false;
        while (sIndex < s.length() && pIndex < p.length()) {
            char cs = sArrays[sIndex];
            char cp = pArrays[pIndex];
            if (cs == cp) {
                isX = false;
                sIndex += 1;
                pIndex += 1;
            } else {
                if (cp == '.') {
                    sIndex += 1;
                    pIndex += 1;
                } else if (cp == '*') {
                    isX = true;
                    sIndex += 1;
                    pIndex += 1;
                } else {
                    if (isX) {
                        sIndex += 1;
                        continue;
                    }
                    return false;
                }
            }
        }
        return sIndex == s.length() && pIndex == p.length();
    }

    public static boolean isPalindrome(int x) {
        String old = String.valueOf(x);
        char[] oldc = old.toCharArray();
        StringBuilder strb = new StringBuilder(old.length());
        for (int i = old.length() - 1; i >= 0; i--) {
            strb.append(oldc[i]);
        }
        return old.equals(strb.toString());
    }

    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        String value = str.trim();
        if (value.length() == 0) {
            return 0;
        }
        boolean isPositiveNumber = true;
        String result;
        if (value.startsWith("-")) {
            isPositiveNumber = false;
            result = value.substring(1);
        } else if (value.startsWith("+")) {
            result = value.substring(1);
        } else {
            result = value;
        }
        if (result.length() == 0) {
            return 0;
        }
        StringBuilder resultBuild = new StringBuilder();
        char[] resultArrays = result.toCharArray();
        for (char item : resultArrays) {
            if (item >= '0' && item <= '9') {
                resultBuild.append(item);
            } else {
                break;
            }
        }
        if (resultBuild.length() == 0) {
            return 0;
        }
        long longValue;
        try {
            longValue = Long.parseLong(resultBuild.toString());
            if (!isPositiveNumber) {
                longValue = -longValue;
            }
        } catch (Exception e) {
            if (!isPositiveNumber) {
                longValue = Integer.MIN_VALUE;
            } else {
                longValue = Integer.MAX_VALUE;
            }
        }

        if (longValue > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (longValue < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) longValue;
    }


    public static String convert(String s, int numRows) {
        if (s == null || numRows == 1 || s.length() < numRows) {
            return s;
        } else {
            char[] old = s.toCharArray();
            StringBuilder[] values = new StringBuilder[numRows];
            int stride = numRows + numRows - 2;
            for (int i = 0; i < s.length(); i++) {
                int remainder = i % stride;
                int index;
                if (remainder < numRows) {
                    index = remainder;

                } else {
                    index = (numRows - 1) - (remainder - (numRows - 1));
                }
                StringBuilder strb = values[index];
                if (strb == null) {
                    strb = new StringBuilder();
                    values[index] = strb;
                }
                strb.append(old[i]);
            }
            StringBuilder result = new StringBuilder();
            for (StringBuilder item : values) {
                result.append(item);
            }
            return result.toString();
        }
    }
}
