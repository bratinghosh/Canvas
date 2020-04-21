import org.junit.*;

/**
 * Unit tests for the Canvas class
 * 
 * @author      Bratin Ghosh
 */
public class CanvasTest {
    Canvas c = new Canvas();
    
    /**
     * Tests the creation of a new canvas
     */
    @Test
    public void testNewCanvas(){
        c.newCanvas(2,3);
        char canvas[][] = {
            {'-','-','-','-'},
            {'|',' ',' ','|'},
            {'|',' ',' ','|'},
            {'|',' ',' ','|'},
            {'-','-','-','-'}
        };
        Assert.assertEquals(canvas,c.canvas);
    }
    
    /**
     * Tests if the point lies inside the canvas
     */
    @Test
    public void testinCanvasTrue(){
        c.newCanvas(2,3);
        Assert.assertEquals(true,c.inCanvas(1,2));
    }
    
    /**
     * Tests if the point lies outside the canvas
     */
    @Test
    public void testinCanvasFalse(){
        c.newCanvas(2,3);
        Assert.assertEquals(false,c.inCanvas(-4,3));
    }
    
    /**
     * Tests if a line is drawn on the canvas
     */
    @Test
    public void testDrawLine(){
        c.newCanvas(2,3);
        c.drawLine(1,2,2,2);
        char canvas[][] = {
            {'-','-','-','-'},
            {'|',' ',' ','|'},
            {'|','x','x','|'},
            {'|',' ',' ','|'},
            {'-','-','-','-'}
        };
        Assert.assertEquals(canvas,c.canvas);
    }
    
    /**
     * Tests if a rectangle is drawn on the canvas
     */
    @Test
    public void testDrawRectangle(){
        c.newCanvas(2,3);
        c.drawRectangle(1,1,2,3);
        char canvas[][] = {
            {'-','-','-','-'},
            {'|','x','x','|'},
            {'|','x','x','|'},
            {'|','x','x','|'},
            {'-','-','-','-'}
        };
        Assert.assertEquals(canvas,c.canvas);
    }
    
    /**
     * Tests if the entire area gets coloured
     */
    @Test
    public void testFillColor1(){
        c.newCanvas(2,3);
        c.fillColor(1,1,'r');
        char canvas[][] = {
            {'-','-','-','-'},
            {'|','r','r','|'},
            {'|','r','r','|'},
            {'|','r','r','|'},
            {'-','-','-','-'}
        };
        Assert.assertEquals(canvas,c.canvas);
    }
    
    /**
     * Tests if the specific areas get coloured
     */
    @Test
    public void testFillColor2(){
        c.newCanvas(2,3);
        c.drawLine(1,2,2,2);
        c.fillColor(1,1,'r');
        c.fillColor(2,3,'g');
        c.printCanvas();
        char canvas[][] = {
            {'-','-','-','-'},
            {'|','r','r','|'},
            {'|','x','x','|'},
            {'|','g','g','|'},
            {'-','-','-','-'}
        };
        Assert.assertEquals(canvas,c.canvas);
    }
}