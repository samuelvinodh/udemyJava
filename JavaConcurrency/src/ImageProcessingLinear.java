import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageProcessingLinear {
    public static final String SOURCE_FILE = "./resources/many-flowers.jpg";
    public static final String DESTINATION_FILE = "./out/many-flowers-p.jpg";
    public static void main(String[] args) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File(SOURCE_FILE));
        BufferedImage resultImage = new BufferedImage(originalImage.getWidth(),originalImage.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        long startTime = System.currentTimeMillis();
        //reColorSingleThreaded(originalImage,resultImage);
        int numOfThreads = 4;
        reColorMultiThreaded(originalImage,resultImage,numOfThreads);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        File outputFile = new File(DESTINATION_FILE);
        ImageIO.write(resultImage,"jpg",outputFile);
        System.out.println("Duration: "+String.valueOf(duration));
    }

    public static void reColorMultiThreaded(BufferedImage originalImage, BufferedImage resultImage, int numberOfThreads){
        List<Thread> threads = new ArrayList<>(numberOfThreads);
        int width = originalImage.getWidth();
        int height = originalImage.getHeight()/numberOfThreads;
        for(int i=0; i<numberOfThreads; i++){
            final int threadMultiplier = i;
            Thread thread = new Thread(() -> {
                int leftCorner = 0;
                int topCorner = height * threadMultiplier;
                reColorImage(originalImage,resultImage,leftCorner,topCorner,width,height);
            });
            threads.add(thread);
        }
        for(Thread t: threads){
            t.start();
        }
        for(Thread t: threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void reColorSingleThreaded(BufferedImage originalImage, BufferedImage resultImage){
        reColorImage(originalImage,resultImage,0,0,originalImage.getWidth(),originalImage.getHeight());
    }

    public static void reColorImage(BufferedImage originalImage, BufferedImage resultImage, int leftCorner, int topCorner,
                               int width, int height){
        for(int x = leftCorner; x < leftCorner + width && x < originalImage.getWidth(); x++){
            for(int y = topCorner; y < topCorner + height && y < originalImage.getHeight(); y++){
                reColorPixel(originalImage,resultImage,x,y);
            }
        }
    }

    public static void reColorPixel(BufferedImage originalImage, BufferedImage resultImage, int x, int y){
        int rgb = originalImage.getRGB(x,y);
        int red = getRed(rgb);
        int green = getGreen(rgb);
        int blue = getBlue(rgb);
        int newRed;
        int newGreen;
        int newBlue;

        if (isShadeOfGray(red,green,blue)){
            newRed = Math.min(255,red + 10);
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0,blue - 20);
        } else {
            newRed = red;
            newGreen = green;
            newBlue = blue;
        }
        int newRGB = createRGBFromColors(newRed, newGreen, newBlue);
        setRGB(resultImage,x,y,newRGB);
    }

    public static void setRGB(BufferedImage resultImage, int x, int y, int rgb){
        resultImage.getRaster().setDataElements(x,y,resultImage.getColorModel().getDataElements(rgb, null));
    }

    public static boolean isShadeOfGray(int red, int green, int blue){
        return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs(green - blue) < 30;
    }

    public static int createRGBFromColors(int red, int green, int blue){
        int rgb = 0;
        rgb |= blue;
        rgb |= green << 8;
        rgb |= red << 16;
        rgb |= 0xFF000000;
        return rgb;
    }

    public static int getBlue(int rgb){
        return rgb & 0x000000FF;
    }

    public static int getGreen(int rgb){
        return (rgb & 0x0000FF00) >> 8;
    }

    public static int getRed(int rgb){
        return (rgb & 0x00FF0000) >> 16;
    }
}
