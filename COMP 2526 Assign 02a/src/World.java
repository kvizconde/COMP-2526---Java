/**
 * World.
 * This class contains the functions and rules for the game
 *
 * @author Kevin Vizconde
 * @version 1.0
 */
public class World {
    
    /** The Constant MAX_RANDOM. */
    private static final int MAX_RANDOM = 100;
    
    /** The Constant HERB_VALUE. */
    private static final int HERB_VALUE = 85;
    
    /** The Constant PLANT_VALUE. */
    private static final int PLANT_VALUE = 65;
    
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
                
                int n = RandomGenerator.nextNumber(MAX_RANDOM);
                
                // Populates the world with the following conditions
                if(n >= HERB_VALUE ) {
                    cells[i][j].setLife(new Herbivore());
                }
                else if(n >= PLANT_VALUE) {
                    cells[i][j].setLife(new Plant());
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
     * Gets the cells.
     *
     * @return the cells
     */
    public Cell[][] getCells() {
        return cells;
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
