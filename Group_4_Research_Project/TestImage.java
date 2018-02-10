/**
 * CS207 - Research Lab 1
 * Image Processing - TestImage Class
 * This is the Test Class that will test the Image
 * Class using the animals.jpg file.
 * 
 * @author Robert Berg and Leon Kim
 * @version 2/7/2018
 */

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
            
            img.flipX();
            img.write("animalsFlipX.jpg");
            
            Image image = new Image("animals.jps");
            image.flipY();
            image.write("animalsFlipY.jpg");
            
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}