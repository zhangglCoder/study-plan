package cn.zpro.io;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutPutStreamDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("123.txt");
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write("张".getBytes());



    }
}
