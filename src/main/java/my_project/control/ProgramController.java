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


    private Player player;
    private Fruit[] allFruits = new Fruit[11];

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
        fillArray(allFruits);




        viewController.draw(B);
        viewController.draw(player);
        viewController.register(player);
        drawAllFruits(viewController);

    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){
//        System.out.println(allFruits[1].getY());
        collision();

    }
    public void collision(){
        for(Fruit f : allFruits) {
            if (f.collidesWith(player)) {
                f.jumpBack();
                player.setPoints(player.getPoints() + 1);
//                player.setLives(player.getLives() + 1);
                if(f instanceof PowerApple && player.getSpeed() < 250){
                    player.setSpeed(player.getSpeed() + ((PowerApple) f).getSpeedBuff());
                }else if(f instanceof rottenPear){
                    player.setStamina(((rottenPear) f).getRot());
                }
            }
        }
    }
    public void fillArray(Fruit[] Array){
        for(int i = 0; i < Array.length;i++){
            if (i < 4) {
                Array[i] = new Apple(Math.random() * (Config.WINDOW_WIDTH - 50) + 50, 0, player);
            }else if(i < 8){
                Array[i] = new Pear(Math.random() * (Config.WINDOW_WIDTH - 50) + 50, 0, player);
            }else if (i < 10) {
                Array[i] = new PowerApple(Math.random() * (Config.WINDOW_WIDTH - 50) + 50, 0, player);
            }else if (i < 11) {
                Array[i] = new rottenPear(Math.random() * (Config.WINDOW_WIDTH - 50) + 50, 0, player);
            }
        }
    }
    public void drawAllFruits(ViewController view){
        for(Fruit f : allFruits){
            view.draw(f);
        }
    }
}
