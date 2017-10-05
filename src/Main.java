import java.io.FileNotFoundException;
import java.util.List;

/**
 * Main control panel that tells everything to go.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        if (args.length == 1) {
            String filepath = args[0];
            new Main(filepath);
        } else {
            System.out.println("Enter filepath as the sole argument");
        }
    }

    private Main(String filepath) throws FileNotFoundException {
        List<Banner> allBanners = getAllBanners(filepath);
        List<Banner> faultyBanners = getFaultyBanners(allBanners);
        new DisplayResults(allBanners, faultyBanners);
    }

    private List<Banner> getAllBanners(String filepath) throws FileNotFoundException {
        BannerExtractor bannerExtractor = new BannerExtractor(filepath);
        return bannerExtractor.getBanners();
    }

    private List<Banner> getFaultyBanners(List<Banner> allBanners) {
        BannerComparator bannerComparator = new BannerComparator(allBanners);
        return bannerComparator.getFaultyBanners();
    }
}
