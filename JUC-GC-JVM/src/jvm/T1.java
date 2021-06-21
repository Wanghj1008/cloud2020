package jvm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Wanghj
 * @Package jvm
 * @date 2021/5/25 13:09
 */
public class T1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("dwadwa".getBytes());
     /*   OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("hello");
        bufferedWriter.newLine();
        bufferedWriter.flush();*/

       /* PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.print("hello word");*/
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes=new byte[1024];
        int length =0;
        StringBuilder stringBuffer = new StringBuilder();
        while ((length=inputStream.read(bytes))!=-1){
            stringBuffer.append(new String(bytes,0,length));
        }
        System.out.println("12121"+stringBuffer.toString());
        socket.close();

    }
}
