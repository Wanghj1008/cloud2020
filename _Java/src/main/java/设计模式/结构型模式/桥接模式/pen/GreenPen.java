package 设计模式.结构型模式.桥接模式.pen;

import 设计模式.结构型模式.桥接模式.shape.DrawAPI;

public class GreenPen implements DrawAPI {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用绿色笔画图，radius:" + radius + ", x:" + x + ", y:" + y);
    }
}