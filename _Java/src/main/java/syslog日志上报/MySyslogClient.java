package syslog日志上报;

import org.graylog2.syslog4j.Syslog;
import org.graylog2.syslog4j.SyslogConstants;
import org.graylog2.syslog4j.SyslogIF;

public class MySyslogClient {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 32376;

    public void generate() {
        SyslogIF syslog = Syslog.getInstance(SyslogConstants.UDP);
        syslog.getConfig().setHost(HOST);
        syslog.getConfig().setPort(PORT);


        try {
            StringBuffer sb = new StringBuffer();
            sb.append("王昊sa");
            String a ="王";
            System.out.println(a.toString().getBytes().length);

            syslog.log(0, sb.toString());
            syslog.shutdown();
        } catch (Exception e) {
            System.out.println("generate log get exception " + e);
        }
        System.out.println("哎呀，老娘的第一次dating，竟然还得先搭讪!");
    }

    public static void main(String[] args) {
        new MySyslogClient().generate();
    }
}