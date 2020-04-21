import java.util.Scanner;

/**
 * The class utilizes the Canvas class and runs a drawing application
 * 
 * @author      Bratin Ghosh
 */
public class CanvasApplication {
    /**
     * main() method for running the application
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Canvas c = new Canvas();
        while (true) {
            System.out.print("enter command: ");
            String[] command=sc.nextLine().split("\\s+");
            if (command[0].toUpperCase().charAt(0) == 'C')
                c.newCanvas(Integer.parseInt(command[1]),Integer.parseInt(command[2]));
            else if (command[0].toUpperCase().charAt(0) == 'L' && c.inCanvas(Integer.parseInt(command[1]), Integer.parseInt(command[2])) && c.inCanvas(Integer.parseInt(command[3]), Integer.parseInt(command[4])))
                c.drawLine(Integer.parseInt(command[1]),Integer.parseInt(command[2]),Integer.parseInt(command[3]),Integer.parseInt(command[4]));
            else if (command[0].toUpperCase().charAt(0) == 'R' && c.inCanvas(Integer.parseInt(command[1]), Integer.parseInt(command[2])) && c.inCanvas(Integer.parseInt(command[3]), Integer.parseInt(command[4])))
                c.drawRectangle(Integer.parseInt(command[1]),Integer.parseInt(command[2]),Integer.parseInt(command[3]),Integer.parseInt(command[4]));
            else if (command[0].toUpperCase().charAt(0) == 'B' && c.inCanvas(Integer.parseInt(command[1]), Integer.parseInt(command[2])))
                c.fillColor(Integer.parseInt(command[1]),Integer.parseInt(command[2]),(command[3]).charAt(0));
            else if (command[0].toUpperCase().charAt(0) == 'Q')
                break;
            c.printCanvas();
        }
    }
}