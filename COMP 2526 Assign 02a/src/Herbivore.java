import java.util.ArrayList;

/**
 * Herbivore.
 *
 * @author Kevin Vizconde
 * @version 1.0
 */
public class Herbivore implements LifeForm, Movable {
    
    /** The hungry. */
    private int hungry;
    
    /** The moved. */
    private boolean moved;
    
    /** The hunger limit. */
    private final int HLIMIT = 5;
    
    
    /**
     * Sets the color code to Yellow
     * 
     * @see LifeForm#getColorCode()
     * @return
     */
    public String getColorCode() {
        return "#FFFF00";
    }
    

    /**
     * Constructs an object of type Herbivore.
     */
    public Herbivore() {
        moved = false;
        hungry = 0;
    }
    

    public void resetMoved() {
        moved = false;
    }


    /**
     * Moves the Herbivore if
     * all conditions in this method are met.
     *
     * @param c the Cell object
     * @param ns the ArrayList of Cell(Neighbours)
     * @see Movable#move(Cell, java.util.ArrayList)
     */
    @Override
    public void move(Cell c, ArrayList<Cell> ns) {
        
        if(moved) return;
        moved = true;
        int index = RandomGenerator.nextNumber(ns.size());
        Cell target = ns.get(index);
        if(target.getLife() == null) {
            hungry++;
            target.setLife(this);
            c.setLife(null);
            
        }
        else if(target.getLife() instanceof Plant)
        {
            hungry = 0;
            target.setLife(this);
            c.setLife(null);
        }
        else
        {
            hungry++;
        }
        
    }

    
    /**
     * Returns the maximum number of
     * movements a Herbivore can make before it gets too hungry.
     *
     * @return true, if is too hungry
     * @see Movable#isTooHungry()
     */
    public boolean isTooHungry() {
        return hungry >= HLIMIT;
    }

}
