package DatabaseManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import jdk.nashorn.internal.objects.NativeDebug;

public class FileManager {

    public static void writeFile(String src, String content) {

        try {
            File file = new File(src);
            BufferedWriter x = new BufferedWriter(new FileWriter(file, true));
            LocalDateTime localDateTime = LocalDateTime.now();
            final int year = localDateTime.getYear();
            final int month = localDateTime.getMonthValue();
            final int day = localDateTime.getDayOfMonth();
            final int hour = localDateTime.getHour();
            final int minute = localDateTime.getMinute();
            final int second = localDateTime.getSecond();
            String time = day + "/" + month + "/" + year + "-"
                    + hour + ":" + minute + ":" + second;
            x.write(content);
            x.write(" " + time);
            x.write("\n");
            x.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String src) {
        String result = "";
        try {
            File file = new File(src);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                result += sc.nextLine() + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(result.equals(""))
            result = "PC 0";
        return result;
    }
    
    public static int readFileInt(String src) {
        int result = 999;
        try {
            File file = new File(src);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                result = sc.nextInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
    
    
}
