import java.util.ArrayList;
import java.util.List;

/**
 * Compares all banners.
 */
public class BannerComparator {
    private List<Banner> faultyBanners = new ArrayList<>();


    public BannerComparator(List<Banner> allBanners) {
        faultyBanners = extractFaultyBanners(allBanners);
    }

    private List<Banner> extractFaultyBanners(List<Banner> allBanners) {
        for (Banner banner : allBanners) {
            if (!banner.inputsMatch()) {
                faultyBanners.add(banner);
            }
        }
        return faultyBanners;
    }

    public List<Banner> getFaultyBanners() {
        return faultyBanners;
    }
}
