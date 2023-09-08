/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a
 */
public class Effect {

    int misc;
    int damage;
    int bleed;
    int resistance;
    boolean disarm;
    String details;

    Effect() {
        misc = 0;
        damage = 0;
        bleed = 0;
        resistance = 0;
        disarm = false;
        details = "\n";
    }
    
    public void printEffect(){
        System.out.println(damage + " damage");
    }
}
