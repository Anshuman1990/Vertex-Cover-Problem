package Logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;



public class TextImage 
{
	

	public void drawImage(String nodeName, int i) 
	{
			try {
	        	
				File f= new File("F://project/vertex/v.png");
	            Image image = ImageIO.read(f);
	            BufferedImage cpimg = bufferImage(image);

	            Graphics g = cpimg.createGraphics();
	            Font fnt = new Font("Arial", 5, 9);// setting Font size and style
	            Color fntC =  Color.red ;// setting font color 0,0,0   new Color(5, 12, 21)
	            g.setColor(fntC);
	            g.setFont(fnt);
	            g.drawString(i+"", 5, 15);//Printed Cluster Head
	            //g.drawString(nodeName, 2, 30);// Printed the node
	            File f1 = new File("F://project/vertex/"+nodeName+".png");
	            ImageIO.write(cpimg, "png", f1);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
			
    }
    
    public void changeImage(String nodeName, int i) 
	{
    	try {
        	
        	File f= new File("D://NWInfo/vertex.png");
            Image image = ImageIO.read(f);
            BufferedImage cpimg = bufferImage(image);
            Graphics g = cpimg.createGraphics();
            Font fnt = new Font("Arial", 1, 9);// setting Font size and style
            Color fntC = new Color(5, 12, 21);// setting font color 0,0,0
            g.setColor(fntC);
            g.setFont(fnt);
            g.drawString(nodeName, 2, 25);// Text will be printed
            File f1 = new File("F://project/vertex/" + nodeName + ".png");
            ImageIO.write(cpimg, "png", f1);
        } catch (Exception e) {
            System.out.println(e);
        }
	}
    
    public static BufferedImage bufferImage(Image image) {
        return bufferImage(image, BufferedImage.TYPE_INT_RGB);
    }
    public static BufferedImage bufferImage(Image image, int type) {
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(image, null, null);
        return bufferedImage;
    }
    
	
}
