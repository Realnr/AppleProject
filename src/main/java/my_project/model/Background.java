package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
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
    private Player player;

    public Background(Player player){
        chosenPhrase = phrases[(int)(Math.random()*phrases.length)];
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
        drawTool.setCurrentColor(Color.blue);
        drawTool.drawFilledRectangle(50, 130, player.getStamina() * 6, 40);
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.formatText("Arial", 1, 20);
        drawTool.drawText(50, 105, "Points:" + player.getPoints());
        /*int i;
        for(i = 0; i  <= 2; i++) {
            if (player.getLives() >= i) ;
            drawTool.drawImage(this.getMyImage(), 50 + i * 100, 180);
        }
        if (i == 2) {
            i = -1;
        }*/
        if (player.getLives() >= 1) {
            drawTool.drawImage(this.getMyImage(), 50, 180);
            if (player.getLives() >= 2) {
                drawTool.drawImage(this.getMyImage(), 150, 180);
                if (player.getLives() >= 3) {
                    drawTool.drawImage(this.getMyImage(), 250, 180);
                }
            }
        }
    }



    @Override
    public void update(double dt) {

    }

}