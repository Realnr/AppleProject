package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.*;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.

    private Apple apple01;
    private Pear pear01;
    private Player player;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        //StartScreen S = new StartScreen();
        player = new Player(50, Config.WINDOW_HEIGHT-400);
        Background B = new Background(player);


        //double xPos = Math.random() * (Config.WINDOW_WIDTH - 50) + 50;
        //double yPos = 0;
        apple01 = new Apple(Math.random() * (Config.WINDOW_WIDTH - 50) + 50, 0, player);


        //xPos = Math.random() * (Config.WINDOW_WIDTH - 50) + 50;
        //yPos = 0;
        pear01 = new Pear(Math.random() * (Config.WINDOW_WIDTH - 50) + 50, 0, player);

        viewController.draw(B);
        viewController.draw(pear01);
        viewController.draw(apple01);
        viewController.draw(player);
        viewController.register(player);

    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){
        collision(apple01);
        collision(pear01);
    }
    public void collision(Fruit f){
        if(f.collidesWith(player)){
            f.jumpBack();
            player.setPoints(player.getPoints()+1);
            player.setLives(player.getLives()+1);
        }
    }
}
