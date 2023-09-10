
public class Armour extends Gear {

    Armour(String name) {
        this.name = name;
        switch (name) {
            case "leather" -> {
                effectTable.applyResistanceValues(GearFactory.basicTable(0,0,0,2,3));
            }
            case "chain" -> {
                effectTable.applyResistanceValues(GearFactory.basicTable(0,1,1,2));
            }
            case "plate" -> {
                effectTable.applyResistanceValues(GearFactory.basicTable(2,1,1,2));
            }
            case "unarmoured" -> {
                effectTable.applyResistanceValues(GearFactory.basicTable(0,0,0));
            }
            default -> {
                effectTable.applyResistanceValues(GearFactory.basicTable(0,0,0));
            }
        }

    }

}
