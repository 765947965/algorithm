package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            StringBuilder strb = new StringBuilder();
            for (char item : line.trim().toCharArray()) {
                int value = ((int) item);
                System.out.println(value);
                if (value <= 9) {
                    strb.append("*").append(item).append("*");
                } else {
                    strb.append(item);
                }
            }
            System.out.println(strb.toString());
        }
    }

    // 自守数
    public static void main5(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            int number = Integer.parseInt(line.trim());
            System.out.println(autonomousNumber(number));
        }
    }

    private static int autonomousNumber(int number) {
        int total = 0;
        for (int i = 1; i < number; i++) {
            if (String.valueOf(i * i).endsWith(String.valueOf(i))) {
                total += 1;
            }
        }
        return total;
    }


    // 等差数列
    public static void main4(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            int number = Integer.parseInt(line.trim());
            System.out.println(number);
        }
    }

    private static int sub(int num) {
        int start = 2;
        for (int i = 2; i <= num; i++) {
            int sum = 2 + (i - 1) * 3;
            start += sum;
        }
        return start;
    }

    // 数据排序
    public static void main3(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            int number = Integer.parseInt(line.trim());
            int[] values = new int[number];
            int i = 0;
            for (String item : reader.readLine().trim().split(" ")) {
                values[i] = Integer.parseInt(item.trim());
                i++;
            }
            int sorType = Integer.parseInt(reader.readLine().trim());
            for (i = 1; i < values.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (sorType == 0) {
                        if (values[j + 1] < values[j]) {
                            int temp = values[j];
                            values[j] = values[j + 1];
                            values[j + 1] = temp;
                        } else {
                            break;
                        }
                    } else {
                        if (values[j + 1] > values[j]) {
                            int temp = values[j];
                            values[j] = values[j + 1];
                            values[j + 1] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            for (int item : values) {
                System.out.print(item + " ");
            }
            System.out.println("");
        }
    }

    // 统计字母个数，按阿斯科马顺序
    public static void main2(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            Map<Character, Integer> map = new HashMap<>();
            for (char item : line.toCharArray()) {
                map.merge(item, 1, Integer::sum);
            }
            Character[] value = new Character[map.size()];
            int i = 0;
            for (Map.Entry<Character, Integer> item : map.entrySet()) {
                value[i] = item.getKey();
                i++;
            }
            for (i = 1; i < value.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (map.get(value[j + 1]) > map.get(value[j])) {
                        Character temp = value[j];
                        value[j] = value[j + 1];
                        value[j + 1] = temp;
                    } else if (map.get(value[j + 1]).equals(map.get(value[j]))) {
                        if (((int) value[j]) > ((int) value[j + 1])) {
                            Character temp = value[j];
                            value[j] = value[j + 1];
                            value[j + 1] = temp;
                        }
                    } else {
                        break;
                    }
                }
            }
            for (Character item : value) {
                System.out.print(item);
            }
            System.out.println("");
        }
    }

    private static void pay(int[] values) {
        int index = 0;
        int max = 1;
        while (index < values.length) {
            for (int i = index; i < values.length - 1; i++) {
                int stepCount = 1;
                int maxValue = values[i];
                for (int j = i + 1; j < values.length; j++) {
                    if (values[j] > maxValue) {
                        maxValue = values[j];
                        stepCount++;
                    }
                }
                if (stepCount > max) {
                    max = stepCount;
                }
            }
            index++;
        }
        System.out.println(max);
    }
}
