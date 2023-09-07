/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a
 */
import java.util.Arrays;
public class GearFactory {
    
    public static void main (String[] args){
        System.out.println(Arrays.toString(weaponDamageTable(2,1,3,6)));
        System.out.println(Arrays.toString(weaponDamageTable(2,1,1,1,1,5)));
        System.out.println(Arrays.toString(weaponDamageTable(2,1,1,1,1,1,5)));
        System.out.println(Arrays.toString(weaponDamageTable(2,1,1,1,1,1,1,5)));
    }

    private static int[] segment(int base, int length) {
        int [] segmentValues = new int[2];
        switch (base) {
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

    public static int[] weaponDamageTable(int... a) {

        int[] damageTable = new int[13];
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
        int critBonus = a[a.length-1];
        int segments = a.length - 2;
        //number of segments
        int segmentLength = 12 / segments;
        //breaks down >4
        
        int[] segmentIncreases = new int[segments];
        //middle elements of a
        for (int i = 0; i < segments; i++){
            segmentIncreases[i] = a[i+1];
        }
        System.out.println("segment increases" + Arrays.toString(segmentIncreases));
        System.out.println("base damage " + baseDamage);
        damageTable[0] = baseDamage;
        int segmentValue;
        int previousSegmentValue = baseDamage;
        
        for (int i = 0; i < segments; i++) {
            segmentValue = previousSegmentValue + segmentIncreases[i];
            previousSegmentValue = segmentValue;
            System.out.println("segment " + (i+1) + " value " + segmentValue);
            for (int j = 0; j < segmentLength; j++){
                damageTable[(i*segmentLength)+j+1] = segmentValue;
                System.out.println("slot " + ((i*segmentLength)+j+1) + " holds value " + segmentValue);
            }

        }
        damageTable[12] += critBonus;


        return damageTable;
    }

}
