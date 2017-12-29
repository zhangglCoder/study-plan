package cn.zpro.io;


import org.springframework.util.StringUtils;

import java.io.*;

/**
 * @author zhanggl
 */
public class Lession1 {


    public static Integer count = 0;
    public static void main(String[] args) throws Exception {
        String filePath = "F:\\JAVA电子书\\1.txt";
        String str = "1";
        Integer count = findCountByFileWithStr(filePath, str);
        System.out.println("特殊字符串"+str+"出现的个数:"+count);
    }

    /**
     * 输入一个文件名和一个字符串，统计这个字符串在这
     个文件中出现的次数
     * @param filePath 文件路径
     * @param str 特殊字符串
     * @return
     */
    public static Integer findCountByFileWithStr(String filePath,String str) throws Exception {
        File file = new File(filePath);


        try(InputStream inputStream = new FileInputStream(file);
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream)
                )) {
            String line = in.readLine();

            String[] split = line.split("");
            for (String res:split) {
                if(res.equals(str)){
                    count++;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}
