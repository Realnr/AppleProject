package my_project.model;

import KAGO_framework.view.DrawTool;

public class rottenPear extends Pear{

    private int rot;
//    private double timer;

    public rottenPear(double x, double y){
        super(x,y);
        rot = 0;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(113, 127, 30,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt) {
        super.update(dt);

    }

    public int getRot() {
        return rot;
    }
}
