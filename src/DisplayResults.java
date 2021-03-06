import java.util.List;

/**
 * Outputs results.
 */
public class DisplayResults {
    public DisplayResults(List<Banner> allBanners, List<Banner> faultyBanners) {
        System.out.println(faultyBanners.size() + " out of " + allBanners.size() + " are faulty.\n");
        if (faultyBanners.size() > 0) {
            System.out.println("Faulty banners: ");
            int i = 1;
            String padding = "     ";
            for (Banner banner : faultyBanners) {
                System.out.println(i + ". Config: " + banner.getConfiguratorInput());
                System.out.println(padding + "Cart: " + banner.getCartInput() + "\n");
                if(Integer.toString(i).length() != Integer.toString(++i).length()){
                    padding += " ";
                }
            }
        }
    }
}

