package zhaofanqi.exercise;

public class temTest {
    public static void main(String[] args) {
        String s="平均费用";
        try {
            new String(s.getBytes("GB2312"),"iso-8859-1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);

    }
}
