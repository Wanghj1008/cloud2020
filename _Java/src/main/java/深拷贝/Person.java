package 深拷贝;

import lombok.Data;

@Data
public class Person implements Cloneable {
    private String name;
    private Integer age;
    private Address address;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        Address address = person.getAddress();
        person.setAddress((Address) address.clone());
        return person;
    }

    public static void main(String[] args) throws Exception {

        Address address=new Address();
        address.setType("Home");
        address.setValue("北京");

        Person p1=new Person();
        p1.setAge(31);
        p1.setName("Peter");
        p1.setAddress(address);

        Person p2=(Person) p1.clone();
        System.out.println(p1==p2);

        p2.getAddress().setType("Office");
        System.out.println("p1="+p1);
        System.out.println("p2="+p2);
    }
}
