/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a
 */
import java.util.Random;
public class Gear {
    
    String name;
    
    public static Gear randomGear(){
        Random rng = new Random();
        switch (rng.nextInt(0, 2)){
            case 1 -> {
                return new Weapon("sword");
            }
            case 2 -> {
                return new Armour("leather");
            }
            default -> {
                return new Weapon("dagger");
            }
        }
        
    }
    
    public int[] generateEffectTable(){
        return new int[]{};
    }
    
    Gear(){
        
    }
    
}
