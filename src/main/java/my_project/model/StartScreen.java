package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.awt.event.MouseEvent;

import static java.awt.event.MouseEvent.MOUSE_PRESSED;

public class StartScreen extends InteractiveGraphicalObject         {
    private double x = 600;
    private double y = 400;
    private double width = 600;
    private double height = 400;
    private boolean clickedStart;
    private boolean mouseWasClicked;
    private double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
    private double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
    public StartScreen(){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }
    @Override
    public void draw(DrawTool drawTool) {
        //Background
        drawTool.setCurrentColor(25,100,0,255);
        drawTool.drawFilledRectangle(0,0,1600,1024);
        //Start Button
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(25,100,0,255);
        drawTool.drawFilledRectangle(x+2,y+2,width-3,width-3);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.formatText("Arial",1,40);
        drawTool.drawText(x+20,y+50,"Start");
    }
    @Override
    public void update(double dt) {
        if(collidesWith(mouseX,mouseY) ){
            clickedStart = true;
        }
    }
}
