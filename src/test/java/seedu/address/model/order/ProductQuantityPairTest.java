package seedu.address.model.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ProductQuantityPairTest {
    @Test
    void equals_returnsTrue() {
        ProductQuantityPair pair1 = new ProductQuantityPair("1 1");
        ProductQuantityPair pair2 = new ProductQuantityPair("1 1");
        assertEquals(pair1, pair2);
    }

    @Test
    void equals_hashSetSameOrder_returnsTrue() {
        Set<ProductQuantityPair> set1 = new HashSet<>();
        set1.add(new ProductQuantityPair("1 1"));
        set1.add(new ProductQuantityPair("2 2"));
        set1.add(new ProductQuantityPair("3 3"));

        Set<ProductQuantityPair> set2 = new HashSet<>();
        set2.add(new ProductQuantityPair("1 1"));
        set2.add(new ProductQuantityPair("2 2"));
        set2.add(new ProductQuantityPair("3 3"));

        assertEquals(set1, set2);
    }

    @Test
    void equals_hashSetDifferentOrder_returnsTrue() {
        Set<ProductQuantityPair> set1 = new HashSet<>();
        set1.add(new ProductQuantityPair("1 1"));
        set1.add(new ProductQuantityPair("2 2"));
        set1.add(new ProductQuantityPair("3 3"));

        Set<ProductQuantityPair> set2 = new HashSet<>();
        set2.add(new ProductQuantityPair("3 3"));
        set2.add(new ProductQuantityPair("2 2"));
        set2.add(new ProductQuantityPair("1 1"));

        assertEquals(set1, set2);
    }

    @Test
    void equals_differentProduct_returnsFalse() {
        ProductQuantityPair pair1 = new ProductQuantityPair("1 1");
        ProductQuantityPair pair2 = new ProductQuantityPair("2 1");
        assertNotEquals(pair1, pair2);
    }

    @Test
    void equals_differentQuantity_returnsFalse() {
        ProductQuantityPair pair1 = new ProductQuantityPair("1 1");
        ProductQuantityPair pair2 = new ProductQuantityPair("1 2");
        assertNotEquals(pair1, pair2);
    }
}
