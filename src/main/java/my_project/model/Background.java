package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
//import my_project.control.ProgramController;
import java.awt.*;

/**
 * Die Background-Klasse stellt die Umsetzung eines Objekts für den Hintergrund des Apple-Games dar.
 * Hier werden sogenannte Arrays (zu deutsch: Felder) verwendet, die im Unterricht noch nicht behandelt wurden.
 */

public class Background extends GraphicalObject {

    //Referenzen
    String chosenPhrase;
    String[] phrases = new String[]{"\"An apple a day keeps the doctor away!\" - England",
            "\"Eat an apple on going to bed, and you’ll keep the doctor from earning his bread.\" - Wales",
            "\"Ein Apfel am Tag, Arzt gespart!\" - Deutschland",
            "\"Una mela al giorno toglie il medico di torno.\" - Italien",
            "\"Jedna jabuka na dan, i doktor ti neće ući u stan.\" - Serbien",
            "\"Günde bir elma Doktoru uzak tutar.\" - Türkei",
            "\"Rojek sêvek doktor dûr dike\" - Kurdisch",
            "\"تفاحة على الريق تغنيك عن الطبيب\" - Arabisch"};


    public Background(){
        chosenPhrase = phrases[(int)(Math.random()*phrases.length)];
        this.setNewImage("src/main/resources/graphic/Heartpng 99x10.png");
    }

    @Override
    public void draw(DrawTool drawTool) {


        drawTool.setCurrentColor(25,100,0,255);
        drawTool.drawFilledRectangle(0,0,1600,1024);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.formatText("Arial",1,20);
        drawTool.drawText(50,50,chosenPhrase);
        drawTool.setCurrentColor(Color.blue);
        drawTool.drawFilledRectangle(50,130,Player.getStamina()*6 ,40);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.formatText("Arial",1,20);
        drawTool.drawText(50,105,"Points:" + Player.getPoints());
        if(Player.getLives() >= 1){
            drawTool.drawImage(this.getMyImage(),50,180);
            if(Player.getLives() >= 2){
                drawTool.drawImage(this.getMyImage(),150,180);
                if(Player.getLives() >= 3){
                    drawTool.drawImage(this.getMyImage(),250,180);
                }
            }
        }
    }

    @Override
    public void update(double dt) {

    }

}