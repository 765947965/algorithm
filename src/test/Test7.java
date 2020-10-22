package test;

public class Test7 {
    public static void main(String[] args) {
        int[] values = new int[]{1, -9, 5, 18, 199, 2, 33, -18, 0, 15};
        shortBubble(values);
        for (int item : values) {
            System.out.print(item + " ");
        }
    }

    private static void shortBubble(int[] values) {
//        for (int i = 0; i < values.length - 1; i++) {
//            for (int j = i + 1; j < values.length; j++) {
//                if (values[j] < values[i]) {
//                    int temp = values[j];
//                    values[j] = values[i];
//                    values[i] = temp;
//                }
//            }
//        }
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 1; j < values.length - i; j++) {
                if (values[j] < values[j - 1]) {
                    int temp = values[j - 1];
                    values[j - 1] = values[j];
                    values[j] = temp;
                }
            }
        }
    }

    private static void shortSelect(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < values[index]) {
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

    }
}
