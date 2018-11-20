import java.util.ArrayList;

/**
 * Plant.
 *
 * @author Kevin Vizconde
 * @version 1.0
 */
public class Plant implements LifeForm, Seeds {
    
    /** The number of plants needed to seed. */
    private final int PGROUP = 4;
    
    /** The number of empty cells needed. */
    private final int EMPTY_GRP = 3;
    
    /** The plant count. */
    private int plantCount;
    
    /** The empty count. */
    private int emptyCount;
    
    
    
    /**
     * Sets the colour code ot Green
     * 
     * @see LifeForm#getColorCode()
     * @return
     */
    public String getColorCode() {
        return "#0B9200";
    }
    
    
    /**
     * Constructs an object of type Plant.
     */
    public Plant() {
        plantCount = 0;
        emptyCount = 0;
    }
    

    /**
     * Plant will seed and pollinate if
     * all conditions in this method are met.
     *
     * @param c the Cell object
     * @param ns the ArrayList of Cell(Neighbours)
     * @see Seeds#seed(Cell, java.util.ArrayList)
     */
    @Override
    public void seed(Cell c, ArrayList<Cell> ns) {
        
        plantCount = 0;
        emptyCount = 0;
        
        
        ArrayList<Cell> emptyCells = new ArrayList<Cell>();
        
        
        for (int i = 0; i < ns.size(); i++) {
            if ( (ns.get(i).getLife() != null) && (ns.get(i).getLife() instanceof Plant) ) {
                plantCount++;
            } else {
                if (ns.get(i).getLife() == null) {
                    emptyCells.add(ns.get(i));
                    emptyCount++;
            }
        }
            
        }
        if (plantCount == PGROUP && emptyCount >= EMPTY_GRP) {
            int index = RandomGenerator.nextNumber(emptyCells.size());
            Cell target = emptyCells.get(index);
            Plant p = new Plant();
            target.setLife(p);
        }
    }

}
