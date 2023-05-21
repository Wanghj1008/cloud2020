package 设计模式.结构型模式.桥接模式.shape;

public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    protected Shape() {
    }

    public abstract void draw();
}