package seedu.address.model.order;

import java.util.Optional;

/**
 * Represents a product + quantity pair.
 */
public class ProductQuantityPair {
    private final Product product;
    private final Integer quantity;

    /**
     * Constructs a {@code ProductQuantityPair}.
     *
     * @param productQuantityPair A valid product + quantity pair.
     */
    public ProductQuantityPair(String productQuantityPair) {
        String[] pair = productQuantityPair.split(" ", 2);
        String product = pair[0];
        String quantity = pair[1];
        this.product = new ProductList().getItem(Integer.parseInt(product));
        this.quantity = OrderMap.isValidProductQuantityPair(productQuantityPair)
                ? Integer.parseInt(quantity)
                : null;
    }

    /**
     * Returns true if a given string is a valid product + quantity pair.
     */
    public static boolean isValidProductQuantityPair(String test) {
        return OrderMap.isValidProductQuantityPair(test);
    }

    /**
     * Returns the Product of a ProductQuantityPair.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns the Quantity of a ProductQuantityPair.
     */
    public Optional<Integer> getQuantity() {
        return Optional.ofNullable(quantity);
    }
}
