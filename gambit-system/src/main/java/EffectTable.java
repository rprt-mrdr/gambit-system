
public class EffectTable {
    
    Effect[] effectTable;
    
    EffectTable(){
        effectTable = new Effect[13];
        for (int i = 0; i < effectTable.length; i++){
            effectTable[i] = new Effect();
        }
    }
    
    public void printEffectTable(){
        for (int i = 0; i < effectTable.length; i++){
            System.out.printf("\nEffect %d:\n", i);
            effectTable[i].printEffect();
        }
    }
    
    public void applyDamageValues(int[] damageTable){
        for (int i = 0; i < effectTable.length; i++){
            effectTable[i].damage = damageTable[i];
        }
    }
    
    public void applyResistanceValues(int[] resistanceTable){
        for (int i = 0; i < effectTable.length; i++){
            effectTable[i].resistance = resistanceTable[i];
        }
    }
    
    public void applyMiscValues(int[] miscTable){
        for (int i = 0; i < effectTable.length; i++){
            effectTable[i].miscA = miscTable[i];
            effectTable[i].details += effectTable[i].miscA + " misc\n";
        }
    }
    
    public Effect getEffect(int effectValue){
        return effectTable[effectValue];
    }
    
}
