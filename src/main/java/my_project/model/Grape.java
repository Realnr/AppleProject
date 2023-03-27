package my_project.model;

import KAGO_framework.view.DrawTool;

public class Grape extends Fruit{

    private int staminaBuff;

    public Grape(double x, double y){
        super(x,y);
        this.x = x;
        this.y = y;
        staminaBuff = 5;
        radius = 30;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(138,43,226,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
        drawTool.setCurrentColor(139,69,19,255);
        drawTool.drawFilledRectangle(x-radius/4,y-radius*2,radius/2,radius);
    }

    @Override
    public void update(double dt) {
        super.update(dt);

    }

    public int getStaminaBuff() {
        return staminaBuff;
    }
}
