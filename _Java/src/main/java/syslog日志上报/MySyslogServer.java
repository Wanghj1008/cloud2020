package syslog日志上报;

import org.graylog2.syslog4j.SyslogConstants;
import org.graylog2.syslog4j.server.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.SocketAddress;

public class MySyslogServer {
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 32376;

	private void receiveSyslogMessage() throws InterruptedException {
		SyslogServerIF server = SyslogServer.getInstance(SyslogConstants.UDP);
		SyslogServerConfigIF config = server.getConfig();
		config.setHost(HOST);
		config.setPort(PORT);
		config.addEventHandler(new SyslogServerSessionEventHandlerIF() {
			@Override
			public Object sessionOpened(SyslogServerIF syslogServerIF, SocketAddress socketAddress) {
				return null;
			}

			@Override
			public void event(Object o, SyslogServerIF syslogServerIF, SocketAddress socketAddress,
							  SyslogServerEventIF syslogServerEventIF) {
				String pathName = "D:\\tmp\\test.txt";
				try {
					addContent2TxtLast(pathName, syslogServerEventIF.getMessage() + "\r");
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(syslogServerEventIF.getMessage());

			}

			/**
			 * 追加文件内容：<p>
			 * 判断文件是否存在，不存在则创建<p>
			 * 使用FileOutputStream，在构造FileOutputStream时，把第二个参数设为true<p>
			 *
			 * @param pathName
			 * @param conent
			 */
			public void addContentPlus(String pathName, String conent) throws IOException {
				File file = new File(pathName);
				// 判断文件不存在，返回
				if (!judeFileExists(file)) {
					return;
				}
				if (!file.exists()) {
					file.createNewFile();
				}
				BufferedWriter out = null;
				try {
					out = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream(file, true)));
					out.write(conent);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						out.flush();
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			/**
			 * 追加文件：使用FileOutputStream，在构造FileOutputStream时，把第二个参数设为true，表示在文件末尾追加
			 *
			 * @param pathName
			 * @param conent
			 * @throws IOException
			 */
			public void addContent2TxtLast(String pathName, String conent) throws IOException {
				FileOutputStream fos = new FileOutputStream(pathName, true);
				fos.write(conent.getBytes());
				fos.flush();
				fos.close();//流要及时关闭
			}

			/**
			 * 追加文件：使用FileWriter
			 *
			 * @param pathName
			 * @param content
			 */

			public void method2(String pathName, String content) throws IOException {
				FileWriter writer = null;
				try {
					// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
					writer = new FileWriter(pathName, true);
					writer.write(content);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					writer.flush();
					writer.close();
				}

			}

			// 判断文件是否存在
			public boolean judeFileExists(File file) {
				if (file.exists()) {
					System.out.println("File exists");
					return Boolean.TRUE;
				} else {
					System.out.println("File not exists, please create it ...");
					return Boolean.FALSE;
				}
			}

			@Override
			public void exception(Object o, SyslogServerIF syslogServerIF, SocketAddress socketAddress, Exception e) {

			}

			@Override
			public void sessionClosed(Object o, SyslogServerIF syslogServerIF, SocketAddress socketAddress, boolean b) {

			}

			@Override
			public void initialize(SyslogServerIF syslogServerIF) {

			}

			@Override
			public void destroy(SyslogServerIF syslogServerIF) {

			}
		});
		SyslogServer.getThreadedInstance(SyslogConstants.UDP);
		Thread.sleep(1000000000);
	}


	public static void main(String[] args) throws InterruptedException {
		new MySyslogServer().receiveSyslogMessage();
	}
}