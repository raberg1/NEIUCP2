/**
 * CS207 - Research Lab 1
 * Image Processing - Image Class
 * This is the Image Class that will read in an
 * image and you will be able to flipY and flipX
 * and write the image to a new file.
 * 
 * @author Robert Berg and Leon Kim
 * @version 2/7/2018
 */
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
        this.pixels = new int[this.height][this.width];
        
        for(int row = 0; row < this.height; row++){
            for(int col = 0; col < this.width; col++){
                this.pixels[row][col] = bufImage.getRGB(col, row);
            }
        }

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
    
    public void flipY(){
        int[][] temp = new int[this.height][this.width];
        
        for(int row = 0; row < this.height; row++){
            for(int col = 0; col < this.width; col++){
                temp[row][col] = this.pixels[row][this.width - col - 1];
            }
        }
        
        pixels = temp;
    }
    
    public void flipX(){
        int[][] temp = new int[this.height][this.width];
        
        for(int row = 0; row < this.height; row++){
            for(int col = 0; col < this.width; col++){
                temp[row][col] = this.pixels[this.height - row - 1][col];
            }
        }
        
        pixels = temp;
    }

} 