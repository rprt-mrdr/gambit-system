
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Gear {

    String name;
    EffectTable effectTable;

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

//    public EffectTable generateEffectTable() {
//        effectTable = new EffectTable();
//        
//
//        return effectTable;
//    }

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
        effectTable = new EffectTable();

    }
    


}
