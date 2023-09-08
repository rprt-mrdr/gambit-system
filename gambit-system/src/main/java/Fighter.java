/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author geoff
 */
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Fighter {

    boolean alive;

    String name;
    Map<String, Integer> stats = new HashMap<>();
    int level;

    //attribute for attack 
    //attribute for active defend
    int health;
    //health points, 0 = taken out
    //half strength, * level, + 5
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
        stats.put("strength", rng.nextInt(2, 7) * 2);
        stats.put("dexterity", rng.nextInt(2, 7) * 2);
        level = 1;
        health = (((16 - stats.get("strength")) / 2) * level) + 5;
        passiveDefence = stats.get("dexterity") + 2;
        meleeSkill = rng.nextInt(0, 3);
        defendSkill = rng.nextInt(0, 2);
        weapon = new Weapon("sword");
        armour = new Armour("leather");

    }

    public void print() {
        System.out.printf("Name: %s\nStrength: d%d\nDexterity: d%d\n", name,stats.get("strength"), 
                stats.get("dexterity"));
    }

    

    public void meleeAttack(Fighter target) {
        Check meleeCheck = new Check(stats.get(weapon.attribute),
                meleeSkill);
        Check defendCheck = target.defend();
        int damage = 0;
        System.out.printf("\n%s attacks %s\n", name, target.name);
        boolean hit = meleeCheck.score <= defendCheck.score;

        //need to lower bound effect
        if (hit) {
            damage = weapon.effectTable.effectTable[meleeCheck.boundEffect].damage - 
                    target.armour.effectTable.effectTable[defendCheck.boundEffect].resistance;

            if (damage > 0) {
                System.out.printf("\nattack hits for %d damage\n", damage);
            } else {
                System.out.println("damage resisted!");
            }

        } else {
            System.out.println("attack missed");
        }
        target.takeDamage(damage);

    }

    public Check defend() {
        Check check = new Check(stats.get("dexterity"), defendSkill, 8);

        return check;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            alive = false;
            System.out.printf("%s has fallen!\n", name);
        }
    }

}
