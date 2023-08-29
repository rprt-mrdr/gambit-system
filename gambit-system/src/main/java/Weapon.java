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
                effectTable = generateEffectTable(new int[]{1, 0, 1, 2}, 2, true);
                attribute = "strength";
            }
            case "axe" -> {
                effectTable = generateEffectTable(new int[]{3, 3, 3, 3}, 2, true);
                attribute = "strength";
            }
            case "dagger" -> {
                effectTable = generateEffectTable(new int[]{}, 1, true);
                attribute = "dexterity";
            }
            case "staff" -> {
                effectTable = generateEffectTable(new int[]{}, 2, false);
                attribute = "strength";
            }
            default -> {
            }
        }

    }

    public final Effect[] generateEffectTable(int[] shape, int base, boolean bleed) {

        Effect[] effectTable = super.generateEffectTable();
        effectTable[0].damage = base;
        effectTable[0].details += base + " damage\n";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                base += effectValueIncrement(shape[i])[new Roll(12).result];
                effectTable[(3 * i) + j + 1].damage = base;
                effectTable[(3 * i) + j + 1].details += base + " damage\n";

            }
        }
        return effectTable;
    }

}
