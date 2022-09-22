package 深拷贝;

import lombok.Data;

@Data
public class Address implements Cloneable {
    private String type;
    private String value;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}