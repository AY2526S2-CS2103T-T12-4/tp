package seedu.address.model.order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.model.person.Region;
import seedu.address.testutil.OrderBuilder;
import seedu.address.testutil.PersonBuilder;

public class ActiveOrderInRegionPredicateTest {

    @Test
    public void test_matchesRegionAndPending() {
        Person northPerson = new PersonBuilder().withRegion("N").build();
        OrderMap pendingNorth = new OrderBuilder().withPerson(northPerson).build();
        ActiveOrderInRegionPredicate predicate = new ActiveOrderInRegionPredicate(new Region("N"));

        assertTrue(predicate.test(pendingNorth));
    }

    @Test
    public void test_differentRegion_returnsFalse() {
        Person eastPerson = new PersonBuilder().withRegion("E").build();
        OrderMap pendingEast = new OrderBuilder().withPerson(eastPerson).build();
        ActiveOrderInRegionPredicate predicate = new ActiveOrderInRegionPredicate(new Region("N"));

        assertFalse(predicate.test(pendingEast));
    }

    @Test
    public void test_completedOrder_returnsFalse() {
        Person northPerson = new PersonBuilder().withRegion("N").build();
        OrderMap completedNorth = new OrderMap(1, northPerson,
                new OrderBuilder().getDefaultOrderMap(),
                OrderStatus.COMPLETED,
                new OrderDateTime(LocalDateTime.now()));
        ActiveOrderInRegionPredicate predicate = new ActiveOrderInRegionPredicate(new Region("N"));

        assertFalse(predicate.test(completedNorth));
    }

    @Test
    public void equalsAndHashCode() {
        ActiveOrderInRegionPredicate predicate = new ActiveOrderInRegionPredicate(new Region("N"));
        ActiveOrderInRegionPredicate samePredicate = new ActiveOrderInRegionPredicate(new Region("N"));
        ActiveOrderInRegionPredicate otherPredicate = new ActiveOrderInRegionPredicate(new Region("E"));

        assertTrue(predicate.equals(predicate));
        assertTrue(predicate.equals(samePredicate));
        assertFalse(predicate.equals(otherPredicate));
        assertFalse(predicate.equals(null));
        assertFalse(predicate.equals(1));
        assertEquals(predicate.hashCode(), samePredicate.hashCode());
    }
}

