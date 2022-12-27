public class Main {
    public static void main(String[] args) {

        VideoToASCII video = new VideoToASCII();

        //video.loadVideo("/home/wieslaw/Videos/simplescreenrecorder-2022-12-26_22.56.42.mp4");
        video.loadVideo("/home/wieslaw/Videos/simplescreenrecorder-2022-12-26_16.50.16.mp4");
        video.displayCountdown(3);

        video.printImages();

    }
}