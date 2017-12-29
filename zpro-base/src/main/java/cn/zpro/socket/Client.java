package cn.zpro.socket;

import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {

        for (int i=1;i<=15;i++){
            try(Socket socket = new Socket("127.0.0.1",8989)) {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write((i+"数据").getBytes());
            }
        }


    }
}
