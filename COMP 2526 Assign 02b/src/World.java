
/**
 * World.
 * This class contains the functions and rules for the game
 *
 * @author Kevin Vizconde
 * @version 2.0
 */
public class World {
    
    /** The Constant MAX_RANDOM. */
    private static final int MAX_RANDOM = 99;
    
    /** The Constant HERB_VALUE. */
    private static final int HERB_VALUE = 80;
    
    /** The Constant PLANT_VALUE. */
    private static final int PLANT_VALUE = 60;
    
    /** The Constant CARN_VALUE. */
    private static final int CARN_VALUE = 50;
    
    /** The Constant OMNI_VALUE. */
    private static final int OMNI_VALUE = 45;
    
    /** The width. */
    private final int width;
    
    /** The height. */
    private final int height;
    
    /** The cells. */
    private Cell[][] cells;
    
    
    /**
     * Instantiates a new world.
     *
     * @param width the width
     * @param height the height
     */
    public World(int width, int height) {
        this.width = width;
        this.height = height;
        
        cells = new Cell[width][height];
        initCells();
        
    }
    
    
    /**
     * Initializes life in the world.
     */
    private void initCells() {
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                
                cells[i][j] = new Cell(this,i,j);
                
                int val = RandomGenerator.nextNumber(MAX_RANDOM);
                
                if(val >= HERB_VALUE)
                {
                    cells[i][j].setLife(new Herbivore());
                }
                else if(val >= PLANT_VALUE)
                {
                    cells[i][j].setLife(new Plant());
                }
                else if(val >= CARN_VALUE)
                {
                    cells[i][j].setLife(new Carnivore());
                }
                else if(val >= OMNI_VALUE)
                {
                    cells[i][j].setLife(new Omnivore());
                }
                
            }
        }
        
    }
    
    
    /**
     * This method checks and implements
     * the following conditions each turn.
     */
    public void takeTurn() {
        
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                LifeForm l = cells[i][j].getLife();
                if(l != null && l instanceof Movable) {
                    ((Movable)l).resetMoved();
                }
            }
        }     
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                cells[i][j].takeTurn();
            }
        }
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                LifeForm l = cells[i][j].getLife();
                if(l != null && l instanceof Movable) {
                    if(((Movable)l).isTooHungry()) {
                        cells[i][j].setLife(null);
                }
            }
        }
        }
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                LifeForm l = cells[i][j].getLife();
                if(l != null && l instanceof Movable && !((Movable)l).isNewBorn()) {
                    ((Movable)l).giveBirth(cells[i][j], cells[i][j].getNeighbours());
                }
            }
        }

    }

    
    /**
     * Gets the width.
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }


    /**
     * Gets the height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    
    /**
     * Sets the cells.
     *
     * @param cells the new cells
     */
    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    
    /**
     * Gets the cells.
     *
     * @return the cells
     */
    public Cell[][] getCells() {
        return cells;
    }
    
    
    /**
     * Gets the cell at.
     *
     * @param i the i
     * @param j the j
     * @return the cell at
     */
    public Cell getCellAt(int i, int j) {
        if(i >= 0 && i < width && j >= 0 && j < height) {
            return cells[i][j];
        }
        return null;
    }

}
