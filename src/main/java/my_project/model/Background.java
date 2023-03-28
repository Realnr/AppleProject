package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import java.awt.*;
import java.util.Arrays;

/**
 * Die Background-Klasse stellt die Umsetzung eines Objekts für den Hintergrund des Apple-Games dar.
 * Hier werden sogenannte Arrays (zu deutsch: Felder) verwendet, die im Unterricht noch nicht behandelt wurden.
 */

public class Background extends GraphicalObject {

    //Referenzen
    private String chosenPhrase;
    private String[] phrases = new String[]{"\"An apple a day keeps the doctor away!\" - England",
            "\"Eat an apple on going to bed, and you’ll keep the doctor from earning his bread.\" - Wales",
            "\"Ein Apfel am Tag, Arzt gespart!\" - Deutschland",
            "\"Una mela al giorno toglie il medico di torno.\" - Italien",
            "\"Jedna jabuka na dan, i doktor ti neće ući u stan.\" - Serbien",
            "\"Günde bir elma Doktoru uzak tutar.\" - Türkei",
            "\"Rojek sêvek doktor dûr dike\" - Kurdisch",
            "\"تفاحة على الريق تغنيك عن الطبيب\" - Arabisch"};
    private Player[] player;

    public Background(Player[] player){
        chosenPhrase = phrases[(int)(Math.random()*(phrases.length-1))];
        this.setNewImage("src/main/resources/graphic/Heartpng 99x10.png");
        this.player = player;
    }


    @Override
    public void draw (DrawTool drawTool){


        drawTool.setCurrentColor(25, 100, 0, 255);
        drawTool.drawFilledRectangle(0, 0, 1600, 1024);
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.formatText("Arial", 1, 20);
        drawTool.drawText(50, 50, chosenPhrase);

        for(int i = 0; i < player.length;i++) {
            drawTool.setCurrentColor(Color.blue);
            drawTool.drawFilledRectangle(50, 130 + i * 50, player[i].getStamina() * 6, 40);

        }
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.formatText("Arial", 1, 20);
        drawTool.drawText(50, 105, "Points:" + (player[0].getPoints() + player[1].getPoints() ));
//        for(int i = 0; i  <= 2; i++) {
//            if (player.getLives() >= i) {
//                drawTool.drawImage(this.getMyImage(), 50 + i * 100, 180);
//            }
//        }

    }

    @Override
    public void update(double dt) {

    }

}