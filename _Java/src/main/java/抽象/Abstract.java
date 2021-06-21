package 抽象;

/**
 * @author Wanghj
 * @Package 抽象
 * @date 2021/4/30 16:11
 */
public abstract class Abstract {
    private String name;
    public Abstract() {
    }

    public Abstract(String name) {
        this.name=name;
    }

    public void unAbstract(){
        System.out.println("非抽象类");
    }
    public abstract void _Abstract();

}
