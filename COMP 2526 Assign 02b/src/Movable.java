import java.util.ArrayList;

/**
 * Movable.
 *
 * @author Kevin Vizconde
 * @version 2.0
 */
public abstract class Movable {
    
    /** The hungry. */
    protected int hungry;
    
    /** The moved. */
    protected boolean moved;

    /** The new born. */
    protected boolean newBorn = true;
    
    /** The hunger limit. */
    private final int HLIMIT = 5;
    
    
    /**
     * Checks if is new born.
     *
     * @return true, if is new born
     */
    public boolean isNewBorn() {
        return newBorn;
    }

    
    /**
     * Moves the Animals if
     * all conditions in this method are met.
     *
     * @param c the Cell object
     * @param ns the ArrayList of Cell(Neighbours)
     * @see Movable#move(Cell, java.util.ArrayList)
     */
    public void move(Cell c, ArrayList<Cell> ns) {
        
        newBorn = false;
        if (moved) return;
        moved = true;
        
        int index = RandomGenerator.nextNumber(ns.size());
        Cell target = ns.get(index);
        if (target.getLife() == null)
        {
            hungry++;
            moveMe(target);
            c.setLife(null);
        }
        else if (isEdible(target.getLife()))
        {
            hungry = 0;
            moveMe(target);
            c.setLife(null);
        }
        else
        {
            hungry++;
        }
        
    }
    
    
    /**
     * Checks if is too hungry.
     *
     * @return true, if is too hungry
     */
    public boolean isTooHungry() {
        return hungry >= HLIMIT;
    }
    
    
    /**
     * Reset moved.
     */
    public abstract void resetMoved();
    
    
    /**
     * Move me.
     *
     * @param target the target
     */
    public abstract void moveMe(Cell target);

    
    /**
     * Checks if is edible.
     *
     * @param life the life
     * @return true, if is edible
     */
    public abstract boolean isEdible(LifeForm life);

    
    /**
     * Give birth.
     *
     * @param c the Cell
     * @param ns the neighbouring cells
     */
    public abstract void giveBirth(Cell c, ArrayList<Cell> ns);
   
}
