
import java.util.Random;
import java.util.Scanner;

public class Check {

    int attributeResult;
    int gambitResult;
    int modifier;
    int attributeSize;
    int gambitSize;
    int score;
    int difference;
    int effect;
    int boundEffect;
    int scoreMin;
    int scoreMax;
    int scoreRange;
    int effectMin;
    int effectMax;
    int effectRange;
    Roll[] check;
    
    Check(){
        Scanner input = new Scanner(System.in);
        System.out.println("enter attribute");
        int attributeChoice = input.nextInt();
        System.out.println("enter modifier");
        int modifierChoice = input.nextInt();
        System.out.println("enter gambit");
        int gambitChoice = input.nextInt();
        
        check = new Roll[]{new Roll(attributeChoice), new Roll(gambitChoice)};
        this.modifier = modifierChoice;
        
        attributeResult = check[0].result;
        gambitResult = check[1].result;
        attributeSize = check[0].size;
        gambitSize = check[1].size;

        interpret();
    }

    Check(int attribute, int modifier, int gambit) {

        check = new Roll[]{new Roll(attribute), new Roll(gambit)};
        this.modifier = modifier;
        attributeResult = check[0].result;
        gambitResult = check[1].result;
        attributeSize = check[0].size;
        gambitSize = check[1].size;

        interpret();

    }

    Check(int attribute, int modifier) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter gambit: 4, 6, 8, 10 or 12");
        int gambitChoice = input.nextInt();

        check = new Roll[]{new Roll(attribute), new Roll(gambitChoice)};
        this.modifier = modifier;
        attributeResult = check[0].result;
        gambitResult = check[1].result;
        attributeSize = check[0].size;
        gambitSize = check[1].size;

        interpret();

    }

    public static Check randomCheck() {
        Random rng = new Random();
        int attribute = rng.nextInt(2, 7) * 2;
        int modifier = rng.nextInt(-1, 4);
        int gambit = rng.nextInt(2, 7) * 2;
        return new Check(attribute, modifier, gambit);
    }

    private void interpret() {
        //score = attributeResult + gambitResult
        //in this version, the difference is subtracted from the gambit size
        scoreMin = 2 - modifier;
        scoreMax = attributeSize + gambitSize - modifier;
        scoreRange = (scoreMax - scoreMin) + 1;

        score = attributeResult + gambitResult - modifier;

        difference = Math.abs(attributeResult - gambitResult);
        int largerSize = attributeSize > gambitSize ? attributeSize : gambitSize;

        effectMin = (gambitSize - largerSize) + 1;
        effectMax = gambitSize;
        effectRange = (effectMax - effectMin) + 1;
        effect = gambitSize - difference;
        boundEffect = effect > 0 ? effect : 0;

    }

    void print() {

        System.out.printf("%d / %d, %d / %d\nModifier: %+d Score: %d Difference: %d Effect: %d\n\n",
                check[0].result,
                check[0].size, check[1].result,
                check[1].size, (-modifier),
                score, difference, effect);
    }

}
