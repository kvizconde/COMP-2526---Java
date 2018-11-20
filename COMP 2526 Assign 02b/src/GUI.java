import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * GUI.
 * Handles all the graphics in the game
 * and displays the world.
 *
 * @author Kevin Vizconde
 * @version 1.0
 */
public class GUI extends Application {
    
    private  World world;
    private Circle[][] circles;
    
    
    /**
     * Constructs an object of type GUI.
     */
    public GUI() {
        world = new World (50, 50);
        circles = new Circle[50][50];
    }


    public void start(Stage stage) {
        
        GridPane root = new GridPane();
        
        for(int i = 0; i < world.getWidth(); i++) {
            for(int j = 0; j < world.getHeight(); j++) {
                
                circles[i][j] = new Circle(i, j, 5);
                LifeForm l;
                
                if((l = world.getCellAt(i,j).getLife() )!=null) {
                    circles[i][j].setFill(Paint.valueOf(l.getColorCode()));
                } else {
                    circles[i][j].setFill(Paint.valueOf("#FFFFFF"));
                }
               
                root.setGridLinesVisible(true);
                root.add(circles[i][j] , j, i);
             
            }
            
        }
        
        
        Scene scene = new Scene(root, 500, 500, Color.WHITE);
        
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                world.takeTurn();
                start(stage);
            }
            
        });
        stage.setScene(scene);
        stage.setTitle("Game Of Life");
        stage.show();
        
    }
    
}
