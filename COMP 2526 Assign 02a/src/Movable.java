import java.util.ArrayList;

/**
 * Movable.
 *
 * @author Kevin Vizconde
 * @version 1.0
 */
public interface Movable {
    
    public void move(Cell c, ArrayList<Cell> ns);
    public boolean isTooHungry();
    public void resetMoved();

}
