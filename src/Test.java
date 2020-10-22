import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] nums = line.trim().split(",");
            if (nums.length != 3) {
                // 长度不为3
                System.out.println(-1);
                continue;
            }
            TreeSet<Integer> setValues = new TreeSet<>();
            for (String num : nums) {
                setValues.add(Integer.parseInt(num));
            }
            if (nums.length != setValues.size()) {
                // 有重复数值
                System.out.println(-1);
                continue;
            }
            if (setValues.first() < 1 || setValues.last() > 9) {
                // 不在范围内
                System.out.println(-1);
                continue;
            }
            if ((setValues.contains(2) && setValues.contains(5)) || (setValues.contains(6) && setValues.contains(9))) {
                // 同时包含2和5  或者6和9
                System.out.println(-1);
                continue;
            }
            int maxK = setValues.last();
            TreeSet<Integer> outPutValue = new TreeSet<>(pay(setValues));
            if (setValues.contains(2)) {
                setValues.remove(2);
                setValues.add(5);
                outPutValue.addAll(pay(setValues));
                setValues.remove(5);
                setValues.add(2);
            }
            if (setValues.contains(5)) {
                setValues.remove(5);
                setValues.add(2);
                outPutValue.addAll(pay(setValues));
                setValues.remove(2);
                setValues.add(5);
            }
            if (setValues.contains(6)) {
                setValues.remove(6);
                setValues.add(9);
                outPutValue.addAll(pay(setValues));
                setValues.remove(9);
                setValues.add(6);
            }
            if (setValues.contains(9)) {
                setValues.remove(9);
                setValues.add(6);
                outPutValue.addAll(pay(setValues));
                setValues.remove(6);
                setValues.add(9);
            }
            if ((setValues.contains(2) || setValues.contains(5)) && (setValues.contains(6) || setValues.contains(9))) {
                if (setValues.contains(2)) {
                    setValues.remove(2);
                    setValues.add(5);
                } else if (setValues.contains(5)) {
                    setValues.remove(5);
                    setValues.add(2);
                }
                if (setValues.contains(6)) {
                    setValues.remove(6);
                    setValues.add(9);
                } else if (setValues.contains(9)) {
                    setValues.remove(9);
                    setValues.add(6);
                }
                outPutValue.addAll(pay(setValues));
            }
            StringBuilder stringBuilder = new StringBuilder();
            int lastOut = outPutValue.last();
            for (Integer item : outPutValue) {
                stringBuilder.append(item);
                if (item == lastOut) {
                    stringBuilder.append(" ");
                } else {
                    stringBuilder.append(",");
                }
            }
            if (outPutValue.size() < maxK) {
                System.out.println(-1);
            } else {
                stringBuilder.append(new ArrayList<>(outPutValue).get(maxK - 1));
                System.out.println(stringBuilder.toString());
            }
        }
    }

    private static TreeSet<Integer> pay(TreeSet<Integer> setValues) {
        return new TreeSet<>(getNums(setValues));
    }

    private static List<Integer> getNums(TreeSet<Integer> setValues) {
        List<Integer> value = new ArrayList<>();
        List<String> valueString = new ArrayList<>();
        getString(new ArrayList<>(setValues), valueString, "", 0, setValues.size());
        for (String item : valueString) {
            String tempValue = item.trim();
            if (tempValue.length() > 0) {
                value.add(Integer.parseInt(tempValue));
            }
        }
        return value;
    }

    private static void getString(List<Integer> setValues, List<String> values, String itemValue, int index, int target) {
        if (index < target) {
            for (int i = 0; i < setValues.size(); i++) {
                if (!itemValue.contains(String.valueOf(setValues.get(i)))) {
                    String temp = itemValue + setValues.get(i);
                    getString(setValues, values, temp, index + 1, target);
                }
            }
            getString(setValues, values, itemValue, index + 1, target);
        } else {
            values.add(itemValue);
        }
    }
}
