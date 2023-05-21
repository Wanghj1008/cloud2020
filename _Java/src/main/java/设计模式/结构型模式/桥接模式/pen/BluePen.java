package 设计模式.结构型模式.桥接模式.pen;

import 设计模式.结构型模式.桥接模式.shape.DrawAPI;

public class BluePen implements DrawAPI {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用蓝色笔画图，radius:" + radius + ", x:" + x + ", y:" + y);
    }
}