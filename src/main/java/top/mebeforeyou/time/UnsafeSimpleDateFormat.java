package top.mebeforeyou.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lovel
 * @created 2026/4/3 10:24
 * @description
 */

public class UnsafeSimpleDateFormat {
    static  final ExecutorService executorService = Executors.newFixedThreadPool(12);
    static final String dateString = "2026-04-03 10:24:00";
    static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            executorService.submit(UnsafeSimpleDateFormat::parseTime);
        }
    }
    private static void parseTime(){
        try {
            System.out.println(SDF.parse(dateString));
        } catch (Exception e) {
            System.out.println("=======解析失败异常=====   " + e);
        }
    }
}
