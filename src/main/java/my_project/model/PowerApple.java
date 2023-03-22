package my_project.model;

import KAGO_framework.view.DrawTool;

public class PowerApple extends Apple {

    private int speedBuff;

    public PowerApple(double x, double y,Player player01){
        super(x,y,player01);
        speedBuff = 8;
    }
    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.setCurrentColor(139,69,19,255);
        drawTool.drawFilledRectangle(x-radius/4,y-radius*2,radius/2,radius);
    }

    public int getSpeedBuff() {
        return speedBuff;
    }
}
