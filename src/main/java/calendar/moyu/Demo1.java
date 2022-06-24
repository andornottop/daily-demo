package calendar.moyu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Demo1 {
    public static void main(String[] args) {

        SimpleDateFormat sdf_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf_day = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf_today = new SimpleDateFormat("yyyy��M��dd��a");
        String now = sdf_time.format(new Date());
        String today = sdf_day.format(new Date());
        String todays = sdf_today.format(new Date());
        Map<String, String> payday = getPayday();

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
        System.out.println("������졿��������"+todays+"�ã������ˣ���������һ����Ҫ��������Ŷ������û������ȥ��ˮ�䣬�����ң�ȥ��������������ڹ�λ���š�Ǯ���ϰ��,�������Լ��ġ�\n" +
                "\n" +
                "����5���°໹��:" + getTimeDeffer(now, xiaban) + "\n" +
                "����5����°໹��:" + getTimeDeffer(now, xiaban1) + "\n" +
                "����6���°໹��:" + getTimeDeffer(now, xiaban2) + "\n" +
                "����6����°໹��:" + getTimeDeffer(now, xiaban3) + "\n" +
                "������������:" + getTimeDeffer(now, saturday) + "\n" +
                "�������ջ���:" + getTimeDeffer(now, sunday) + "\n" +
                "����10�ŷ����ʻ���:" + getDayDeffer(now, payday.get("payday10")) + "\n" +
                "����15�ŷ����ʻ���:" + getDayDeffer(now, payday.get("payday15")) + "\n" +
                "����20�ŷ����ʻ���:" + getDayDeffer(now, payday.get("payday20")) + "\n" +
                "��������ڻ���:" + getDayDeffer(now, zhongq) + "\n" +
                "�������ڻ���:" + getDayDeffer(now, guoq) + "\n" +
                "����Ԫ������:" + getDayDeffer(now, yuandan) + "\n" +
                "���봺�ڻ���:" + getDayDeffer(now, chunjie) + "\n" +
                "���������ڻ���:" + getDayDeffer(now, qingm) + "\n" +
                "�����Ͷ��ڻ���:" + getDayDeffer(now, laod) + "\n" +
                "�������ڻ���:" + getDayDeffer(now, duanw) + "\n" +
                "\n" +
                "���������ϰ࣬������Ͳ���׬Ǯ���������Ͷ���ȡ���ꡣֻ��͵�������ϰ��ʱ�����㻮ˮ������Ǵ��ϰ�����׬����Ǯ��\n" +
                "\n" +
                "���ףԸ�������������ˣ��������Ķȹ�ÿһ��!");
    }

    /**
     * ��ȡʱ���
     *
     * @param time1 time2 ��Ҫ�����ʱ��
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
                long date = seconds / (24 * 60 * 60);     //��������
                long hour = (seconds - date * 24 * 60 * 60) / (60 * 60);//����Сʱ��
                long minut = (seconds - date * 24 * 60 * 60 - hour * 60 * 60) / (60);//���ķ�����
                long second = (seconds - date * 24 * 60 * 60 - hour * 60 * 60 - minut * 60);//��������
                return (date == 0 ? "" : (date + "��")) + (hour == 0 ? "" : (hour + "Сʱ")) + (minut == 0 ? "" : (minut + "��")) + (second == 0 ? "" : (second + "��"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * ��ȡ����
     *
     * @param time1 time2 ��Ҫ���������
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
                long date = seconds / (24 * 60 * 60);     //��������
                return (date == 0 ? "0��" : (date + "��"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * ��ȡ�������һ������
     *
     * @param
     * @return
     */
    public static String getWeekend(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        //����һ�����ڵĵ�һ�죬���й���ϰ��һ�����ڵĵ�һ��������һ
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        //��õ�ǰ������һ�����ڵĵڼ���
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayWeek == 1) {
            dayWeek = 8;
        }

        // ���������Ĺ��򣬸���ǰ���ڼ�ȥ���ڼ���һ�����ڵ�һ��Ĳ�ֵ
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);
        Date mondayDate = cal.getTime();
        String weekBegin = sdf.format(mondayDate);
//    System.out.println("����������һ�����ڣ�" + weekBegin);


        cal.add(Calendar.DATE, i + cal.getFirstDayOfWeek());
        Date sundayDate = cal.getTime();
        String weekEnd = sdf.format(sundayDate) + " 00:00:00";
//    System.out.println("�����������������ڣ�" + weekEnd);
        return weekEnd;
    }

    /**
     * ��н��
     * @return
     */
    public static Map<String,String> getPayday(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Map<String,String> map = new HashMap<>();
        Calendar payday10 = Calendar.getInstance();
        Calendar payday15 = Calendar.getInstance();
        Calendar payday20 = Calendar.getInstance();

        if (payday10.get(Calendar.DAY_OF_MONTH) >= 10) {
            payday10.add(Calendar.MONTH, 1);
        }
        if (payday15.get(Calendar.DAY_OF_MONTH) >= 15) {
            payday15.add(Calendar.MONTH, 1);
        }
        if (payday20.get(Calendar.DAY_OF_MONTH) >= 20) {
            payday20.add(Calendar.MONTH, 1);
        }
        payday10.set(Calendar.DAY_OF_MONTH, 10);
        payday15.set(Calendar.DAY_OF_MONTH, 15);
        payday20.set(Calendar.DAY_OF_MONTH, 20);

        map.put("payday10",sdf.format(payday10.getTime()));
        map.put("payday15",sdf.format(payday15.getTime()));
        map.put("payday20",sdf.format(payday20.getTime()));

        return map;
    }
}
