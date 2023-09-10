
import java.util.Arrays;

public class GearFactory {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(basicTable(2, 1, 3, 6)));
//        System.out.println(Arrays.toString(basicTable(2, 1, 1, 1, 1, 5)));
//        System.out.println(Arrays.toString(basicTable(2, 1, 1, 1, 1, 1, 5)));
//        System.out.println(Arrays.toString(basicTable(2, 1, 1, 1, 1, 1, 1, 5)));
//        System.out.println(Arrays.toString(basicTable(3,0,7)));
//        System.out.println(Arrays.toString(basicTable(1,1,6,2,4)));
//        Weapon sword = new Weapon("sword");
//        sword.effectTable.printEffectTable();
//        Weapon dagger = new Weapon("dagger");
//        dagger.effectTable.printEffectTable();
        int[] table = dynamicTable(1,1,1,1);

        System.out.println(Arrays.toString(table));
        
    }

    private static int[] segment(int value, int length) {
        int[] segmentValues = new int[2];
        switch (value) {
            case (0) -> {
                return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
            }
            case (1) -> {
                return new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2};
            }
            case (2) -> {
                return new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3};
            }
            case (3) -> {
                return new int[]{};
            }
            case (4) -> {
                return new int[]{};
            }
            default -> {
                return new int[]{};
            }
        }
    }

    public static int[] dynamicTable(int... a) {
        EffectTable lengthAndBonusTable = new EffectTable();

        //use misc for bonus
        lengthAndBonusTable.applyMiscValues(GearFactory.basicTable(0, 0, 1, 1));
        //{0,0,0,0,0,0,0,1,1,1,1,1,2}

        //use damage for length reduction
        lengthAndBonusTable.applyDamageValues(GearFactory.basicTable(0, 0, 0, 1, 1));
        //{0,0,0,0,0,0,0,0,0,1,1,1,2}

        //individual segment length and bonus can vary based on check effect
        //[0] will be base
        //first to second last segment, length dynamic
        //last segment runs through to 12
        int[] dynamicTable = new int[13];
        int segments = a.length - 2;
        int dynamicSegments = segments - 1;
        int baseLength = 12 / segments;
        int[] segmentIncreases = new int[segments];
        //middle elements of a
        for (int i = 0; i < segments; i++) {
            segmentIncreases[i] = a[i + 1];
        }
        int slotsUsed = 1;
        int baseValue = a[0];
        dynamicTable[0] = baseValue;
        int previousSegmentValue = baseValue;
        Check effectCheck;

        int segmentLength;
        int segmentValue;

        //populate dynamic segments
        for (int i = 0; i < dynamicSegments; i++) {
            
            effectCheck = new Check(4, 0, 8);
            effectCheck.print();

            if (effectCheck.score <= 8) {
                segmentLength = baseLength - lengthAndBonusTable.getEffect(effectCheck.boundEffect).damage;
                segmentValue = previousSegmentValue + segmentIncreases[i]
                        + lengthAndBonusTable.getEffect(effectCheck.boundEffect).miscA;
            }else{
                System.out.println(i + " roll failed!");
                segmentLength = baseLength + 1;
                segmentValue = previousSegmentValue;
            }
            System.out.println("Segment " + i + "\nvalue " + segmentValue);
            previousSegmentValue = segmentValue;
            //length still 12 / segments
            //4 segments, 3 dynamic segments
            //length 3 -?, 3 -?, 3 -?, 3 + remainder
            for (int j = 0; j < segmentLength; j++) {
                dynamicTable[slotsUsed] = segmentValue;
                slotsUsed++;
            }
        }
        effectCheck = new Check(4, 0, 8);
        effectCheck.print();
        segmentValue = previousSegmentValue + segmentIncreases[a[a.length - 1]]
                + lengthAndBonusTable.getEffect(effectCheck.boundEffect).miscA;
        System.out.println("final segment value " + segmentValue);
        //populate last/non-dynamic segment

        for (int i = slotsUsed; i < 13; i++) {
            dynamicTable[i] = segmentValue;
            System.out.println("last segment value applied to " + i + ": " + segmentValue);
        }

        dynamicTable[12] += a[a.length - 1];

        return dynamicTable;
    }

    public static int[] basicTable(int... a) {

        int[] basicTable = new int[13];
        /*
        last value crit bonus (increase from last segment on 12)
        first value base damage
        other values describe the base increase of the segment
        
        
        e.g. dagger {3,3,3,3,3,3,3,3,3,3,3,3,10}
        has one segment
        might be called as weaponDamageTable(3,0,7)
        base damage 3, one segment with a 0 increase, crit bonus 7
        with some +/-
        
        axe {1,2,2,2,2,8,8,8,8,10,10,10,14}
        three segments
        each 12/3 = 4 slots long
        weaponDamageTable(1,1,6,2,4)
        base damage 1, first segment 1 increase, 2nd 6 increase, 3rd 2 increase
        
        0 = base damage
        divides the 12 non-0 effect slots according to how many middle elements
        in array, i.e. length - 2
        length
         */
        int baseDamage = a[0];
        int critBonus = a[a.length - 1];
        int segments = a.length - 2;
        //number of segments
        int segmentLength = 12 / segments;
        //breaks down >4

        int[] segmentIncreases = new int[segments];
        //middle elements of a
        for (int i = 0; i < segments; i++) {
            segmentIncreases[i] = a[i + 1];
        }
        //System.out.println("segment increases" + Arrays.toString(segmentIncreases));
        //System.out.println("base damage " + baseDamage);
        basicTable[0] = baseDamage;
        int segmentValue;
        int previousSegmentValue = baseDamage;

        for (int i = 0; i < segments; i++) {
            segmentValue = previousSegmentValue + segmentIncreases[i];
            previousSegmentValue = segmentValue;
            //System.out.println("segment " + (i + 1) + " value " + segmentValue);
            for (int j = 0; j < segmentLength; j++) {
                basicTable[(i * segmentLength) + j + 1] = segmentValue;
                //System.out.println("slot " + ((i * segmentLength) + j + 1) + " holds value " + segmentValue);
            }

        }
        basicTable[12] += critBonus;

        return basicTable;
    }

}
