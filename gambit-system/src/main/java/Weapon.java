/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a
 */
public class Weapon extends Gear {

    String attribute;
    String type;
    //crushing, piercing, etc

    Weapon(String name) {
        this.name = name;
        switch (name) {

            case "sword" -> {
                effectTable = generateEffectTable("linear", 2, true);
                attribute = "strength";
            }
            case "axe" -> {
                effectTable = generateEffectTable("shallow", 2, true);
                attribute = "strength";
            }
            case "dagger" -> {
                effectTable = generateEffectTable("linear", 2, true);
                attribute = "strength";
            }
            case "staff" -> {
                effectTable = generateEffectTable("", 2, false);
                attribute = "strength";
            }
            default -> {
            }
        }

    }

    public final Effect[] generateEffectTable(String shape, int base, boolean bleed) {
        String[] increments;
        
        
        Effect[] effectTable = super.generateEffectTable();
        for (int i = 0; i < 13; i++) {
            effectTable[i].damage = base;

        }
        return effectTable;
    }

}
