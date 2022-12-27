import javax.imageio.ImageIO;
import java.io.File;

public class VideoToASCII {
    private ImageToASCII[] frames;

    public VideoToASCII(int numberOfFrames){
       frames = new ImageToASCII[numberOfFrames];
    }

    public void loadImages(String fileName){
        String name;
        boolean opened;

        for(int i=0;i<frames.length;i++){
            name=fileName+(i+1)+".png";
            frames[i] = new ImageToASCII();
            opened = frames[i].openFile(name);
            System.out.println(name);
            //System.out.println(opened);
            frames[i].createASCII();
        }
    }
    public void printImages() {
        for(int i=0;i<frames.length;i++){
            ImageToASCII.clearScreen();
            frames[i].printASCIIImage();
            try {
                Thread.sleep(34);
            }catch(InterruptedException e){

            }
        }
    }


}
