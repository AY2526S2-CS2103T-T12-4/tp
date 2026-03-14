package seedu.address.testutil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.order.Order;
import seedu.address.model.order.OrderStatus;
import seedu.address.model.person.Person;
/**
 * A utility class containing a list of {@code Order} objects to be used in tests.
 */
public class TypicalOrders {
    private static final Person ALICE_PERSON = new PersonBuilder().withName("Alice Pauline").build();
    private static final Person BENSON_PERSON = new PersonBuilder().withName("Benson").build();
    private static final Person CARL_PERSON = new PersonBuilder().withName("Carl").build();
    private static final Person DANIEL_PERSON = new PersonBuilder().withName("Daniel").build();

    public static final Order ALICE_ORDER = new OrderBuilder()
            .withOrderId("1")
            .withPerson(ALICE_PERSON)
            .withProduct("Nasi Lemak")
            .withQuantity("2")
            .withPrice("5")
            .withStatus(OrderStatus.PENDING)
            .withOrderDate(LocalDate.parse("2026-03-10"))
            .build();

    public static final Order BENSON_ORDER = new OrderBuilder()
            .withOrderId("2")
            .withPerson(BENSON_PERSON)
            .withProduct("Chicken Rice")
            .withQuantity("1")
            .withPrice("4")
            .withStatus(OrderStatus.PENDING)
            .withOrderDate(LocalDate.parse("2026-03-11"))
            .build();

    public static final Order CARL_ORDER = new OrderBuilder()
            .withOrderId("3")
            .withPerson(CARL_PERSON)
            .withProduct("Laksa")
            .withQuantity("3")
            .withPrice("6")
            .withStatus(OrderStatus.COMPLETED)
            .withOrderDate(LocalDate.parse("2026-03-12"))
            .build();

    public static final Order DANIEL_ORDER = new OrderBuilder()
            .withOrderId("4")
            .withPerson(DANIEL_PERSON)
            .withProduct("Char Kway Teow")
            .withQuantity("1")
            .withPrice("5")
            .withStatus(OrderStatus.PENDING)
            .withOrderDate(LocalDate.parse("2026-03-13"))
            .build();

    private TypicalOrders() {} // prevents instantiation

    /**
     * Returns an AddressBook with typical orders.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();

        ab.addPerson(ALICE_PERSON);
        ab.addPerson(BENSON_PERSON);
        ab.addPerson(CARL_PERSON);
        ab.addPerson(DANIEL_PERSON);

        for (Order order : getTypicalOrders()) {
            ab.addOrder(order);
        }

        return ab;
    }

    public static List<Order> getTypicalOrders() {
        return new ArrayList<>(Arrays.asList(
                ALICE_ORDER,
                BENSON_ORDER,
                CARL_ORDER,
                DANIEL_ORDER
        ));
    }
}
