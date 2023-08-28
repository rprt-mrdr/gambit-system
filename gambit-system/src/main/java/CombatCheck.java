/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author geoff
 */
import java.util.Random;
import java.util.Scanner;

public class CombatCheck {

    Check attackRoll;
    Check defendRoll;
    int attackBonus;
    int defendBonus;
    int attackFinal;
    int defendFinal;
    boolean success = false;
    String result;
    
    int effect = 0;
    //total result, attacker minus defender
    CombatCheck() {

    }

    CombatCheck(Check atk, int atkBonus, Check def, int defBonus) {
        attackRoll = atk;
        attackBonus = atkBonus;
        attackFinal = attackRoll.score - attackBonus;

        defendRoll = def;
        defendBonus = defBonus;
        defendFinal = defendRoll.score - defendBonus;

        success = attackFinal <= defendFinal;
        result = success ? "Success" : "Failure";

        effect = attackRoll.effect - defendRoll.effect;
    }

    public void print() {
        System.out.printf("Attacker:        d%d d%d, %+d \nDefender:        d%d d%d, %+d\n",
                attackRoll.attributeSize, attackRoll.gambitSize, attackRoll.modifier,
                defendRoll.attributeSize, defendRoll.gambitSize, defendRoll.modifier);
        System.out.printf("Attacker rolled: %d, %d\nDefender rolled: %d, %d\n",
                attackRoll.attributeResult, attackRoll.gambitResult,
                defendRoll.attributeResult, defendRoll.gambitResult);
        System.out.printf("Attack score: %d effect: %d\n",
                attackRoll.score, attackRoll.effect);
        System.out.printf("Defend score: %d effect: %d\n",
                defendRoll.score, defendRoll.effect);

        System.out.printf("--------\n%s\nEffect: %d\n--------\n", result, effect);
    }

    public void printB() {

        //attackRoll.print();
        //defendRoll.print();
        System.out.printf("Attack\n------\n"
                + "Attribute:\td%d\tRolled:\t\t%d\n"
                + "Gambit:\t\td%d\tRolled:\t\t%d\n"
                + "Difference:\t%d\tModifier:\t%d\n"
                + "Effect:\t\t%d\tScore:\t\t%d\n\n",
                attackRoll.attributeSize, attackRoll.attributeResult,
                attackRoll.gambitSize, attackRoll.gambitResult,
                attackRoll.difference, attackRoll.modifier,
                attackRoll.effect, attackRoll.score);
        System.out.println("effect range: " + attackRoll.effectRange);
        System.out.printf("------\nDefend\n------\n"
                + "Attribute:\td%d\tRolled:\t\t%d\n"
                + "Gambit:\t\td%d\tRolled:\t\t%d\n"
                + "Difference:\t%d\tModifier:\t%d\n"
                + "Effect:\t\t%d\tScore:\t\t%d\n\n",
                defendRoll.attributeSize, defendRoll.attributeResult,
                defendRoll.gambitSize, defendRoll.gambitResult,
                defendRoll.difference, defendRoll.modifier,
                defendRoll.effect, defendRoll.score);
        System.out.println("effect range: " + defendRoll.effectRange);
        System.out.printf("%s by %d\nEffect: %d\n----------------------\n", 
                result, Math.abs(attackRoll.score - defendRoll.score),
                effect);

    }

    public static void combatAnalysis(int count) {
        int sampleSize = count;
        
        Scanner input = new Scanner(System.in);
        
        int successCount = 0;
        float successPercentage;
        int effectTotal = 0;
        float averageEffect;

        System.out.println("enter details for attack\n"
                + "attribute, modifier, gambit, bonus");
        int attackAttribute = input.nextInt();
        int attackModifier = input.nextInt();
        int attackGambit = input.nextInt();
        int attackBonus = input.nextInt();

        System.out.println("enter details for defend\n"
                + "attribute, modifier, gambit, bonus");
        int defendAttribute = input.nextInt();
        int defendModifier = input.nextInt();
        int defendGambit = input.nextInt();
        int defendBonus = input.nextInt();
        
        //loop
        for (int i = 0; i < sampleSize; i++){
            CombatCheck check = new CombatCheck(new Check(attackAttribute,
                    attackModifier, attackGambit), attackBonus,
            new Check(defendAttribute, defendModifier, defendGambit), defendBonus);
            if (check.success){
                successCount++;
            }
            effectTotal += check.effect;
        }
        System.out.println(successCount);
        averageEffect = (float)effectTotal / sampleSize;
        successPercentage = ((float)successCount / sampleSize) * 100;
        System.out.printf("Success: %.2f%%\nAverage effect: %.2f", successPercentage, averageEffect);

    }
    
    //TESTING
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {        
        CombatCheck check = new CombatCheck(Check.randomCheck(), 0,
                Check.randomCheck(), 0);
        check.printB();
        }
        //combatAnalysis(10000);
//        for (int i = 0; i < 10; i++) {
//            int attribute = rng.nextInt(2, 7)*2;
//            int modifier = rng.nextInt(-1, 4);
//            int gambit = rng.nextInt(2, 7)*2;
//            CheckSimple c2 = new CheckSimple(attribute, modifier, gambit);
//            c2.printB();
//        }
//        for (int i = 0; i < 10; i++) {
//            CombatCheck c = new CombatCheck(new CheckSimple(6, 0, 10), 0,
//                    new CheckSimple(12, 0, 8), 0);
//            c.print();
//
//        }
    }

}
