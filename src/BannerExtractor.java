import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cwhite on 10/3/2017.
 */
public class BannerExtractor {
    //private String bannerInputPath = "data/BannerInput.txt"; //Test Data
    private File bannerInput;
    private List<Banner> banners;


    public BannerExtractor(String filepath) throws FileNotFoundException{
        bannerInput = new File(filepath);
        if (inputIsValid(bannerInput)) {
            banners = makeBannerListFromFile(bannerInput);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private List<Banner> makeBannerListFromFile(File bannerInput) throws FileNotFoundException{
        Scanner scanner = new Scanner(bannerInput);
        List<Banner> banners = new ArrayList<>();
        while (scanner.hasNextLine()) {
            Banner banner = new Banner(scanner.nextLine(), scanner.nextLine());
            banners.add(banner);
        }
        return banners;
    }

    private boolean inputIsValid(File bannerInput) throws FileNotFoundException{
        if (!bannerInput.exists() || bannerInput.isDirectory()){
            System.out.println("Input file does not exist or is a directory. Throw IllegalArgumentException:");
            return false;
        }

        Scanner scanner = new Scanner(bannerInput);
        if (!scanner.hasNextLine()) {
            System.out.println("Input file is empty. Throw IllegalArgumentException:");
            return false;
        }

        int linesRead = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            linesRead++;
        }
        if (linesRead % 2 != 0) {
            System.out.println("Input file does not have an even number of lines. Throw IllegalArgumentException:");
            return false;
        }

        scanner.close();
        return true;
    }

    public List<Banner> getBanners() {
        return banners;
    }
}
