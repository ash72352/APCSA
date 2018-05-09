package Unit16;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  public void keepOnlyBlue() 
  {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setBlue(255);
	      }
	    }
  	
  }
  public void keepOnlyRed() 
  {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(255);
	      }
	    }
  	
  }
  public void keepOnlyGreen() 
  {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setGreen(255);
	      }
	    }
  	
  }
  
  public void Negate() 
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int r = 0;
	  int b= 0;
	  int g= 0;
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	  g = pixelObj.getGreen();
	    	  b = pixelObj.getBlue();
	    	  r = pixelObj.getRed();
	    	  pixelObj.setGreen(255-g);
	    	  pixelObj.setRed(255-r);
	    	  pixelObj.setBlue(255-b);
	      }
	    }
  	
  }
  public void blur(int x, int y, int height, int width) 
  {
	  
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel botPixel = null;
	  Color rightColor = null;
	  Color botColor = null;
	  int edgeDist = 1;
	  int r = 0;
	  int b= 0;
	  int g= 0;
	  int avg = 0;
	  
	  for(int row = x; row < width+x; row++)
	  {
		  
		  for(int col = y;col < height+y; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][col+1];
			  botPixel = pixels[row+1][col];
			  rightColor = rightPixel.getColor();
			  botColor = botPixel.getColor();
			  if (leftPixel.colorDistance(rightColor) > edgeDist)
			  {
				  
				  g = leftPixel.getGreen() + rightPixel.getGreen();
				  b = leftPixel.getBlue() + rightPixel.getBlue();
				  r = leftPixel.getRed() + rightPixel.getRed();
				  avg = (r+b+g)/6;
				  leftPixel.setGreen(g/2);
				  leftPixel.setRed(r/2);
				  leftPixel.setBlue(b/2);
				  rightPixel.setGreen(g/2);
				  rightPixel.setRed(r/2);
				  rightPixel.setBlue(b/2);
				  pixels[row][col] = leftPixel;
				  pixels[row][col+1] = rightPixel;
		    		  
			  }
			  if(leftPixel.colorDistance(botColor) > edgeDist)
			  {
				  g = leftPixel.getGreen() + botPixel.getGreen();
				  b = leftPixel.getBlue() + botPixel.getBlue();
				  r = leftPixel.getRed() + botPixel.getRed();
				  avg = (r+b+g)/6;
				  leftPixel.setGreen(g/2);
				  leftPixel.setRed(r/2);
				  leftPixel.setBlue(b/2);
				  botPixel.setGreen(g/2);
				  botPixel.setRed(r/2);
				  botPixel.setBlue(b/2);
				  pixels[row][col] = leftPixel;
				  pixels[row+1][col] = botPixel;
			  }
			  
		  }
		  
	    	  
	    	  
	  }
  	
  }
  public void grayscale() 
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int r = 0;
	  int b= 0;
	  int g= 0;
	  int avg = 0;
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	  g = pixelObj.getGreen();
	    	  b = pixelObj.getBlue();
	    	  r = pixelObj.getRed();
	    	  avg = (r+b+g)/3;
	    	  pixelObj.setGreen(avg);
	    	  pixelObj.setRed(avg);
	    	  pixelObj.setBlue(avg);
	      }
	    }
  	
  }
  
  public void fixUnderwater() 
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int r = 0;
	  int b= 0;
	  int g= 0;
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	  g = pixelObj.getGreen();
	    	  b = pixelObj.getBlue();
	    	  r = pixelObj.getRed();
	    	  pixelObj.setBlue(b-100);
	    	  pixelObj.setGreen(g-100);
	      }
	    }
  	
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    int length = pixels.length;
    for (int col = 0; col <  pixels[0].length; col++)
    {
      for (int row = 0; row  < length / 2; row++)
      {
        topPixel = pixels[row][col];
        botPixel = pixels[length - 1 - row][col];
        botPixel.setColor(topPixel.getColor());
      }
    } 
  }
  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    int length = pixels.length;
    for (int col = 0; col <  pixels[0].length; col++)
    {
      for (int row = 0; row  < length / 2; row++)
      {
        topPixel = pixels[row][col];
        botPixel = pixels[length - 1 - row][col];
        topPixel.setColor(botPixel.getColor());
      }
    } 
  }
  public void mirrorDiagonal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  
	  int width = pixels[0].length;
	  int height = pixels.length;
	  if(height<width)
	  {
		  for (int row = 0; row < height; row++)
		  {
		    for (int col = 0; col < height; col++)
		    {
		      leftPixel = pixels[row][col];
		      rightPixel = pixels[col][row];
		      leftPixel.setColor(rightPixel.getColor());
		    }
		  } 
	  }
	  else
	  {
		  for (int row = 0; row < width; row++)
		  {
		    for (int col = 0; col < width; col++)
		    {
		      leftPixel = pixels[row][col];
		      rightPixel = pixels[col][row];
		      leftPixel.setColor(rightPixel.getColor());
		    }
		  }
	  }
  }
  
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }
  
  public void mirrorArms()
  {
	  
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel botPixel = null;
	    int length = pixels.length;
	    for (int row = 165; row  < 210; row++)
	    {
	      for(int col = 100; col <  300; col++) 
	      {
	        topPixel = pixels[row][col];
	        botPixel = pixels[47 + 1 + row][col];
	        botPixel.setColor(topPixel.getColor());
	      }
	    } 
    
  }
  
  public void mirrorGull()
  {
	  //row 230 col 230
	  //row 330 col 340
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel botPixel = null;
	    int length = pixels.length;
	    for (int row = 230; row  < 330; row++)
	    {
	      for(int col = 230; col <  340; col++) 
	      {
	        topPixel = pixels[row][col];
	        botPixel = pixels[row][110 + 1 + col];
	        botPixel.setColor(topPixel.getColor());
	      }
	    } 
    
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy(Picture fromPic, int startRow, int endRow, int startCol, int endCol)
  {
	
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; 
		  fromRow < endRow &&
		  toRow < endRow; 
		  fromRow++, toRow++)
		{
			for (int fromCol = 0, toCol = startCol; 
			    fromCol < endCol &&
			    toCol < endCol;  
			    fromCol++, toCol++)
			{
			 fromPixel = fromPixels[fromRow][fromCol];
			 toPixel = toPixels[toRow][toCol];
			 toPixel.setColor(fromPixel.getColor());
			}
		}
		
		
	}


  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void createCollageTwo()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0, 100, 0, 50);
    this.copy(flower2,100,200, 0, 50);
    this.copy(flower1,200,300, 0,50);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,400, 0, 50);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void createMyCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    flower2.mirrorVertical();
    this.copy(flower1,0, 50, 0, 100);
    this.copy(flower2,100,150, 0, 100);
    this.copy(flower1,200,250, 0,100);
    Picture flowerNeg = new Picture(flower1);
    flowerNeg.Negate();
    this.copy(flowerNeg,300,400, 0, 100);
    this.copy(flower1,400,0);
    flowerNeg.keepOnlyRed();
    this.copy(flowerNeg,400,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }	
   }
    
    public void edgeDetectionTwo(int edgeDist)
    {
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      Pixel topPixel = null;
      Pixel botPixel = null;
      Pixel[][] pixels = this.getPixels2D();
      Color rightColor = null;
      Color botColor = null;
      for (int row = 0; row < pixels.length-1; row++)
      {
    	  
    	  for (int col = 0;col < pixels[0].length-1; col++)
    	  {
    		  leftPixel = pixels[row][col];
    		  rightPixel = pixels[row][col+1];
    		  botPixel = pixels[row+1][col];
    		  rightColor = rightPixel.getColor();
    		  botColor = botPixel.getColor();
    		  if (leftPixel.colorDistance(rightColor) > edgeDist || leftPixel.colorDistance(botColor) > edgeDist)
    			  leftPixel.setColor(Color.BLACK);
    		  else
    			  leftPixel.setColor(Color.WHITE);
        }
    	  
    	  
      }
      
      
    }

  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  /*
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
*/

  
} // this } is the end of class Picture, put all new methods before this