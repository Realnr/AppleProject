package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.*;

import java.awt.event.KeyEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.



    private Player[] player = new Player[2];
    private Fruit[] allFruits = new Fruit[12];

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
       // player = new Player(50, Config.WINDOW_HEIGHT-400, KeyEvent.VK_D,KeyEvent.VK_A,KeyEvent.VK_SHIFT);
        fillPlayer(player);
        fillAllFruits(allFruits);
        Background B = new Background(player);





        viewController.draw(B);
        drawAllPlayers(viewController);
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
            for (Player player : player)
            if (f.collidesWith(player)) {
                f.jumpBack();
                if (f instanceof Apple || f instanceof Grape) {
                    player.setPoints(player.getPoints() + 1);
                }else {
                    player.setPoints(player.getPoints() - 1);
                }
//                player.setLives(player.getLives() + 1);
                if(f instanceof PowerApple && player.getSpeed() < 250){
                    player.setSpeed(player.getSpeed() + ((PowerApple) f).getSpeedBuff());
                }else if(f instanceof rottenPear){
                    player.setStamina(((rottenPear) f).getRot());
                }else if(f instanceof Grape){
                    player.setStamina(player.getStamina() + ((Grape) f).getStaminaBuff());
                }
            }
        }
    }
    public void fillAllFruits(Fruit[] Array){
        for(int i = 0; i < Array.length;i++){
            if (i < 4) {
                Array[i] = new Apple(Math.random() * (Config.WINDOW_WIDTH - 50) + 50, 0);
            }else if(i < 8){
                Array[i] = new Pear(Math.random() * (Config.WINDOW_WIDTH - 50) + 50, 0);
            }else if (i < 10) {
                Array[i] = new PowerApple(Math.random() * (Config.WINDOW_WIDTH - 50) + 50, 0);
            }else if (i < 11) {
                Array[i] = new rottenPear(Math.random() * (Config.WINDOW_WIDTH - 50) + 50, 0);
            }else if(i < 12) {
                Array[i] = new Grape(Math.random() * (Config.WINDOW_WIDTH - 50) + 50, 0);
            }
        }
    }
    public void drawAllFruits(ViewController view){
        for(Fruit f : allFruits){
            view.draw(f);

        }
    }
    public void fillPlayer(Player[] player){
        for(int i = 0; i < player.length;i++){
            if( i < 1){
                player[i] = new Player(50, Config.WINDOW_HEIGHT-400, KeyEvent.VK_D,KeyEvent.VK_A,KeyEvent.VK_SHIFT);
            }else if(i < 2) {
                player[i] = new Player(50, Config.WINDOW_HEIGHT-400, KeyEvent.VK_RIGHT,KeyEvent.VK_LEFT,KeyEvent.VK_CONTROL);
            }

        }
    }
    public void drawAllPlayers(ViewController view){
        for(Player p : player){
            view.draw(p);
            view.register(p);
        }
    }
}
