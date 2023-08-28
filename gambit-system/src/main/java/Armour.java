/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a
 */
public class Armour {
    
    String name;
    int[] resistanceTable;
    
    Armour(String name){
        this.name = name;
        switch (name){
            case "leather" -> {
                resistanceTable = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 8};
            }
            case "chain" -> {
                resistanceTable = new int[]{2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 6, 9};
            }
            case "plate" -> {
                resistanceTable = new int[]{1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 12};
            }
            default -> {
                resistanceTable = new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3};
            }
        }
        
    }
    
}
