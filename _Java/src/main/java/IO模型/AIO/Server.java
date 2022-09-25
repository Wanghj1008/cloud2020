package IO模型.AIO;

/**
 * AIO服务端
 * @author yangtao__anxpp.com
 * @version 1.0
 */
public class Server {
	private static final int DEFAULT_PORT = 12345;
	private static AsyncServerHandler serverHandle;
	public volatile static long clientCount = 0;
	public static void start(){
		start(DEFAULT_PORT);
	}
	public static synchronized void start(int port){
		if(serverHandle!=null)
			return;
		serverHandle = new AsyncServerHandler(port);
		new Thread(serverHandle,"Server").start();
	}
	public static void main(String[] args){
		Server.start();
	}
}