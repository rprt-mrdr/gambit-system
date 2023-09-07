/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a
 */
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Gear {

    String name;
    Effect[] effectTable;

//    public static Gear randomGear() {
//        Random rng = new Random();
//        switch (rng.nextInt(0, 2)) {
//            case 1 -> {
//                return new Weapon("sword");
//            }
//            case 2 -> {
//                return new Armour("leather");
//            }
//            default -> {
//                return new Weapon("dagger");
//            }
//        }
//    }

    public Effect[] generateEffectTable() {
        effectTable = new Effect[13];
        for (int i = 0; i < 13; i++){
            effectTable[i] = new Effect();
        }

        return effectTable;
    }

    //THIS NEEDS REAL VALUES
    public int[] effectValueIncrement(int increment) {
        switch (increment) {
            case 0 -> {
                return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1};
            }
            case 1 -> {
                return new int[]{};
            }
            case 2 -> {
                return new int[]{2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3};
            }
            case 3 -> {
                return new int[]{3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4};
            }
            default -> {
                return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            }
        }
    }
    /*generates an array of values generated segment-wise
    
    argument must include following:
    -number of segments and base length, as an array?
    -
    
    each segment consists of base length and increment, as determined by 
    an effect table? length on success, bonus on effect
    
    margin of success determines length, up/down according. bonus damage determined by effect.
    */
    public int[] effectValueSegment(){
        return new int[13];
    }

    Gear() {

    }
    
    public void printEffectTable(){
        for (int i = 0; i < 13; i++){
            System.out.println(i + " - " + effectTable[i].details);
        }
    }

}
