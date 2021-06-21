import java.util.Arrays;
import java.util.List;

/**
 * @author Wanghj
 * @Package PACKAGE_NAME
 * @date 2021/6/7 13:36
 */
public class Test {
    public static int size;

    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setName("6");

        Emp emp = new Emp();
        emp.setName("WHJ");
        emp.setDept(dept);

        Emp emp1 = new Emp();
        emp1.setName("WYQ");
        emp1.setDept(dept);

        dept.setEmps(Arrays.asList(emp,emp1));


    }
}

     class  Emp{
        private String name;
       private Dept dept;
       public Emp(){}


       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

         public Dept getDept() {
             return dept;
         }

         public void setDept(Dept dept) {
             this.dept = dept;
         }
     }

   class Dept{
        private String name;
        private List<Emp> emps;

        public Dept(){}

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public List<Emp> getEmps() {
           return emps;
       }

       public void setEmps(List<Emp> emps) {
           this.emps = emps;
       }
   }
