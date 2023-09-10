
public class Effect {

    int miscA;
    int miscB;
    int damage;
    int bleed;
    int resistance;
    boolean disarm;
    String details;

    Effect() {
        miscA = 0;
        miscB = 0;
        damage = 0;
        bleed = 0;
        resistance = 0;
        disarm = false;
        details = "\n";
    }

    public void printEffect() {
        if (damage > 0) {
            System.out.println(damage + " damage");
        }
        if (miscA > 0) {
            System.out.println(miscA + " misc");
        }
    }
}
