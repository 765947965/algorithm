package test;

public class Test6 {
    public static void main(String[] args) {
        int[] values = new int[]{1, -9, 5, 18, 199, 2, 33, -18, 0, 15};
        shortSelect(values);
        for (int item : values) {
            System.out.print(item + " ");
        }
    }

    private static void shortBubble(int[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
    }

    private static void shortSelect(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[index] > values[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = values[i];
                values[i] = values[index];
                values[index] = temp;
            }
        }
    }

    private static void shortFast(int[] values) {
        for (int i = 1; i < values.length; i++) {
            for (int j = i; j > 0; j--) {
                if (values[j - 1] > values[j]) {
                    int temp = values[j - 1];
                    values[j - 1] = values[j];
                    values[j] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
