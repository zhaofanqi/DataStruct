package zhaofanqi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class quchu_kongge {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("sql.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            String regexp="[' ']+";
            Pattern p= Pattern.compile(regexp);
            while (null!=(line=bufferedReader.readLine())&&""!=line){
                Matcher m=p.matcher(line);
                m.replaceAll(",");
                System.out.println(m.replaceAll(" ").split(" ")[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //����ǰ������Ұ�,,,,,,,,,,���Ǻ���
        String s = "�Ұ�          ���Ǻ���";
        //System.out.println(s.replaceAll(" ", ",").trim());

        //��������:�Ұ�,���Ǻ���
        String regEx = "[' ']+"; // һ�������ո�
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        System.out.println(m.replaceAll(",").trim());
    }
}
