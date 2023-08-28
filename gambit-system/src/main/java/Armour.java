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

    Armour(String name) {
        this.name = name;
        switch (name) {
            case "leather" -> {
                resistanceTable = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2};
            }
            case "chain" -> {
                resistanceTable = new int[]{0,0,1,1,1,1,2,2,3,3,4,4};
            }
            case "plate" -> {
                resistanceTable = new int[]{1,1,2,2,2,2,3,3,4,4,5,6};
            }
            case "unarmoured" -> {
                resistanceTable = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            }
            default -> {
                resistanceTable = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
            }
        }

    }

}
