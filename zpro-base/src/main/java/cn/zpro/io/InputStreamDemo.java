package cn.zpro.io;

import java.io.FileInputStream;

public class InputStreamDemo {

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("123.txt")) {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, len, "utf-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
