import processing.core.PApplet;

//
// Stage 3: Implement ZShape as just a cube
//
public class ZShape
{
    private Grid grid;
    private int originCol;
    private int originRow;
    private int cellSize;
    private int fillColor;
    
    // 
    // Stage 6: Create other block coordinates
    //
    private int col0;
    private int col1;
    private int col2;
    private int row0;
    private int row1;
    private int row2;
    
    //
    // Stage 10: rotate()
    //
    private int direction; // 0: WEST, 1: NORTH, 2: EAST, 3: SOUTH
    
    public ZShape(Grid gameGrid,
                  int initCol,
                  int initRow,
                  int initFillColor)
    {
        grid = gameGrid;
        originCol = initCol;
        originRow = initRow;
        cellSize = grid.getCellSize();
        fillColor = initFillColor;
        
        //
        // Stage 6: Create other block coordinates
        col0 = originCol - 1;
        row0 = originRow - 1;
        col1 = originCol;
        row1 = originRow - 1;
        col2 = originCol + 1;
        row2 = originRow;
    }
    
    public void draw(PApplet app)
    {
        app.stroke(0);
        app.fill(fillColor);
        
        //
        // Stage 4: Implement position calculation
        //
        int x = originCol * cellSize;
        int y = originRow * cellSize;
        app.rect(x, y, cellSize, cellSize);
        
        //
        // Stage 6: create other block coordinates
        //
        app.rect(col0 * cellSize, row0 * cellSize, cellSize, cellSize);
        app.rect(col1 * cellSize, row1 * cellSize, cellSize, cellSize);
        app.rect(col2 * cellSize, row2 * cellSize, cellSize, cellSize);
    }
    
    //
    // Stage 7: moveDown()
    //
    public boolean moveDown()
    {
        // Check bounds
        if (
            grid.isInBounds(col0, row0 + 1) &&
            grid.isInBounds(originCol, originRow + 1) &&
            grid.isInBounds(col1, row1 + 1) &&
            grid.isInBounds(col2, row2 + 1))
        {
            row0++;
            originRow++;
            row1++;
            row2++;
            
            return true;
        }
        
        return false;
    }
    
    //
    // Stage 8: moveLeft()
    //
    public boolean moveLeft()
    {
        // Check bounds
        if (grid.isInBounds(col0 - 1, row0) &&
            grid.isInBounds(originCol - 1, originRow) &&
            grid.isInBounds(col1 - 1, row1) &&
            grid.isInBounds(col2 - 1, row2))
        {
            col0--;
            originCol--;
            col1--;
            col2--;
            
            return true;
        }
        
        return false;
    }
    
    //
    // Stage 9: moveRight()
    //
    public boolean moveRight()
    {
        // Check bounds
        if (grid.isInBounds(col0 + 1, row0) &&
            grid.isInBounds(originCol + 1, originRow) &&
            grid.isInBounds(col1 + 1, row1) &&
            grid.isInBounds(col2 + 1, row2))
        {
            col0++;
            originCol++;
            col1++;
            col2++;
            
            return true;
        }
        
        return false;
    }
    
    //
    // Stage 10: rotate()
    //
    public boolean rotate()
    {
        // West to North
        if (direction == 0)
        {
            col0 = col0 + 2;
            col1++;
            row1++;
            col2--;
            row2++;
            
            direction = 1;
        }
        else if (direction == 1)
        {
            row0 = row0 + 2;
            col1--;
            row1++;
            col2--;
            row2--;
            
            direction = 2;
        }
        else if (direction == 2)
        {
            col0 = col0 - 2;
            row1--;
            col1--;
            col2++;
            row2--;
            
            direction = 3;
        }
        else if (direction == 3)
        {
            row0 = row0 - 2;
            col1++;
            row1--;
            col2++;
            row2++;
            
            direction = 0;
        }
        
        return false;
    }
}