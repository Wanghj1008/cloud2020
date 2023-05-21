package 设计模式.结构型模式.桥接模式.shape;

public class Circle extends Shape {
    private int radius;

    public Circle(int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.radius = radius;
    }

    public Circle() {
    }

    public void draw() {
        drawAPI.draw(radius, 0, 0);
    }
}