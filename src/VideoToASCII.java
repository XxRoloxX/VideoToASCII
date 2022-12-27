import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class VideoToASCII {
    private ImageToASCII[] frames;

    public VideoToASCII(int numberOfFrames){
        frames = new ImageToASCII[numberOfFrames];
    }

    public void createFrames(String videoName){
        //String[] cmd={"ffmpeg","-i",videoName,"-vf","fps=30","/home/wieslaw/Video/out%d.png"};
        String cmd = "ffmpeg"+" -i "+videoName +" -vf " +" fps=30 "+"frames/out%d.png";

        try {
            Process p = new ProcessBuilder("/bin/sh","-c",cmd)
                    .redirectErrorStream(true)
                    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                    .start();
            p.waitFor();
            System.out.println(p.exitValue() + p.info().toString());
        }catch(Exception e){
            System.out.println(e);
        }

    }
    public void emptyDirectory(String directory){
        String cmd = "rm " +directory+"*";
        try {
            Process p = new ProcessBuilder("/bin/sh","-c",cmd)
                    .redirectErrorStream(true)
                    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                    .start();
            p.waitFor();
            System.out.println(p.exitValue() + p.info().toString());
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void loadVideo(String videoName){
        String outputFileName = "frames/out";
        String name;
        boolean opened;

        emptyDirectory("frames/");
        createFrames(videoName);

        for(int i=0;i<frames.length;i++){
            name=outputFileName+(i+1)+".png";
            frames[i] = new ImageToASCII();
            opened = frames[i].openFile(name);
            ImageToASCII.clearScreen();
            System.out.println(name);
            //System.out.println(opened);
            frames[i].createASCII();
        }
        emptyDirectory("frames/");


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
