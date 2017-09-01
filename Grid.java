import processing.core.PApplet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Grid
{
    private int columnCount;
    private int rowCount;
    private int cellSize;
    private Object shape;
    private Method drawMethod;
    private Method moveDownMethod;
    private Method moveLeftMethod;
    private Method moveRightMethod;
    private Method rotateMethod;
    
    public Grid(int width, int height)
    {
        columnCount = 10;
        rowCount = 20;
        cellSize = width / columnCount;
    }
    
    public int getColumnCount()
    {
        return columnCount;
    }
    
    public int getRowCount()
    {
        return rowCount;
    }
    
    public int getCellSize()
    {
        return cellSize;
    }
    
    public void setShape(Object newShape)
    {
        shape = newShape;
        
        try
        {
            drawMethod = newShape.getClass().getMethod("draw", PApplet.class);
        }
        catch (NoSuchMethodException ex)
        {
            throw new RuntimeException("Shape does not implement draw() method.");
        }
        
        try
        {
            moveDownMethod = newShape.getClass().getMethod("moveDown");
        }
        catch (NoSuchMethodException ex)
        {
            throw new RuntimeException("Shape does not implement moveDown() method.");
        }
        
        try
        {
            moveLeftMethod = newShape.getClass().getMethod("moveLeft");
        }
        catch (NoSuchMethodException ex)
        {
            throw new RuntimeException("Shape does not implement moveLeft() method.");
        }
  
        try
        {
            moveRightMethod = newShape.getClass().getMethod("moveRight");
        }
        catch (NoSuchMethodException ex)
        {
            throw new RuntimeException("Shape does not implement moveRight() method.");
        }
        
        try
        {
            rotateMethod = newShape.getClass().getMethod("rotate");
        }
        catch (NoSuchMethodException ex)
        {
            throw new RuntimeException("Shape does not implement rotate() method.");
        }
    }
    
    public boolean moveDown()
    {
        if (moveDownMethod != null)
        {
            try
            {
                moveDownMethod.invoke(shape);
            }
            catch (IllegalAccessException ex)
            {
                ex.printStackTrace();
            }
            catch (InvocationTargetException ex)
            {
                ex.printStackTrace();
            }
        }
        
        return false;
    }
    
    public boolean moveLeft()
    {
        if (moveLeftMethod != null)
        {
            try
            {
                moveLeftMethod.invoke(shape);
            }
            catch (IllegalAccessException ex)
            {
                ex.printStackTrace();
            }
            catch (InvocationTargetException ex)
            {
                ex.printStackTrace();
            }
        }
        
        return false;
    }
    
    public boolean moveRight()
    {
        if (moveLeftMethod != null)
        {
            try
            {
                moveRightMethod.invoke(shape);
            }
            catch (IllegalAccessException ex)
            {
                ex.printStackTrace();
            }
            catch (InvocationTargetException ex)
            {
                ex.printStackTrace();
            }
        }
        
        return false;
    }
    
    public boolean rotate()
    {
        if (rotateMethod != null)
        {
            try
            {
                rotateMethod.invoke(shape);
            }
            catch (IllegalAccessException ex)
            {
                ex.printStackTrace();
            }
            catch (InvocationTargetException ex)
            {
                ex.printStackTrace();
            }
        }
        
        return false;
    }

    public void draw(PApplet app)
    {
        if (drawMethod != null) 
        {
            try
            {
                drawMethod.invoke(shape, app);
            }
            catch (IllegalAccessException ex)
            {
                ex.printStackTrace();
            }
            catch (InvocationTargetException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    //
    // Stage 1: boolean logic for bounds checking
    //
    public boolean isInBounds(int col, int row) 
    {
        boolean isColumnInBounds = col >= 0 && col < columnCount;
        boolean isRowInBounds = row >= 0 && row < rowCount;
        
        return isColumnInBounds && isRowInBounds;
    }
}