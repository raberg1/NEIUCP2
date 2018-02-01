import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.stream.*;

public class Image 
{
	private int width, height; 
	private int[][] pixels;
   
	public Image(String filename) throws Exception 
	{ 
		this.read(filename); 
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
   
	public void read(String filename) throws Exception 
	{
		File fileImage = new File(filename);
        
        BufferedImage bufImage = ImageIO.read(fileImage);
		this.width = bufImage.getWidth();
		this.height = bufImage.getHeight();
		
		// Complete the remainder of this method 
         
   }
   
   private BufferedImage createBufferedImage() 
   	{ 
      	BufferedImage bufImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
  
      	for (int row = 0; row < this.height; row++)
      	{
         	for (int col = 0; col < this.width; col++)
         	{
         		bufImage.setRGB(col, row, this.pixels[row][col]);
         	}
        }
         
      	return bufImage;
	}
   
   public void write(String filename) throws Exception 
   {
        File fileImage = new File(filename);
        String ext = filename.substring(filename.indexOf('.') + 1);
        BufferedImage bufImage = createBufferedImage();
        ImageIO.write(bufImage, ext, fileImage);
   }
   
   
	public void draw(Graphics gc, int x, int y)
	{
   		BufferedImage bufImage = createBufferedImage();
      	gc.drawImage(bufImage, x, y, null);
   	}

} 