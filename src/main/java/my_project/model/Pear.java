package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Pear extends Fruit {

    //Attribute
    private boolean spruchHinterlassen;
    private double sin;
    private double tY;
    private double tX;
    private int tA;


    public Pear(double x, double y){
        super(x,y);
        width = 25;
        height = 35;
        sin = 0;
        tA = 255;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
        if(spruchHinterlassen){
            tY = y;
            tX = x;
            drawTool.setCurrentColor(0, 0, 0, tA);
            drawTool.formatText("Arial", 1, 20);
            drawTool.drawText(tX, tY, "In der Not frisst der Teufel Birnen");

        }
    }


    @Override
    public void update(double dt) {

        super.update(dt);
        sin += 10*dt;
        x += Math.sin(sin)*10;
        if(spruchHinterlassen){
            tA -= 50*dt;
            tY += 10*dt;
            if(tA < 0 ){
                spruchHinterlassen = false;
            }
        }
    }

    public void setSpruchHinterlassen(boolean spruchHinterlassen) {
        this.spruchHinterlassen = spruchHinterlassen;
    }
}

