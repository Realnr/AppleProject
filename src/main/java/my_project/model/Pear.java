package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Pear extends Fruit {

    //Attribute
    private double speed;
    private double sin;

    public Pear(double x, double y){
        super(x,y);
        width = 25;
        height = 35;
        sin = 0;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt) {

        super.update(dt);
        sin += 10*dt;
        x += Math.sin(sin)*10;
    }
}

