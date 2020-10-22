import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            int nums = Integer.parseInt(line.trim());
            int[] values = new int[nums];
            for (int i = 0; i < nums; i++) {
                values[i] = Integer.parseInt(bufferedReader.readLine().trim());
            }
            List<String> pathList = new ArrayList<>();
            plumBlossomPile(values, pathList, "");
//            for (String item : pathList) {
//                for(char index: item.toCharArray()){
//                    System.out.print(values[Integer.parseInt(String.valueOf(index))] + " ");
//                }
//                System.out.println("");
//            }
            int stepCount = 0;
            for (String item : pathList) {
                if (item.length() > stepCount) {
                    stepCount = item.length();
                }
            }
            System.out.println(stepCount);
        }
    }

    public static void plumBlossomPile(int[] values, List<String> pathList, String path) {
        if (path.length() == 0) {
            for (int i = 0; i < values.length; i++) {
                plumBlossomPile(values, pathList, String.valueOf(i));
            }
        } else {
            int endIndex = Integer.parseInt(path.substring(path.length() - 1));
            if (endIndex >= values.length - 1) {
                pathList.add(path);
            } else {
                int valueTemp = values[endIndex];
                for (int i = endIndex + 1; i < values.length; i++) {
                    if (values[i] > valueTemp) {
                        plumBlossomPile(values, pathList, path + i);
                    }
                }
            }
        }
    }
}
