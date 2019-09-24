package zhaofanqi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//工作用到
public class Translate {
    public static void main(String[] args) {

        int i = 0;
        int j = 0;
        int dateIndex = 0;
        try {
            FileInputStream fis = new FileInputStream("20190909_1.txt");
            FileInputStream fis2 = new FileInputStream("origin_log.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "GB2312"));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2));
            String line = "";
            String line2 = "";
            String flight_no;

            List<String> list = new ArrayList<String>();


            while ("" != (line = br.readLine()) && null != line) {
                if (-1 != line.indexOf("没有")) {
                    dateIndex = line.indexOf("2019-09-08");
                    flight_no = line.substring(dateIndex + 11, line.length() - 7);
                    i += 1;
                  list.add(flight_no);
                }
            }
            System.out.println("------------开始输出缺失航班号----------");
            /*for (int k = 0; k <list.size() ; k++) {
                System.out.println(list.get(k));
            }*/

            while (""!=(line2=br2.readLine())&&null!=line2){
                j+=1;
                for (int k = 0; k <list.size() ; k++) {
                    if (line2.contains(list.get(k))){
                     //   System.out.println("这是原始报文中第 "+j+" 条数据 "+list.get(k)+" \t "+line2);
                        System.out.println("这是原始报文中第 "+j+" 条数据 "+list.get(k)+" \t " );
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }


    }
}
