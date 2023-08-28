/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author geoff
 */
import java.util.Random;

public class Roll {

    int size;
    int result;
    Random rng;

    Roll() {
        size = 6;
        result = rng.nextInt(6) + 1;
    }

    Roll(int size) {
        this.size = size;
        rng = new Random();
        result = rng.nextInt(size) + 1;
        
    }
    
    public void print(){
        System.out.printf("%d / %d\n", result, size);
    }

}
