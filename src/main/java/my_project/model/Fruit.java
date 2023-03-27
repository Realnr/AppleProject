package my_project.model;

import KAGO_framework.model.GraphicalObject;

public class Fruit extends GraphicalObject {

    protected double speed;

    public Fruit(double x, double y){
        this.x = x;
        this.y = y;
//        this.player01 = player01;
        speed = 150;
    }

    @Override
    public void update(double dt) {
        //TODO 01 Ein Apfel soll von oben herab fallen. Sobald er unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 02).
        y += speed*dt;
        if(y > 1050){
            jumpBack();
//            player01.setLives(player01.getLives()-1);
        }
    }

    public void jumpBack(){
        y = 0;
        x = Math.random()*950+25;
        speed += 3;
    }
}
