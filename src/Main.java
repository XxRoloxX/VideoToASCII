public class Main {
    public static void main(String[] args) {

        VideoToASCII video = new VideoToASCII();

        //video.loadVideo("/home/wieslaw/Videos/simplescreenrecorder-2022-12-26_22.56.42.mp4");
        if(args.length>0){
            video.setSleepTime(Integer.parseInt(args[1]));
        }
        video.loadVideo(args[0]);

        video.displayCountdown(3);

        video.printImages();

    }
}