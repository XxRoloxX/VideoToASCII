public class ImageToASCIITest {
    public static void main(String[] args){
        ImageToASCII image = new ImageToASCII();
        boolean opened = image.openFile("/home/wieslaw/Videos/badAppleOuts/out1.png");
        System.out.println(opened);
        ImageToASCII.clearScreen();
        image.createASCII();
        image.printASCIIImage();

    }
}
