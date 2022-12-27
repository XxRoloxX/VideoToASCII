public class VideoToASCIITest {
    public static void main(String[] arg){
        VideoToASCII video = new VideoToASCII(9600);
        video.loadImages("/home/wieslaw/Videos/badAppleFull/out");
        video.printImages();
    }
}
