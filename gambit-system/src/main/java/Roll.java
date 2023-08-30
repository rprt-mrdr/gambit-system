/**
 *
 * @author rprt-mrdr
 */
import java.util.Random;

public class Roll {

    int size;
    int result;
    Random rng;

    Roll() {
        size = 8;
        result = rng.nextInt(size) + 1;
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
