public class VideoToASCIITest {
    public static void main(String[] arg){
        VideoToASCII video = new VideoToASCII();

        video.loadVideo("/home/wieslaw/Videos/simplescreenrecorder-2022-12-26_15.21.29.mp4");
        video.printCenteredString("END", "#");

        video.printImages();

    }
}
