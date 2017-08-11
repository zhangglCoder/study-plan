package cn.zpro.io;


import java.io.*;

public class OutPutStreamDemo {
    public static void main(String[] args) {
        File file = new File("123.txt");
        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write("张".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
