package palma.dealer;

import javafx.scene.image.Image;
import palma.core.shop.OpenDealer;
import palma.core.shop.Shop;
import palma.core.shop.contract.Contract;
import palma.core.shop.contract.stamp.Stamp;

/**
 * Handlarz obrazkow
 */
public class ImageDealer extends OpenDealer {

    /**
     * Kontrakt na obrazek symbolu bramki and
     */
    public static final Contract<Image> andGateSymbol = Contract.forObjectOf(Image.class, Stamp.WARRANTY);

    public ImageDealer() {

    }

    @Override
    public void employ(Shop shop) {
        shop.offer(andGateSymbol,()->new Image("palma/img/and-gate-symbol.png"));
    }
}
