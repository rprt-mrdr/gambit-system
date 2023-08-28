/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author geoff
 */
import java.util.Random;

public class Fighter {
    boolean alive;
    
    String name;

    int strength;
    //attribute for attack 
    int dexterity;
    //attribute for active defend
    int health;
    //health points, 0 = taken out
    int passiveDefence;
    //passive defend check difficulty, derived from dex
    int meleeSkill;
    //attack modifier
    int defendSkill;
    //active defend modifier? shield-based class only?
    Weapon weapon;
    Armour armour;

    Fighter(String name) {
        Random rng = new Random();
        this.name = name;
        alive = true;
        strength = rng.nextInt(2, 7) * 2;
        dexterity = rng.nextInt(2, 7) * 2;
        health = 16 - strength;
        passiveDefence = dexterity + 2;
        meleeSkill = rng.nextInt(0, 3);
        defendSkill = rng.nextInt(0, 2);
        weapon = new Weapon("sword");
        armour = new Armour("leather");

    }

    public void print() {
        System.out.printf("Strength: d%d\nDexterity: d%d\n", strength, dexterity);
    }

    public final int[] generateDamageTable(String weapon) {
        int[] table;
        switch (weapon) {
            case "sword" -> {
                table = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 8};
            }
            case "axe" -> {
                table = new int[]{2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 6, 9};
            }
            case "dagger" -> {
                table = new int[]{1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 12};
            }
            case "staff" -> {
                table = new int[]{2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4};
            }
            default -> {
                System.out.println("unarmed attack");
                table = new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3};
            }
        }
        return table;
    }

    public final int[] generateResistanceTable(String armour) {
        int[] table;
        switch (armour) {
            case "leather" -> {
                table = new int[]{};
            }
            case "studded" -> {
                table = new int[]{};
            }
            case "chain" -> {
                table = new int[]{};
            }
            case "plate" -> {
                table = new int[]{};
            }
            default -> {
                table = new int[]{};
            }
        }
        return table;
    }

    public void meleeAttack(Fighter target) {
        Check meleeCheck = new Check(strength, meleeSkill, 8);
        Check defendCheck = target.defend();
        int damage = 0;
        System.out.printf("\n%s attacks %s\n", name, target.name);
        boolean hit = meleeCheck.score <= defendCheck.score;
        
        //need to lower bound effect
        if (hit) {
            
            damage = weapon.damageTable[meleeCheck.effect - meleeCheck.effectMin] - 
                    target.armour.resistanceTable[defendCheck.effect - defendCheck.effectMin];
            if (damage > 0){
                System.out.printf("\nattack hits for %d damage\n", damage);
            }else{
                System.out.println("damage resisted!");
            }
            
        }else{
            System.out.println("attack missed");
        }
        target.takeDamage(damage);
        

    }
    
    public Check defend(){
        Check check = new Check(dexterity, defendSkill, 8);
        
        return check;
    }
    
    public void takeDamage(int damage){
        health -= damage;
        if (health <= 0){
            health = 0;
            alive = false;
            System.out.printf("%s has fallen!\n", name);
        }
    }

}
