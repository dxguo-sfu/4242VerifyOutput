import java.util.ArrayList;
import java.util.List;

/**
 * Created by cwhite on 10/3/2017.
 */
public class BannerComparator {
    private List<Banner> allBanners;
    private List<Banner> faultyBanners = new ArrayList<>();


    public BannerComparator(List<Banner> allBanners) {
        this.allBanners = allBanners;
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
