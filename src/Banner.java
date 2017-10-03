/**
 * Created by cwhite on 10/3/2017.
 */
public class Banner {
    private String configuratorInput;
    private String cartInput;

    public Banner(String configuratorInput, String cartInput) {
        this.configuratorInput = configuratorInput;
        this.cartInput = cartInput;
    }

    public String getConfiguratorInput() {
        return configuratorInput;
    }

    public String getCartInput() {
        return cartInput;
    }

    public boolean inputsMatch() {
        return (configuratorInput.toLowerCase()).equals(cartInput.toLowerCase());
    }

    @Override
    public String toString() {
        return getClass() + "[configuratorInput: " + configuratorInput +
                ";\n                      cartInput: " + cartInput + "]\n";
    }
}
