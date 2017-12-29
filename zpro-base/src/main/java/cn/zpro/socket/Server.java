package cn.zpro.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 多线程套接字实现Server端
 */
public class Server {

    public static void main(String[] args) throws Exception {

        Executor executor = Executors.newFixedThreadPool(10);
        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            System.out.println("服务端启动完成端口8089...");
            while (true){
                Socket accept = serverSocket.accept();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try(
                                InputStream inputStream = accept.getInputStream();
                                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                            String line = reader.readLine();

                            System.out.println(Thread.currentThread().getName()+"->客户端:" + accept.getInetAddress() + "->:" + line);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });

            }




        }


    }


}
