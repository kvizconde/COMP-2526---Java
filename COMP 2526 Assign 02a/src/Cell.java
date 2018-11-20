import java.util.ArrayList;

/**
 * Cell.
 *
 * @author Kevin Vizconde
 * @version 1.0
 */
public class Cell {
    
    /** The world. */
    private final World world;
    
    /** The width. */
    private final int width;
    
    /** The height. */
    private final int height;
    
    /** The life. */
    private LifeForm life;

    
    /**
     * Constructs an object of type Cell.
     *
     * @param world the world
     * @param width the width
     * @param height the height
     */
    public Cell(World world, int width, int height) {
        
        this.world = world;
        this.width = width;
        this.height = height;
        life = null;
        
    }
    
    
    /**
     * Gets the life.
     *
     * @return the life
     */
    public LifeForm getLife() {
        return life;
    }


    /**
     * Sets the life.
     *
     * @param life the new life
     */
    public void setLife(LifeForm life) {
        this.life = life;
    }
    
    
    /**
     * Take turn.
     */
    public void takeTurn() {
        if(life != null) {
            if(life instanceof Movable) {
                Movable m = (Movable)life;
                m.move(this, getNeighbours());
            }
            if(life instanceof Seeds) {
                Seeds s = (Seeds)life;
                s.seed(this, getNeighbours());
            }
        }
    }
    
    
    /**
     * Gets the neighbours.
     *
     * @return the neighbours
     */
    private ArrayList<Cell> getNeighbours() {
        ArrayList<Cell> neighbours = new ArrayList<Cell>();
        for(int i = -1; i < 2; i++)
            for(int j = -1; j < 2; j++)
                if(i != 0 || j != 0) {
                    Cell c = world.getCellAt(width + i , height + j);
                    if(c != null)
                        neighbours.add(c);
                }
                return neighbours; 
    }

}
