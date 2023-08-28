/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a
 */
public class Weapon {
    
    String name;
    String type;
    //crushing, piercing, etc
    int[] damageTable;
    
    Weapon(String name){
        this.name = name;
        switch (name){
            case "sword" -> {
                damageTable = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 8};
            }
            case "axe" -> {
                damageTable = new int[]{2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 6, 9};
            }
            case "dagger" -> {
                damageTable = new int[]{1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 12};
            }
            case "staff" -> {
                damageTable = new int[]{2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4};
            }
            default -> {
                damageTable = new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3};
            }
        }
        
    }
    
}
