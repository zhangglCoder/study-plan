package cn.zpro.io;

import java.io.*;

public class FileUtils {


    /**
     * 根据路径创建文件
     *
     * @param fileName 全路径（包含文件后缀）
     * @return
     */
    public static boolean createFile(String fileName) {
        boolean flag = false;
        File file = new File(fileName);
        FileInputStream inputStream = null;
        if (!file.exists()) {
            try {
                FileOutputStream outputStream = new FileOutputStream(file);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("文件已存在");
        }
        return flag;
    }


}
