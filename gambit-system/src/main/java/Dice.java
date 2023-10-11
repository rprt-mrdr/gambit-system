/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author geoff
 */
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Dice {

    private static final Random RANDOM = new Random();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("enter attribute die, then gambit die");
        int attribute = input.nextInt();
        int gambit = input.nextInt();
        analysis(attribute, gambit);

    }

    public static int effect(int gSize, int a, int g) {

        return gSize - Math.abs(a - g);
    }

    public static void analysis(int attribute, int gambit) {

        int possibleRolls = attribute * gambit;
        int effect;
        int score;
        int minEffect = (gambit - Math.max(gambit, attribute)) + 1;
        int possibleEffectValues = (gambit - minEffect) + 1;
        int possibleScoreValues = gambit + attribute - 1;

        int[] effectValues = new int[possibleEffectValues];
        for (int i = 0; i < effectValues.length; i++) {
            effectValues[i] = minEffect + i;
        }

        int[] effectTally = new int[possibleEffectValues];
        for (int i = 0; i < gambit; i++) {

            for (int j = 0; j < attribute; j++) {
                effect = effect(gambit, j + 1, i + 1);
                effectTally[effect - minEffect]++;
            }
        }

        float[] effectPercentage = new float[possibleEffectValues];
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < effectPercentage.length; i++) {
            effectPercentage[i] = Float.parseFloat(df.format(((float) effectTally[i] / possibleRolls) * 100));

        }

        float[] cumulativePercentage = new float[possibleEffectValues];
        float runningTotal = 0;
        for (int i = 0; i < cumulativePercentage.length; i++) {
            runningTotal += effectPercentage[possibleEffectValues - 1 - i];
            cumulativePercentage[possibleEffectValues - 1 - i] = runningTotal;
        }

        int[] scoreValues = new int[possibleScoreValues];
        for (int i = 0; i < scoreValues.length; i++) {
            scoreValues[i] = i + 2;
        }

        int[] scoreTally = new int[possibleScoreValues];
        for (int i = 0; i < gambit; i++) {

            for (int j = 0; j < attribute; j++) {
                score = i + j + 2;
                scoreTally[score - 2]++;
            }

        }

        float[] scorePercentage = new float[possibleScoreValues];
        for (int i = 0; i < scorePercentage.length; i++) {
            scorePercentage[i] = Float.parseFloat(df.format(((float) scoreTally[i] / possibleRolls) * 100));

        }

        float[] cumulativeScorePercentage = new float[possibleScoreValues];
        float scoreRunningTotal = 0;
        for (int i = 0; i < cumulativeScorePercentage.length; i++) {
            scoreRunningTotal += scorePercentage[i];
            cumulativeScorePercentage[i] = scoreRunningTotal;
        }

//        System.out.println("Effect:");
//        for (int i = 0; i < possibleEffectValues; i++) {
//            System.out.printf("%-7d", effectValues[i]);
//        }
//        System.out.println("\nTally, out of " + possibleRolls);
//        for (int i = 0; i < possibleEffectValues; i++) {
//            System.out.printf("%-7d", effectTally[i]);
//        }
//        System.out.println("\nPercent chance:");
//        for (int i = 0; i < possibleEffectValues; i++) {
//            System.out.printf("%-7.2f", effectPercentage[i]);
//        }
//        System.out.println("\nCumulative chance: (chance of rolling this effect or higher)");
//        for (int i = 0; i < possibleEffectValues; i++) {
//            System.out.printf("%-7.2f", cumulativePercentage[i]);
//        }
//        System.out.println("\nScore:");
//        for (int i = 0; i < scoreValues.length; i++) {
//            System.out.printf("%-7d", scoreValues[i]);
//        }
//        System.out.println("\nTally:");
//        for (int i = 0; i < scoreValues.length; i++) {
//            System.out.printf("%-7d", scoreTally[i]);
//        }
//        System.out.println("\nPercent chance:");
//        for (int i = 0; i < scoreValues.length; i++) {
//            System.out.printf("%-7.2f", scorePercentage[i]);
//        }
//        System.out.println("\nCumulative chance: (chance of rolling this score or lower)");
//        for (int i = 0; i < scoreValues.length; i++) {
//            System.out.printf("%-7.2f", cumulativeScorePercentage[i]);
//        }
//        System.out.println();
        
        System.out.println("\n\nEffect (chance higher or equal)\n");
        for (int i = 0; i < possibleEffectValues; i++){
            System.out.printf("%-3d (%.0f%%)\t", effectValues[effectValues.length - 1 - i], cumulativePercentage[effectValues.length - 1 - i]);
            for (int j = 0; j < effectTally[effectValues.length - 1 - i]; j++){
                System.out.print("-");
            }
            
            System.out.println();
        }
        System.out.println("\n\nScore (chance lower or equal)\n");
        for (int i = 0; i < possibleScoreValues; i++){
            System.out.printf("%-3d (%.0f%%)\t", scoreValues[i], cumulativeScorePercentage[i]);
            
            for (int j = 0; j < scoreTally[i]; j++){
                System.out.print("-");
            }
            System.out.println();
        }
        
        int[][] matrix = new int[possibleScoreValues][possibleEffectValues];
        for (int i = 0; i < gambit; i++){
            for (int j = 0; j < attribute; j++){
                matrix[i + j][effect(gambit, j + 1, i + 1) - minEffect]++;
            }
        }
        
