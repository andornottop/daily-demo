package calendar.moyu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Demo1 {
    public static void main(String[] args) {

        SimpleDateFormat sdf_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf_day = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf_today = new SimpleDateFormat("yyyy年M月dd日a");
        String now = sdf_time.format(new Date());
        String today = sdf_day.format(new Date());
        String todays = sdf_today.format(new Date());
        String payday = getPayday();

        String xiaban = today + " 17:00:00";
        String xiaban1 = today + " 17:30:00";
        String xiaban2 = today + " 18:00:00";
        String xiaban3 = today + " 18:30:00";
        String saturday = getWeekend(3);
        String sunday = getWeekend(4);
        String yuandan = "2023-01-01 00:00:00";
        String chunjie = "2023-01-22 00:00:00";
        String qingm = "2023-04-05 00:00:00";
        String laod = "2023-05-01 00:00:00";
        String duanw = "2023-06-22 00:00:00";
        String zhongq = "2022-09-10 00:00:00";
        String guoq = "2022-10-01 00:00:00";
        String runDay = "2022-09-15 00:00:00";
        System.out.println("【摸鱼办】提醒您：" + todays + "好，摸鱼人！工作再累一定不要忘记摸鱼哦！有事没事起身去茶水间，抽烟室，去走廊溜达溜达，别老在工位坐着。钱是老板的,但命是自己的。\n" +
                "\n" +
                "距离5点下班还有:" + getTimeDeffer(now, xiaban) + "\n" +
                "距离5点半下班还有:" + getTimeDeffer(now, xiaban1) + "\n" +
                "距离6点下班还有:" + getTimeDeffer(now, xiaban2) + "\n" +
                "距离6点半下班还有:" + getTimeDeffer(now, xiaban3) + "\n" +
                "距离周六还有:" + getTimeDeffer(now, saturday) + "\n" +
                "距离周日还有:" + getTimeDeffer(now, sunday) + "\n" +
                "距离10号发工资还有:" + getDayDeffer(now, payday) + "\n" +
                "距离15号发工资还有:" + getDayDeffer(now, payday, 5L) + "\n" +
                "距离20号发工资还有:" + getDayDeffer(now, payday, 10L) + "\n" +
                "距离9月15号跑路还有:" + getDayDeffer(now, runDay) + "\n" +
                "距离中秋节还有:" + getDayDeffer(now, zhongq) + "\n" +
                "距离国庆节还有:" + getDayDeffer(now, guoq) + "\n" +
                "距离元旦还有:" + getDayDeffer(now, yuandan) + "\n" +
                "距离春节还有:" + getDayDeffer(now, chunjie) + "\n" +
                "距离清明节还有:" + getDayDeffer(now, qingm) + "\n" +
                "距离劳动节还有:" + getDayDeffer(now, laod) + "\n" +
                "距离端午节还有:" + getDayDeffer(now, duanw) + "\n" +
                "\n" +
                "认认真真上班，这根本就不叫赚钱，那是用劳动换取报酬。只有偷懒，在上班的时候摸鱼划水，你才是从老板手里赚到了钱。\n" +
                "\n" +
                "最后，祝愿天下所有摸鱼人，都能愉快的度过每一天!");
    }


    /**
     * 获取时间差
     * @param time1
     * @param time2
     * @return
     */
    public static String getTimeDeffer(String time1, String time2) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (time1 != null && time2 != null && time1.length() != 0 && time2.length() != 0) {

            try {
                long dt1 = sdf.parse(time1).getTime();
                long dt2 = sdf.parse(time2).getTime();
                long dc = Math.abs(dt2 - dt1);
                long seconds = dc / 1000;
                long date = seconds / (24 * 60 * 60);     //相差的天数
                long hour = (seconds - date * 24 * 60 * 60) / (60 * 60);//相差的小时数
                long minut = (seconds - date * 24 * 60 * 60 - hour * 60 * 60) / (60);//相差的分钟数
                long second = (seconds - date * 24 * 60 * 60 - hour * 60 * 60 - minut * 60);//相差的秒数
                return (date == 0 ? "" : (date + "天")) + (hour == 0 ? "" : (hour + "小时")) + (minut == 0 ? "" : (minut + "分")) + (second == 0 ? "" : (second + "秒"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 获取天数
     *
     * @param time1
     * @param time2
     * @return
     */
    public static String getDayDeffer(String time1, String time2) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (time1 != null && time2 != null && time1.length() != 0 && time2.length() != 0) {

            try {
                long dt1 = sdf.parse(time1).getTime();
                long dt2 = sdf.parse(time2).getTime();
                long dc = Math.abs(dt2 - dt1);
                long seconds = dc / 1000;
                long date = seconds / (24 * 60 * 60);     //相差的天数
                return (date == 0 ? "0天" : (date + "天"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 获取天数
     *
     * @param time1
     * @param time2
     * @param offset
     * @return
     */
    public static String getDayDeffer(String time1, String time2, long offset) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (time1 != null && time2 != null && time1.length() != 0 && time2.length() != 0) {

            try {
                long dt1 = sdf.parse(time1).getTime();
                long dt2 = sdf.parse(time2).getTime();
                long dc = Math.abs(dt2 - dt1);
                long seconds = dc / 1000;
                long date = seconds / (24 * 60 * 60);     //相差的天数
                return (date == 0 ? "0天" : (date + offset + "天"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 获取最近的下一次周六
     *
     * @param
     * @return
     */
    public static String getWeekend(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        //设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        //获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayWeek == 1) {
            dayWeek = 8;
        }

        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);
        Date mondayDate = cal.getTime();
        String weekBegin = sdf.format(mondayDate);
//    System.out.println("所在周星期一的日期：" + weekBegin);


        cal.add(Calendar.DATE, i + cal.getFirstDayOfWeek());
        Date sundayDate = cal.getTime();
        String weekEnd = sdf.format(sundayDate) + " 00:00:00";
//    System.out.println("所在周星期六的日期：" + weekEnd);
        return weekEnd;
    }

    /**
     * 发薪日
     *
     * @return
     */
    public static String getPayday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar payday = Calendar.getInstance();

        if (payday.get(Calendar.DAY_OF_MONTH) >= 10) {
            payday.add(Calendar.MONTH, 1);
        }
        payday.set(Calendar.DAY_OF_MONTH, 10);

        return sdf.format(payday.getTime());
    }
}
