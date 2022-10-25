package spring.事件广播;

import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {
    public String msg;

    public TestEvent(Object source) {
        super(source);
    }

    public TestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public void print(){
        System.out.println(msg);
    }
}