//        for (int i = 0; i < matrix.length; i++){
//            System.out.println();
//            for (int j = 0; j < matrix[i].length; j++)
//                System.out.printf(" %d", matrix[i][j]);
//            
//        }

    }

    public static void analysisAlt() {

        System.out.println("enter attribute");
        int attribute = input.nextInt();
        System.out.println("enter modifier");
        int modifier = input.nextInt();
        System.out.println("enter gambit");
        int gambit = input.nextInt();
        System.out.println("score graph? y/n");
        boolean showScoreGraph = input.next().equals("y");
        System.out.println("effect graph? y/n");
        boolean showEffectGraph = input.next().equals("y");
        System.out.println("heat map? y/n");
        boolean showHeatMap = input.next().equals("y");
        System.out.println("cumulative scores? y/n");
        boolean cumulative = input.next().equals("y");

        analysisAlt(attribute, modifier, gambit, showScoreGraph, showEffectGraph, showHeatMap, cumulative);

    }

    public static void analysisAlt(int attribute, int modifier, int gambit, boolean barScore, boolean barEffect, boolean matrix, boolean cumulative) {
        Check sampleCheck = new Check(attribute, modifier, gambit);
        boolean barGraphScore = barScore;
        boolean barGraphEffect = barEffect;
        boolean sampleMatrix = matrix;
        boolean cumulativeScores = cumulative;
        int maxScore = sampleCheck.scoreMax;
        int maxEffect = sampleCheck.effectMax;
        int minScore = sampleCheck.scoreMin;
        int minEffect = sampleCheck.effectMin;
        int rangeScore = sampleCheck.scoreRange;
        int rangeEffect = sampleCheck.effectRange;
        int[] scoreTally = new int[rangeScore];
        int[] effectTally = new int[rangeEffect];
        int[][] effectPerScoreTally = new int[rangeScore][rangeEffect];
        float[] scorePercentages = new float[rangeScore];
        float[] effectPercentages = new float[rangeEffect];

        for (int i = 0; i < 1000000; i++) {
            Check check = new Check(attribute, modifier, gambit);
            scoreTally[check.score - check.scoreMin] += 1;
            effectTally[check.effect - check.effectMin] += 1;
            effectPerScoreTally[check.score - check.scoreMin][check.effect - check.effectMin] += 1;
        }

        if (barGraphScore) {
            System.out.printf("\tScores:\n\n");
            for (int i = 0; i < rangeScore; i++) {
                if (i == 0 || !cumulativeScores) {
                    scorePercentages[i] = (float) scoreTally[i] / 10000;
                } else {
                    scorePercentages[i] = scorePercentages[i - 1] + (float) scoreTally[i] / 10000;
                }

                System.out.printf("\t%d . %.3f%%\n\t", (i + minScore), scorePercentages[i]);
                for (int j = 0; j < scorePercentages[i]; j++) {
                    System.out.print("-");
                }
                System.out.println("|\n");
            }
        }

        if (barGraphEffect && !cumulative) {
            //cumulative not working
            System.out.println("\tEffect\n\n");
            for (int i = 0; i < rangeEffect; i++) {

                effectPercentages[i] = (float) effectTally[i] / 10000;

                System.out.printf("\t%d . %.3f%%\n\t", (i + minEffect), effectPercentages[i]);
                for (int j = 0; j < effectPercentages[i]; j++) {
                    System.out.print("-");
                }
                System.out.println("|\n");
            }
        }

        if (barGraphEffect && cumulative) {

            System.out.println("\tEffect (cumulative)\n\n");
            for (int i = 0; i < rangeEffect; i++) {
                if (i == 0) {
                    effectPercentages[rangeEffect - i - 1] = (float) effectTally[rangeEffect - i - 1] / 10000;
                } else {
                    effectPercentages[rangeEffect - 1 - i] = effectPercentages[rangeEffect - i] + (float) effectTally[rangeEffect - 1 - i] / 10000;
                }
                System.out.printf("\t%d . %.3f%%\n\t", (maxEffect - i), effectPercentages[rangeEffect - i - 1]);
                for (int j = 0; j < effectPercentages[rangeEffect - 1 - i]; j++) {
                    System.out.print("-");
                }
                System.out.println("|\n");

            }
        }

        //TABLE TOP ROW
        if (sampleMatrix) {
            //System.out.printf("Tabulated results for d%d and d%d\n\n", sampleCheck.attributeSize, sampleCheck.gambitSize);
            System.out.print("\n\tS\\E  ");
            for (int i = 0; i < rangeEffect; i++) {
                System.out.printf("%-5d", (i + minEffect));
            }

            //ROWS
            System.out.println();
            System.out.println();
            for (int i = 0; i < rangeScore; i++) {
                System.out.printf("\t%-5d", i + minScore);
                for (int j = 0; j < rangeEffect; j++) {
                    System.out.printf("%-5.0f", (float) (effectPerScoreTally[i][j]) / 100);
                }
                System.out.println();

            }
        }
    }

}
