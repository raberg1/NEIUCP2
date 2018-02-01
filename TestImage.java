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
         	
		} 
		catch (Exception e)
		{
         	e.printStackTrace();
      	}
	}
}