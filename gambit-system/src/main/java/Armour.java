/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a
 */
public class Armour extends Gear {

    int[] resistanceTable;
    
    public static int[] generateResistanceTable(String shape, int base){
        int[] table = new int[12];
        table[0] = base;
        //sets base resistance
        return table;
    }

    Armour(String name) {
        this.name = name;
        switch (name) {
            case "leather" -> {
                effectTable.applyResistanceValues(GearFactory.weaponDamageTable(0,0,0,2,3));
            }
            case "chain" -> {
                effectTable.applyResistanceValues(GearFactory.weaponDamageTable(0,1,1,2));
            }
            case "plate" -> {
                effectTable.applyResistanceValues(GearFactory.weaponDamageTable(2,1,1,2));
            }
            case "unarmoured" -> {
                effectTable.applyResistanceValues(GearFactory.weaponDamageTable(0,0,0));
            }
            default -> {
                effectTable.applyResistanceValues(GearFactory.weaponDamageTable(0,0,0));
            }
        }

    }

}
