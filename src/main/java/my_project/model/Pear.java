package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Pear extends Fruit {

    //Attribute
    private boolean spruchKordsInitialisierung;
    private boolean spruch;
    private double sin;
    private double tY;
    private double tX;
    private int tA;


    public Pear(double x, double y){
        super(x,y);
        width = 25;
        height = 35;
        sin = 0;
        Math.min(tA , 0);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
        if(spruchKordsInitialisierung) {
            //tY = y;
            //tX = x;
            tA = 255;
            spruch = true;
            spruchKordsInitialisierung = false;
        }
        if(spruch){
            drawTool.setCurrentColor(0, 0, 0, tA);
            drawTool.formatText("Arial", 1, 20);
            drawTool.drawText(tX-12, tY, "L bozo");
        }
    }


    @Override
    public void update(double dt) {

        super.update(dt);
        sin += 10*dt;
        x += Math.sin(sin)*10;
        if(spruch){
            tA -= 50*dt;
            tY -= 10*dt;
            if(tA == 0 ){
                spruch = false;
            }
        }
    }

    public void setSpruchHinterlassen(boolean spruchHinterlassen) {
        this.spruchKordsInitialisierung = spruchHinterlassen;
    }

    public void settY(double tY) {
        this.tY = tY;
    }

    public void settX(double tX) {
        this.tX = tX;
    }
}

