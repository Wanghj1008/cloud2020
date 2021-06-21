package jvm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Wanghj
 * @Package jvm
 * @date 2021/5/25 13:10
 */
public class T2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        while (true){
            Socket socket = serverSocket.accept();
            if(socket != null){
                new Thread(()->{
                    InputStream inputStream = null;
                    try {
                        inputStream = socket.getInputStream();
                      /*  InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String lin = bufferedReader.readLine();
                        System.out.println(lin);*/

                        byte[] bytes=new byte[1024];
                        int length =0;
                        StringBuilder stringBuffer = new StringBuilder();
                        while ((length=inputStream.read(bytes))!=-1){
                            stringBuffer.append(new String(bytes,0,length));
                        }
                        System.out.println("12121"+stringBuffer.toString());

                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write("555".getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("解析错误错误");
                    }finally {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

            serverSocket.close();
        }

    }
}
