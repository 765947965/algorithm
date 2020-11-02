import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Install {
    public static void main(String[] args) {
        installARC();
        installBD();
    }

    private static void installARC() {
        String[] ips = new String[]{"192.168.72.26", "192.168.72.30", "192.168.72.35", "192.168.4.241",
                "192.168.72.28", "192.168.72.33", "192.168.72.32", "192.168.72.34", "192.168.4.214", "192.168.72.29",
                "192.168.72.31"};
        String path = "C:\\Users\\76594\\Desktop\\1\\eastArc\\release\\eastArc_126.apk";
        installValue(ips, path);
    }

    private static void installBD() {
        String[] ips = new String[]{"192.168.160.91", "192.168.4.106", "192.168.4.53"};
        String path = "C:\\Users\\76594\\Desktop\\1\\eastBaidu\\release\\eastBaidu_126.apk";
        installValue(ips, path);
    }

    private static void installValue(String[] ips, String path) {
        for (String ip : ips) {
            String cmd = "adb connect " + ip;
            install(ip, cmd, "connected to " + ip);
            cmd = "adb -s " + ip + " install -r -g " + path;
            install(ip, cmd, null);
            cmd = "adb -s " + ip + " shell am start -n com.east.face.device.east/com.east.face.device.business.screen.ScreenActivity";
            install(ip, cmd, null);
            cmd = "adb disconnect " + ip;
            install(ip, cmd, null);
        }
    }

    private static void install(String ip, String cmd, String result) {
        try {
            System.out.println(cmd);
            Process process = Runtime.getRuntime().exec(cmd);
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String content = br.readLine();
            while (content != null) {
                System.out.println(content);
                if (result != null && !content.startsWith(result)) {
                    throw new RuntimeException("输出错误");
                }
                content = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
