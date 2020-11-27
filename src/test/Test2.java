package test;

import javafx.concurrent.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Test2 {
    public static void main(String[] args) {
//        int[] value = new int[]{3, 5, 1, 9, 6, 4, 8};
//        insert(value);
//        for (int item : value) {
//            System.out.print(item + " ");
//        }
        //System.out.println(Integer.parseInt("5.0".split("\\.")[0]));
//        long time = 0;
//        while (time >= 0) {
//            time = System.currentTimeMillis() - time;
//            new Test2();
//        }
        // u000a System.out.println("Hello World!");
//        for (int j = 0; j < 1000000; j++) {
//            List<String> arrays = new ArrayList<>(6);
//            for (int i = 0; i < 6; i++) {
//                arrays.add(String.valueOf(i));
//            }
//            List<String> value = new LinkedList<>();
//            getAll(arrays, 0, value, "");
//            for (String item : value) {
//                System.out.println(item);
//            }
//        }
//        ListNode first = new ListNode(2);
//        first.next = new ListNode(4);
//        first.next.next = new ListNode(3);
//        ListNode seconed = new ListNode(5);
//        seconed.next = new ListNode(6);
//        seconed.next.next = new ListNode(4);
//        addTwoNumbers(first, seconed);
//        int[] nums = new int[]{1, 1, 1, 1};
//        for (List<Integer> list : new Test2().threeSum(nums)) {
//            for (Integer item : list) {
//                System.out.print(item + " ");
//            }
//            System.out.println("");
//        }
//        long time = System.currentTimeMillis();
//        int[] nums = new int[]{1, 1, 2};
//        new Test2().removeDuplicates(nums);
//        for (int item : nums) {
//            System.out.print(item);
//        }
        //System.out.print(new Test2().findSubstring("pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel", new String[]{"dhvf", "sind", "ffsl", "yekr", "zwzq", "kpeo", "cila", "tfty", "modg", "ztjg", "ybty", "heqg", "cpwo", "gdcj", "lnle", "sefg", "vimw", "bxcb"}));
        try {
            long startTime = System.currentTimeMillis();

            System.out.println(new Test2().multiply("123", "456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String multiply(String num1, String num2) {
        if (num1.matches("[0]+") || num2.matches("[0]+")) {
            return "0";
        }
        List<Integer> value = new ArrayList<>();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int ii = Integer.parseInt(String.valueOf(num1.charAt(i)));
            for (int j = num2.length() - 1; j >= 0; j--) {
                int temp = ii * Integer.parseInt(String.valueOf(num2.charAt(j)));
                addPlus(value, temp, (num1.length() - 1 - i) + (num2.length() - 1 - j));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = value.size() - 1; i >= 0; i--) {
            stringBuilder.append(value.get(i));
        }
        return stringBuilder.toString();
    }

    private void addPlus(List<Integer> value, int add, int index) {
        if (value.size() <= index) {
            value.add(add % 10);
            if (add >= 10) {
                addPlus(value, add / 10, index + 1);
            }
        } else {
            int temp = value.get(index) + add;
            value.set(index, temp % 10);
            if (temp >= 10) {
                addPlus(value, temp / 10, index + 1);
            }
        }
    }

    public int trap(int[] height) {
        // 至高点
        int maxIndex = 0;
        // 找出至高点
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
        }
        // 定义总蓄水量
        int total = 0;
        // 至高点往左边的蓄水量
        int leftStartIndex = 0;
        for (int i = 1; i <= maxIndex; i++) {
            // 依次找出比左边的高点
            if (height[i] >= height[leftStartIndex]) {
                for (int s = leftStartIndex + 1; s < i; s++) {
                    // 累加蓄水量
                    total += height[leftStartIndex] - height[s];
                }
                // 左边新的高点
                leftStartIndex = i;
            }
        }
        // 至高点往右边的蓄水量
        int rightStartIndex = height.length - 1;
        for (int i = height.length - 2; i >= maxIndex; i--) {
            // 依次找出比右边的高点
            if (height[i] >= height[rightStartIndex]) {
                for (int s = rightStartIndex - 1; s > i; s--) {
                    // 累加蓄水量
                    total += height[rightStartIndex] - height[s];
                }
                // 左边新的高点
                rightStartIndex = i;
            }
        }
        return total;
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        if (nums[0] >= 2) {
            return 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                if (nums[i - 1] + 1 > 0) {
                    return nums[i - 1] + 1;
                } else {
                    if (nums[i] >= 2) {
                        return 1;
                    }
                }
            }
        }
        return nums[nums.length - 1] <= 0 ? 1 : nums[nums.length - 1] + 1;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] use = new boolean[candidates.length];
        List<String> tempHash = new ArrayList<>();
        play22(list, temp, candidates, use, tempHash, target);
        return list;
    }

    private void play22(List<List<Integer>> list, List<Integer> temp, int[] candidates, boolean[] use, List<String> tempHash, int target) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < candidates.length; i++) {
                if (use[i]) {
                    continue;
                }
                if (target >= candidates[i]) {
                    use[i] = true;
                    temp.add(candidates[i]);
                    play22(list, temp, candidates, use, tempHash, target - candidates[i]);
                    temp.remove(temp.size() - 1);
                    use[i] = false;
                }
            }
        }
    }

    private String toString(List<Integer> temp) {
        StringBuilder strb = new StringBuilder();
        for (Integer item : temp) {
            strb.append(item);
        }
        return strb.toString();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        play2(list, temp, candidates, target);
        return list;
    }


    private void play2(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target) {
        if (target == 0) {
            List<Integer> listtemp = new ArrayList<>(temp);
            listtemp.sort(Integer::compareTo);
            if (list.isEmpty()) {
                list.add(listtemp);
                return;
            }
            for (List<Integer> tempV : list) {
                if (tempV.size() == listtemp.size()) {
                    boolean isSample = true;
                    for (int i = 0; i < listtemp.size(); i++) {
                        isSample = isSample && tempV.get(i).equals(listtemp.get(i));
                    }
                    if (isSample) {
                        return;
                    }
                }
            }
            list.add(listtemp);
        } else {
            for (int item : candidates) {
                if (target >= item) {
                    temp.add(item);
                    play2(list, temp, candidates, target - item);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public void solveSudoku(char[][] board) {
        // 第i行，第‘j’个字符是否已经包含(字符'1'~'9'转行成坐标0~8,如row[0][0]为true ,就标识第0行已经包含'1'这个字符了)
        boolean[][] row = new boolean[9][9];
        // 第j列，第'i'个字符是否已经包含
        boolean[][] col = new boolean[9][9];
        // 第index个小宫格（9个宫格），第'i'个字符是否已经包含
        boolean[][] box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char item = board[i][j];
                if (item != '.') {
                    // 把字符item转换为坐标，-‘1’即可
                    int index = item - '1';
                    // 第几个宫格
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (row[i][index] || col[j][index] || box[boxIndex][index]) {
                        // 行、列、九宫格任何一个已经包含item字符串，返回false
                        throw new IllegalArgumentException("出错");
                    }
                    row[i][index] = true;
                    col[j][index] = true;
                    box[boxIndex][index] = true;
                }
            }
        }
        solveSudoku(board, row, col, box, 0, 0);
    }

    public boolean solveSudoku(char[][] board, boolean[][] row, boolean[][] col, boolean[][] box, int i, int j) {
        if (i == 9) {
            return true;
        } else {
            char item = board[i][j];
            if (item == '.') {
                // 第几个宫格
                int boxIndex = (i / 3) * 3 + j / 3;
                for (int c = 0; c < 9; c++) {
                    if (row[i][c] || col[j][c] || box[boxIndex][c]) {
                        continue;
                    }
                    board[i][j] = (char) (c + '1');
                    row[i][c] = true;
                    col[j][c] = true;
                    box[boxIndex][c] = true;
                    boolean next = (j >= 8) ? solveSudoku(board, row, col, box, i + 1, 0) : solveSudoku(board, row, col, box, i, j + 1);
                    if (next) {
                        return true;
                    } else {
                        row[i][c] = false;
                        col[j][c] = false;
                        box[boxIndex][c] = false;
                    }
                }
                board[i][j] = '.';
                return false;
            } else {
                if (j >= 8) {
                    return solveSudoku(board, row, col, box, i + 1, 0);
                } else {
                    return solveSudoku(board, row, col, box, i, j + 1);
                }
            }
        }
    }

    public boolean isValidSudoku(char[][] board) {
        // 第i行，第‘j’个字符是否已经包含(字符'1'~'9'转行成坐标0~8,如row[0][0]为true ,就标识第0行已经包含'1'这个字符了)
        boolean[][] row = new boolean[9][9];
        // 第j列，第'i'个字符是否已经包含
        boolean[][] col = new boolean[9][9];
        // 第index个小宫格（9个宫格），第'i'个字符是否已经包含
        boolean[][] box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char item = board[i][j];
                if (item != '.') {
                    // 把字符item转换为坐标，-‘1’即可
                    int index = item - '1';
                    // 第几个宫格
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (row[i][index] || col[j][index] || box[boxIndex][index]) {
                        // 行、列、九宫格任何一个已经包含item字符串，返回false
                        return false;
                    }
                    row[i][index] = true;
                    col[j][index] = true;
                    box[boxIndex][index] = true;
                }
            }
        }
        return true;
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] > target) {
            return 0;
        }
        if (nums[end] < target) {
            return end + 1;
        }
        while (start < end) {
            int middle = (end + start) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                end = middle;
            } else {
                if (middle == start) {
                    // 此时数组中没有目标值
                    return end;
                } else {
                    start = middle;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int[] value = new int[2];
        Arrays.fill(value, -1);
        while (i <= j) {
            if (value[0] == -1) {
                if (nums[i] == target) {
                    value[0] = i;
                } else if (nums[i] < target) {
                    i++;
                } else {
                    break;
                }
            }
            if (value[1] == -1) {
                if (nums[j] == target) {
                    value[1] = j;
                } else if (nums[j] > target) {
                    j--;
                } else {
                    break;
                }
            }
            if (value[0] != -1 && value[1] != -1) {
                break;
            }
        }
        return value;
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.trim().length() == 0 || s.trim().length() == 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int maxLength = 0;
        // 从后往前遍历
        // 从index(含)往右的最长合法长度坐标
        int[] startIndex = new int[s.length()];
        Arrays.fill(startIndex, -1);
        // 从index(含)往左的最长合法长度坐标
        int[] endIndex = new int[s.length()];
        Arrays.fill(endIndex, Integer.MAX_VALUE);
        for (int j = s.length() - 2; j >= 0; j--) {
            // 左边必须是'('
            if (chars[j] != '(') {
                continue;
            }
            for (int i = j + 1; i < s.length(); i++) {
                // 右边必须是')'构成偶数长度才是括号
                if (chars[i] != ')' || (i - j) % 2 == 0) {
                    continue;
                }
                boolean tempValue = false;
                if (i - j == 1) {
                    // () 构成括号
                    tempValue = true;
                } else {
                    // (**) **的合法长度必须覆盖子串**的长度
                    int startEndIndex = startIndex[j + 1];
                    int endStartIndex = endIndex[i - 1];
                    if (startEndIndex == i - 1 && endStartIndex == j + 1) {
                        tempValue = true;
                    }
                    // ()()((())) 左边往右的最长合法长度+右边往左的合法长度刚好覆盖子串长度，则子串为合法规则串
                    if (!tempValue) {
                        startEndIndex = startIndex[j];
                        endStartIndex = endIndex[i];
                        if (startEndIndex >= endStartIndex - 1) {
                            tempValue = true;
                        }
                    }
                }
                if (tempValue) {
                    if (startIndex[j] < i) {
                        startIndex[j] = i;
                    }
                    if (endIndex[i] > j) {
                        endIndex[i] = j;
                    }
                    int temLength = i - j + 1;
                    if (temLength > maxLength) {
                        // 比现有的长度长
                        maxLength = temLength;
                    }
                }
            }
        }
        return maxLength;
    }


    public void test() throws Exception {
        Random random = new Random();
        int i = 0;
        while (i < 100000) {
            File fl = new File("E:\\aa\\" + System.currentTimeMillis() + random.nextLong() + ".text");
            FileOutputStream fileOutputStream = new FileOutputStream(fl);
            fileOutputStream.write("pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel".getBytes(Charset.defaultCharset()));
            fileOutputStream.flush();
            fileOutputStream.close();
            fl.delete();
            i++;
        }
    }


    public void nextPermutation(int[] nums) {
        boolean isSet = false;
        // 从倒数第二个数开始，往左推，找到比i大的位于最右边的元素
        for (int i = nums.length - 2; i >= 0; i--) {
            int index = -1;
            // 找到比i大的位于最右边的元素
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    index = j;
                }
            }
            if (index != -1) {
                // 成功找到，交换元素，
                nums[i] = nums[i] + nums[index];
                nums[index] = nums[i] - nums[index];
                nums[i] = nums[i] - nums[index];
                isSet = true;
                // 对交换的最右边的元素后面的元素进行升序排列
                Arrays.sort(nums, i + 1, nums.length);
                break;
            }
        }
        if (!isSet) {
            // 没有找到可交换的元素，怎么序列是降序排序，此时做升序排序
            Arrays.sort(nums);
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        // 结果集
        List<Integer> result = new ArrayList<>();
        if (words.length > 0 && s != null) {
            //字符集长度
            int wordLength = words[0].length();
            // 存储字符集的个数
            Map<String, Integer> wordsMap = new HashMap<>();
            for (String item : words) {
                wordsMap.merge(item, 1, Integer::sum);
            }
            for (int i = 0; i < s.length() - wordLength + 1; i++) {
                // 核对出现连续匹配的单词个数
                int count = 0;
                // 核对连续出现的单词对应的次数
                Map<String, Integer> subMap = new HashMap<>();
                for (int j = i; j < s.length() - wordLength + 1; j += wordLength) {
                    String subS = s.substring(j, j + wordLength);
                    if (wordsMap.containsKey(subS)) {
                        // 找到了匹配的字符串
                        Integer value = subMap.get(subS);
                        if (value == null) {
                            value = 1;
                        } else {
                            value++;
                        }
                        // 如果匹配的次数大于单词拥有的个数，证明匹配失败，跳出本次循环
                        if (value > wordsMap.get(subS)) {
                            break;
                        } else {
                            subMap.put(subS, value);
                        }
                        count++;
                    } else {
                        // 没有出现连续匹配的情况了，跳出本次循环，在循环外检查结果
                        break;
                    }
                }
                if (count == words.length) {
                    // 完全连续命中
                    result.add(i);
                }
            }
        }
        return result;
    }

    private void pay(List<String> input, List<String> value, StringBuilder stringBuilder) {
        if (input.isEmpty()) {
            String value1 = stringBuilder.toString();
            if (!value.contains(value1)) {
                value.add(value1);
            }
        } else {
            for (int i = 0; i < input.size(); i++) {
                String temp = input.get(i);
                input.remove(i);
                stringBuilder.append(temp);
                pay(input, value, stringBuilder);
                stringBuilder.delete(stringBuilder.length() - temp.length(), stringBuilder.length());
                input.add(i, temp);
            }
        }
    }

    public int divide(int dividend, int divisor) {
        long divLong = dividend;
        long divsLong = divisor;
        long value = 0;
        boolean isBCat = divLong < 0;
        divLong = Math.abs(divLong);
        boolean isCat = divsLong < 0;
        divsLong = Math.abs(divsLong);
        while (divLong >= divsLong) {
            divLong -= divsLong;
            value++;
        }
        if (isBCat && isCat) {
            return (int) value;
        } else if (isBCat || isCat) {
            return (int) -value;
        } else {
            return (int) value;
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            int value = matrix[i][j];
            if (value == target) {
                return true;
            } else if (value > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 定义结果集
        int[] result = new int[nums.length - k + 1];
        // 模拟双端队列(存储的是下标)
        List<Integer> dl = new ArrayList<>(k);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!dl.isEmpty() && i - dl.get(0) >= k) {
                // 去除超出的队首元素(队首元素下标超出窗口值)
                dl.remove(0);
            }
            // 保证队首的元素是最大的
            while (!dl.isEmpty() && nums[dl.get(dl.size() - 1)] < num) {
                dl.remove(dl.size() - 1);
            }
            // 塞入队列
            dl.add(i);
            if (i >= k - 1) {
                // 形成窗口，添加队首元素入结果队列
                result[index++] = nums[dl.get(0)];
            }
        }
        return result;
    }

    public int removeElement(int[] nums, int val) {
        int sum = 0;
        for (int i = 0; i < nums.length - sum; i++) {
            if (nums[i] == val) {
                sum++;
                for (int j = i; j < nums.length - sum; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
            }
        }
        return nums.length - sum;
    }

    public int removeDuplicates(int[] nums) {
        int sum = 0;
        for (int i = 1; i < nums.length - sum; i++) {
            if (nums[i] == nums[i - 1]) {
                sum++;
                for (int j = i; j < nums.length - sum; j++) {
                    nums[j] = nums[j + 1];
                }
            }
        }
        return sum;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        List<ListNode> result = new ArrayList<>();
        result.add(head);
        while (head.next != null) {
            result.add(head.next);
            head = head.next;
        }
        for (ListNode item : result) {
            item.next = null;
        }
        ListNode[] arrays = new ListNode[result.size()];
        result.toArray(arrays);
        for (int i = 0; i < arrays.length; i += k) {
            if (i + k > arrays.length) {
                break;
            }
            int start = i;
            int end = i + k - 1;
            while (start < end) {
                ListNode temp = arrays[start];
                arrays[start] = arrays[end];
                arrays[end] = temp;
                start++;
                end--;
            }
        }
        for (int i = 0; i < arrays.length - 1; i++) {
            arrays[i].next = arrays[i + 1];
        }
        return arrays[0];
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> first = new ArrayList<>();
        List<ListNode> second = new ArrayList<>();
        first.add(head);
        int i = 0;
        while (head.next != null) {
            if (i % 2 == 0) {
                second.add(head.next);
            } else {
                first.add(head.next);
            }
            i++;
            head = head.next;
        }
        for (ListNode item : first) {
            item.next = null;
        }
        for (ListNode item : second) {
            item.next = null;
        }
        List<ListNode> result = new ArrayList<>();
        for (i = 0; i < first.size(); i++) {
            if (i < second.size()) {
                result.add(second.get(i));
            }
            result.add(first.get(i));
        }
        for (i = 0; i < result.size() - 1; i++) {
            result.get(i).next = result.get(i + 1);
        }
        return result.get(0);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> result = new ArrayList<>();
        for (ListNode item : lists) {
            if (item != null) {
                result.add(item);
                while (item.next != null) {
                    result.add(item.next);
                    item = item.next;
                }
            }
        }
        if (result.size() == 0) {
            return null;
        }
        for (ListNode item : result) {
            item.next = null;
        }
        result.sort(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < result.size() - 1; i++) {
            result.get(i).next = result.get(i + 1);
        }
        return result.get(0);
    }

    private boolean isAllNull(ListNode[] lists) {
        for (ListNode item : lists) {
            if (item != null) {
                return true;
            }
        }
        return false;
    }

    public boolean isValid(String s) {
        char[] value = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char item : value) {
            if (item == '(' || item == '[' || item == '{') {
                stack.add(item);
            } else if (item == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (item == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (item == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public class ListNode {
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

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        addC(0, n, result, new StringBuilder());
        return result;
    }

    private void addC(int index, int size, List<String> value, StringBuilder stringBuilder) {
        String temp = stringBuilder.toString();
        if (isRight(temp, size)) {
            if (index == size * 2) {
                value.add(temp);
            } else {
                stringBuilder.append("(");
                addC(index + 1, size, value, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                stringBuilder.append(")");
                addC(index + 1, size, value, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    private boolean isRight(String value, int size) {
        int left = 0;
        int right = 0;
        for (char item : value.toCharArray()) {
            if (item == '(') {
                left++;
            } else {
                right++;
            }
        }
        return left >= right && left <= size;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result;
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            result = l2;
            l2 = l2.next;
        } else if (l2 == null) {
            result = l1;
            l1 = l1.next;
        } else if (l1.val < l2.val) {
            result = l1;
            l1 = l1.next;
        } else {
            result = l2;
            l2 = l2.next;
        }
        ListNode temp = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                temp.next = l1;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return result;
    }

/*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        int delete = size - n;
        if (delete <= 0) {
            if (head.next != null) {
                return head.next;
            } else {
                return null;
            }
        }
        int index = 0;
        temp = head;
        while (temp.next != null) {
            index++;
            if (index == delete) {
                if (temp.next.next != null) {
                    temp.next = temp.next.next;
                } else {
                    temp.next = null;
                }
                break;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }*/


    public List<String> letterCombinations(String digits) {
        List<List<String>> input = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        List<String> str2 = new ArrayList<>();
        str2.add("a");
        str2.add("b");
        str2.add("b");
        map.put("2", str2);
        List<String> str3 = new ArrayList<>();
        str3.add("d");
        str3.add("e");
        str3.add("f");
        map.put("3", str3);
        List<String> str4 = new ArrayList<>();
        str4.add("g");
        str4.add("h");
        str4.add("i");
        map.put("4", str4);
        List<String> str5 = new ArrayList<>();
        str5.add("j");
        str5.add("k");
        str5.add("l");
        map.put("5", str5);
        List<String> str6 = new ArrayList<>();
        str6.add("m");
        str6.add("n");
        str6.add("o");
        map.put("6", str6);
        List<String> str7 = new ArrayList<>();
        str7.add("p");
        str7.add("q");
        str7.add("r");
        str7.add("s");
        map.put("7", str7);
        List<String> str8 = new ArrayList<>();
        str8.add("t");
        str8.add("u");
        str8.add("v");
        map.put("8", str8);
        List<String> str9 = new ArrayList<>();
        str9.add("w");
        str9.add("x");
        str9.add("y");
        str9.add("z");
        map.put("9", str9);
        digits = digits.replace("1", "");
        List<String> value = new ArrayList<>();
        if (digits.length() > 0) {
            for (char item : digits.toCharArray()) {
                input.add(map.get(String.valueOf(item)));
            }
            StringBuilder stringBuilder = new StringBuilder();
            parent(input, value, 0, stringBuilder);
        }
        return value;
    }

    private void parent(List<List<String>> input, List<String> value, int index, StringBuilder stringBuilder) {
        if (index == input.size()) {
            value.add(stringBuilder.toString());
        } else {
            for (String item : input.get(index)) {
                stringBuilder.append(item);
                parent(input, value, index + 1, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 3; first++) {
            // 获取最小值
            int min = nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3];
            if (min > target) {
                // 最小值比目标单，跳出
                break;
            }
            // 获取最大值
            int max = nums[first] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
            if (max < target) {
                // 最大值比目标值小，跳出
                break;
            }
            if (first > 0 && nums[first] == nums[first - 1]) continue; // 去重
            for (int second = first + 1; second < nums.length - 2; second++) {
                // 获取最小值
                min = nums[first] + nums[second] + nums[second + 1] + nums[second + 2];
                if (min > target) {
                    // 最小值比目标单，跳出
                    break;
                }
                // 获取最大值
                max = nums[first] + nums[second] + nums[nums.length - 1] + nums[nums.length - 2];
                if (max < target) {
                    // 最大值比目标值小，跳出
                    break;
                }
                if (second > first + 1 && nums[second] == nums[second - 1]) continue; // 去重
                int i = second + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int tempValue = nums[first] + nums[second] + nums[i] + nums[j] - target;
                    if (tempValue == 0) {
                        List<Integer> value = new ArrayList<>();
                        value.add(nums[first]);
                        value.add(nums[second]);
                        value.add(nums[i]);
                        value.add(nums[j]);
                        lists.add(value);
                        while (i < j && nums[i] == nums[i + 1]) i++; // 去重
                        while (i < j && nums[j] == nums[j - 1]) j--; // 去重
                        i++;
                        j--;
                    } else if (tempValue < 0) {
                        while (i < j && nums[i] == nums[i + 1]) i++; // 去重
                        i++;
                    } else {
                        while (i < j && nums[j] == nums[j - 1]) j--; // 去重
                        j--;
                    }
                }
            }
        }
        return lists;
    }

    /*public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (index > 0 && nums[index] == nums[index - 1]) continue; // 去重
            int i = index + 1;
            int j = nums.length - 1;
            while (i < j) {
                int tempValue = nums[i] + nums[j] + nums[index];
                if (tempValue == 0) {
                    List<Integer> value = new ArrayList<>();
                    value.add(nums[index]);
                    value.add(nums[i]);
                    value.add(nums[j]);
                    lists.add(value);
                    while (i < j && nums[i] == nums[i + 1]) i++; // 去重
                    while (i < j && nums[j] == nums[j - 1]) j--; // 去重
                    i++;
                    j--;
                } else if (tempValue < 0) {
                    while (i < j && nums[i] == nums[i + 1]) i++; // 去重
                    i++;
                } else {
                    while (i < j && nums[j] == nums[j - 1]) j--; // 去重
                    j--;
                }
            }
        }
        return lists;
    }*/

    public int threeSumClosest(int[] nums, int target) {
        Integer resultValue = null;
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] > target) break; // 如果当前数字大于target，则三数之和一定大于target，所以结束循环
            if (index > 0 && nums[index] == nums[index - 1]) continue; // 去重
            int i = index + 1;
            int j = nums.length - 1;
            while (i < j) {
                int tempValue = nums[i] + nums[j] + nums[index] - target;
                if (resultValue == null) {
                    resultValue = tempValue;
                } else {
                    if (Math.abs(tempValue) < Math.abs(resultValue)) {
                        resultValue = tempValue;
                    }
                }
                if (tempValue == 0) {
                    while (i < j && nums[i] == nums[i + 1]) i++; // 去重
                    while (i < j && nums[j] == nums[j - 1]) j--; // 去重
                    i++;
                    j--;
                } else if (tempValue < 0) {
                    while (i < j && nums[i] == nums[i + 1]) i++; // 去重
                    i++;
                } else {
                    while (i < j && nums[j] == nums[j - 1]) j--; // 去重
                    j--;
                }
            }
        }
        if (resultValue == null) {
            return nums[0] + nums[1] + nums[2];
        }
        return resultValue + target;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        List<char[]> list = new ArrayList<>();
        for (String item : strs) {
            list.add(item.toCharArray());
        }
        for (int i = 0; i < list.get(0).length; i++) {
            char temp = list.get(0)[i];
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j).length < i + 1 || list.get(j)[i] != temp) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public int romanToInt(String s) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {900, 90, 40, 9, 4, 1000, 500, 400, 100, 50, 10, 5, 1};
        String[] romans = {"CM", "XC", "XL", "IX", "IV", "M", "D", "CD", "C", "L", "X", "V", "I"};
        int sum = 0;
        while (s.length() > 0) {
            for (int i = 0; i < romans.length; i++) {
                String item = romans[i];
                if (s.startsWith(item)) {
                    sum += nums[i];
                    s = s.substring(item.length());
                    break;
                }
            }
        }
        return sum;
    }

    public String intToRoman(int num) {
        Stack<String> value = new Stack<>();
        switch (num % 10) {
            case 1:
                value.add("I");
                break;
            case 2:
                value.add("II");
                break;
            case 3:
                value.add("III");
                break;
            case 4:
                value.add("VI");
                break;
            case 5:
                value.add("V");
                break;
            case 6:
                value.add("IV");
                break;
            case 7:
                value.add("IIV");
                break;
            case 8:
                value.add("IIIV");
                break;
            case 9:
                value.add("XI");
                break;
        }
        if (num >= 10) {
            switch ((num / 10) % 10) {
                case 1:
                    value.add("X");
                    break;
                case 2:
                    value.add("XX");
                    break;
                case 3:
                    value.add("XXX");
                    break;
                case 4:
                    value.add("LX");
                    break;
                case 5:
                    value.add("L");
                    break;
                case 6:
                    value.add("XL");
                    break;
                case 7:
                    value.add("XXL");
                    break;
                case 8:
                    value.add("XXXL");
                    break;
                case 9:
                    value.add("CX");
                    break;
            }
        }
        if (num >= 100) {
            switch ((num / 100) % 10) {
                case 1:
                    value.add("C");
                    break;
                case 2:
                    value.add("CC");
                    break;
                case 3:
                    value.add("CCC");
                    break;
                case 4:
                    value.add("DC");
                    break;
                case 5:
                    value.add("D");
                    break;
                case 6:
                    value.add("CD");
                    break;
                case 7:
                    value.add("CCD");
                    break;
                case 8:
                    value.add("CCCD");
                    break;
                case 9:
                    value.add("MC");
                    break;
            }
        }
        if (num >= 1000) {
            switch ((num / 1000) % 10) {
                case 1:
                    value.add("M");
                    break;
                case 2:
                    value.add("MM");
                    break;
                case 3:
                    value.add("MMM");
                    break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!value.isEmpty()) {
            stringBuilder.append(value.pop());
        }
        return stringBuilder.toString();
    }

    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            max = Math.max((j - i) * Math.min(height[i], height[j]), max);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }

    public boolean isPalindrome(int x) {
        char[] value = String.valueOf(x).toCharArray();
        int i = 0;
        int j = value.length - 1;
        while (i <= j) {
            if (value[i] != value[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int myAtoi(String s) {
        StringBuilder strb = new StringBuilder();
        s = s.trim();
        if (s.startsWith("+") || s.startsWith("-")) {
            strb.append(s, 0, 1);
            s = s.substring(1);
        }
        for (char item : s.toCharArray()) {
            if (item >= '0' && item <= '9') {
                strb.append(item);
            } else {
                break;
            }
        }
        try {
            return Integer.parseInt(strb.toString());
        } catch (Exception e) {
            if (strb.toString().replace("+", "").replace("-", "").length() == 0) {
                return 0;
            } else if (strb.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public int reverse(int x) {
        StringBuilder strb = new StringBuilder();
        Stack<Character> task = new Stack<>();
        String value = String.valueOf(x);
        if (x < 0) {
            value = value.substring(1);
            strb.append("-");
        }
        for (char item : value.toCharArray()) {
            task.push(item);
        }
        while (!task.isEmpty()) {
            strb.append(task.pop());
        }
        try {
            return Integer.parseInt(strb.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    /*public static class ListNode {
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
    }*/

    public String longestPalindrome(String s) {
        char[] value = s.toCharArray();
        if (s.length() == 1) {
            return s;
        }

        int i = 0;
        int j = 0;
        int start = 0;
        int end = 0;
        boolean[][] results = new boolean[value.length][value.length];
        while (i < value.length) {
            j = 0;
            while (j <= i) {
                boolean tempResult;
                if (j == i) {
                    tempResult = true;
                } else if (j == i - 1) {
                    tempResult = value[j] == value[i];
                } else {
                    tempResult = results[j + 1][i - 1] && value[j] == value[i];
                }
                results[j][i] = tempResult;
                if (tempResult && i - j > end - start) {
                    end = i;
                    start = j;
                }
                j++;
            }
            i++;
        }
        return s.substring(start, end + 1);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] value = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, value, 0, nums1.length);
        System.arraycopy(nums2, 0, value, nums1.length, nums2.length);
        Arrays.sort(value);
        if (value.length % 2 == 0) {
            int index = value.length / 2;
            return (value[index - 1] + value[index]) / 2d;
        } else {
            return value[value.length / 2];
        }
    }

    public int lengthOfLongestSubstring(String s) {
        char[] arrays = s.toCharArray();
        char tem = arrays[0];
        int length = 1;
        int max = 1;
        for (int i = 1; i < arrays.length; i++) {
            char tempi = arrays[i];
            if (tem != tempi) {
                length++;
            } else {
                if (length > max) {
                    max = length;
                }
                length = 1;
            }
            tem = tempi;
        }
        return Math.max(length, max);
    }
/*
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode value = new ListNode();
        ListNode first = value;
        int temp = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            value.val = temp % 10;
            if (l1 != null || l2 != null) {
                value.next = new ListNode();
                value = value.next;
            }
            if (temp >= 10) {
                temp = temp / 10;
            } else {
                temp = 0;
            }
        }
        return first;
    }*/

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void getAll(List<String> arrays, int index, List<String> value, String temp) {
        if (index == arrays.size()) {
            value.add(temp);
        } else {
            for (String item : arrays) {
                getAll(arrays, index + 1, value, temp + item);
            }
        }
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
