import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageToASCII {
    BufferedImage image;
    InputStream fileHandler;


    String ASCIIImage;
    int width;
    int height;
    public ImageToASCII(){
        width=0;
        height=0;
        fileHandler=null;
    }

    public boolean openFile(String filePath){

        try {
            fileHandler = new FileInputStream(filePath);
           image = ImageIO.read(fileHandler);
           width = image.getWidth();
           height = image.getHeight();
           //System.out.println("Typ:"+ image);
        }catch(IOException e){
            return false;
        }
        return true;

    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void createASCII(){
        StringBuilder result = new StringBuilder();

        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                result.append(image.getRGB(j,i) <= -1600000 ? ' ': '*');
                result.append("  ");
            }
            result.append('\n');
        }
        ASCIIImage = result.toString();

        if (fileHandler != null) {
            try {
                fileHandler.close();
            } catch (IOException ex) {
                System.out.println("ERROR closing image input stream: "+ex.getMessage()+ ex);
            }
        }
        fileHandler=null;
        image=null;

    }
    public void printASCIIImage(){
       System.out.println(ASCIIImage);
    }




}
