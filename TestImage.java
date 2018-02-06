import java.awt.*;
import javax.imageio.*; 

class TestImage 
{
    public static void main(String args[]) throws Exception 
    {
        Frame frame = new Frame("My Images");
        frame.setSize(1024,768);
        frame.setVisible(true);
        Graphics gc = frame.getGraphics();

        try 
        {
            Image img = new Image("animals.jpg");
            img.draw(gc, 10, 40);
            
            img.flipY();
            img.draw(gc, img.getWidth() + 20, 40);
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}