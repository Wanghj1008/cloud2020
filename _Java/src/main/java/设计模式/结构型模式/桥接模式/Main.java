package 设计模式.结构型模式.桥接模式;

import 设计模式.结构型模式.桥接模式.pen.GreenPen;
import 设计模式.结构型模式.桥接模式.pen.RedPen;
import 设计模式.结构型模式.桥接模式.shape.Circle;
import 设计模式.结构型模式.桥接模式.shape.Rectangle;
import 设计模式.结构型模式.桥接模式.shape.Shape;

/**
 * @author 王昊杰
 * @version V1.0
 * @Package 设计模式.结构型模式.桥接模式
 * @Email: 1624302283@qq.com
 * @date 2023/5/20 12:49
 * @Copyright
 */
public class Main {
    public static void main(String[] args) {
        Shape greenCircle = new Circle(10, new GreenPen());
        Shape redRectangle = new Rectangle(4, 8, new RedPen());
        greenCircle.draw();
        redRectangle.draw();
    }
}
