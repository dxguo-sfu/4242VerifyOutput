import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by cwhite on 10/3/2017.
 */
public class Main {
    private List<Banner> allBanners;
    private List<Banner> faultyBanners;

    public static void main(String[] args) throws FileNotFoundException{
        if (args.length == 1) {
            String filepath = args[0];
            new Main(filepath);
        } else {
            System.out.println("Enter filepath as the sole argument");
        }
    }

    private Main(String filepath) throws FileNotFoundException {
        allBanners = getAllBanners(filepath);
        faultyBanners = getFaultyBanners();
        new DisplayResults(allBanners, faultyBanners);
    }

    private List<Banner> getAllBanners(String filepath) throws FileNotFoundException {
        BannerExtractor bannerExtractor = new BannerExtractor(filepath);
        return bannerExtractor.getBanners();
    }

    private List<Banner> getFaultyBanners() {
        BannerComparator bannerComparator = new BannerComparator(allBanners);
        return bannerComparator.getFaultyBanners();
    }
}
