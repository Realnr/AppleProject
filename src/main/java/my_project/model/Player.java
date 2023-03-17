package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static KAGO_framework.control.ViewController.isKeyDown;

public class Player extends InteractiveGraphicalObject {


    //Attribute
    private double speed;
    private double runSpeed;
    private double walkSpeed;
    private int points;
    private static double stamina;
    private double deltaTime;
    private int lives;


    //Tastennummern zur Steuerung
    private int keyToGoLeft;
    private int keyToGoRight;
    private int keyToAccelerate;

    private int direction;
    private boolean canMover;
    private boolean canMovel;

    public Player(double x, double y){
        this.x = x;
        this.y = y;
        walkSpeed = 150;
        runSpeed = 360;
        width = 80;
        height = 40;
        stamina = 30;
        lives = 3;

        this.keyToGoLeft    = KeyEvent.VK_A;
        this.keyToGoRight   = KeyEvent.VK_D;
        this.keyToAccelerate = KeyEvent.VK_SHIFT;


        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(157,152,3,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);

    }

    @Override
    public void update(double dt) {
        //TODO 05 Überarbeiten Sie die Update-Methode derart, dass ein Player-Objekt nicht den Bildschirm verlassen kann und immer zu sehen ist.
        if(direction == 0 && canMover){
            x = x + speed*dt;
        }
        if(direction == 2 && canMovel){
            x = x - speed*dt;
        }
        if(x<=0){
            canMovel = false;
        }else {
            canMovel = true;
        }
        if(x>=1000-width){
            canMover = false;
        }else {
            canMover = true;
        }
        if(stamina <= 30 && !isKeyDown(keyToAccelerate)){
            stamina += 10*dt;
        }
        deltaTime = dt;
        if(isKeyDown(keyToAccelerate) && stamina > 0){
            speed = runSpeed;
            stamina -= 10*deltaTime;
        }else {
            speed = walkSpeed;
        }
        if(lives > 3 ){
            lives = 3;
        }
    }
    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;

        }
        if(key == keyToGoRight){
            direction = 0;
        }

        //if(key != keyToGoLeft && key != keyToGoRight){
          //  direction = -1;
        //}
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft && direction == 2){
            direction = -1;
        }
        if(key == keyToGoRight && direction == 0){
            direction = -1;
        }

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
