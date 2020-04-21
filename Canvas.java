/**
 * The class simulates a canvas and is a console version of a drawing program
 * 
 * @author      Bratin Ghosh
 */
public class Canvas {
    static char canvas[][];
    static int width = 0;
    static int height = 0;
    
    /**
     * Prints the canvas
     */
    public static void printCanvas() {
        for (int i = 0; i < height ; i++) {
            for (int j = 0; j < width ; j++)
                System.out.print(canvas[i][j]);
            System.out.println();
        }
    }
    
    /**
     * Checks if a point is present inside the canvas
     * 
     * @param   x   x co-ordinate of the point
     * @param   y   y co-ordinate of the point
     * 
     * @return  true if the point is inside the canvas; otherwise false
     */
    public static boolean inCanvas(int x, int y) {
        if (x >= 1 && x <= width - 2 && y >= 1 && y <= height - 2)
            return true;
        return false;
    }
    
    /**
     * Creates a new canvas
     * 
     * @param   w   width of the canvas
     * @param   h   height of the canvas
     */
    public static void newCanvas(int w, int h) {
        width = w + 2;
        height = h + 2;
        canvas = new char[height][width];
        for (int i = 0; i < height ; i++) {
            for (int j = 0; j < width ; j++) {
                if ( i == 0 || i == height - 1 )
                    canvas[i][j] = '-';
                else if ( j == 0 || j == width - 1 )
                    canvas[i][j] = '|';
                else
                    canvas[i][j] = ' ';
            }
        }
    }
    
    /**
     * Draws a line on the canvas
     * 
     * @param   x1   x co-ordinate of the endpoint of the line
     * @param   y1   y co-ordinate of the endpoint of the line
     * @param   x2   x co-ordinate of the other endpoint of the line
     * @param   y2   y co-ordinate of the other endpoint of the line
     */
    public static void drawLine(int x1, int y1, int x2, int y2) {
        if ( x1 == x2 ) {
            for ( int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++ )
                canvas[i][x1] = 'x';
        }
        else if ( y1 == y2 ) {
            for ( int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++ )
                canvas[y1][i] = 'x';
        }
    }
    
    /**
     * Draws a rectangle on the canvas
     * 
     * @param   x1   x co-ordinate of the upper left corner of the rectangle
     * @param   y1   y co-ordinate of the upper left corner of the rectangle
     * @param   x2   x co-ordinate of the lower right corner of the rectangle
     * @param   y2   y co-ordinate of the lower right corner of the rectangle
     */
    public static void drawRectangle(int x1, int y1, int x2, int y2) {
        drawLine(x1, y1, x1, y2);
        drawLine(x2, y1, x2, y2);
        drawLine(x1, y1, x2, y1);
        drawLine(x1, y2, x2, y2);
    } 
    
    /**
     * Fills the entire area of the canvas connected to a point with colour
     * 
     * @param   x       x co-ordinate of the point
     * @param   y       y co-ordinate of the point
     * @param   color   color with which the entire area needs to be filled
     */
    public static void fillColor(int x, int y, char color) {
        if (canvas[y][x] != 'x' && canvas[y][x] != '-' && canvas[y][x] != '|' && canvas[y][x] != color) {
            canvas[y][x] = color;
            if ( x - 1 >= 1 )
                fillColor(x - 1,y,color);
            if ( x + 1 <= width - 1 )
                fillColor(x + 1,y,color);
            if ( y - 1 >= 1 )
                fillColor(x,y - 1,color);
            if ( y + 1 <= height - 1 )
                fillColor(x,y + 1,color);
        }
    }
}