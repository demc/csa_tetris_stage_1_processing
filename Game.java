import processing.event.KeyEvent;
import processing.core.PApplet;

public class Game extends PApplet
{
    private int width;
    private int height;
    private int backgroundColor;
    private Grid grid;
    
    public void settings()
    {
        //
        // Stage 0: setup the width and height, background color
        //
        width = 300;
        height = 600;
        backgroundColor = color(240, 248, 255); // aliceblue // gray: color(122);
        
        size(width, height);
    }
    
    public void setup()
    {
        // 
        // Stage 2: create grid instance
        //
        grid = new Grid(width, height);
    }
    
    public void draw()
    {
        background(backgroundColor);
        
        //
        // Stage 2: delegate drawing to the grid object
        //
        grid.draw(this);
    }
    
    //
    // Stage 5: Respond to z press event
    //
    public void keyReleased(KeyEvent event)
    {        
        int keyCode = event.getKeyCode();
        
        if (keyCode == 90)
        {

            ZShape z = new ZShape(grid, 5, 5, color(255,192,203));
            grid.setShape(z);
        }  
    }
    
    //
    // Stage 7: moveDown()
    //
    public void keyPressed(KeyEvent event)
    {
        int keyCode = event.getKeyCode();
        
        if (keyCode == DOWN)
        {
            grid.moveDown();
        }
        //
        // Stage 8: moveLeft()
        //
        else if (keyCode == LEFT)
        {
            grid.moveLeft();
        }
        //
        // Stage 9: moveRight()
        //
        else if (keyCode == RIGHT)
        {
            grid.moveRight();
        }
        //
        // Stage 10: rotate()
        //
        else if (keyCode == UP)
        {
            grid.rotate();
        }
    }
}
