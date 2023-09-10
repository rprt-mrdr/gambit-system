public class Weapon extends Gear {

    String attribute;
    String type;
    //crushing, piercing, etc

    Weapon(String name) {
        this.name = name;
        switch (name) {

            case "sword" -> {
                effectTable.applyDamageValues(GearFactory.basicTable(2,2,1,3,4));
                attribute = "strength";
                type = "slashing";
            }
            case "axe" -> {
                effectTable.applyDamageValues(GearFactory.basicTable(2,4,1,4,2));
                attribute = "strength";
                type = "slashing";
            }
            case "dagger" -> {
                effectTable.applyDamageValues(GearFactory.basicTable(1,2,10));
                attribute = "dexterity";
                type = "piercing";
            }
            case "staff" -> {
                effectTable.applyDamageValues(GearFactory.basicTable(3,0,0));
                attribute = "strength";
                type = "crushing";
            }
            default -> {
            }
        }

    }

//    public final EffectTable generateEffectTable(int[] shape, int base, boolean bleed) {
//
//        Effect[] effectTable = super.generateEffectTable();
//        effectTable[0].damage = base;
//        effectTable[0].details += base + " damage\n";
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 3; j++) {
//                base += effectValueIncrement(shape[i])[new Roll(12).result];
//                effectTable[(3 * i) + j + 1].damage = base;
//                effectTable[(3 * i) + j + 1].details += base + " damage\n";
//
//            }
//        }
//        return effectTable;
//    }

}
