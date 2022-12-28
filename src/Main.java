import java.awt.*;

public class Main {
    public static void main(String[] args) {

        VideoToASCII video = new VideoToASCII();

        //video.loadVideo("/home/wieslaw/Videos/simplescreenrecorder-2022-12-26_22.56.42.mp4");
        if(args.length>0){
            video.setSleepTime(Integer.parseInt(args[1]));
        }
        if(args.length>2){
            if(args[2].equals("-l")){
                video.loadVideo(args[0]);
                while(true){
                    video.printImages();

                }
            }
        }else{

            video.loadVideo(args[0]);

            video.displayCountdown(3);

            video.printImages();

            ImageToASCII.clearScreen();



            video.printCenteredString("END", "#");
        }



    }
}