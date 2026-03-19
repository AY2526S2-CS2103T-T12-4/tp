package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REGION_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REGION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.order.Order;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalOrders {

    public static final Order ALICE_ORDER = new OrderBuilder().withPerson(TypicalPersons.ALICE)
            .withOrder("1 2", "2 4").build();
    public static final Order BENSON_ORDER = new OrderBuilder().withPerson(TypicalPersons.BENSON)
            .withOrder("2 1", "3 6", "1 1").build();
    public static final Order CARL_ORDER = new OrderBuilder().withPerson(TypicalPersons.CARL)
            .withOrder("1 1").build();
    public static final Order DANIEL_ORDER = new OrderBuilder().withPerson(TypicalPersons.DANIEL)
            .withOrder("4 1").build();
    public static final Order ELLE_ORDER = new OrderBuilder().withPerson(TypicalPersons.ELLE)
            .withOrder("4 4").build();
    public static final Order FIONA_ORDER = new OrderBuilder().withPerson(TypicalPersons.FIONA)
            .withOrder("5 1").build();
    public static final Order GEORGE_ORDER = new OrderBuilder().withPerson(TypicalPersons.GEORGE)
            .withOrder("2 2", "4 2").build();

    // Manually added
    public static final Order HOON_ORDER = new OrderBuilder().withPerson(TypicalPersons.HOON)
            .withOrder("1 1", "2 2").build();
    public static final Order IDA_ORDER = new OrderBuilder().withPerson(TypicalPersons.IDA)
            .withOrder("3 2", "4 3").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Order AMY_ORDER = new OrderBuilder().withPerson(TypicalPersons.AMY)
            .withOrder("3 2", "4 4").build();
    public static final Order BOB_ORDER = new OrderBuilder().withPerson(TypicalPersons.BOB)
            .withOrder("1 2", "3 1").build();

    private TypicalOrders() {} // prevents instantiation

    public static List<Order> getTypicalOrders() {
        return new ArrayList<>(Arrays.asList(ALICE_ORDER, BENSON_ORDER, CARL_ORDER, DANIEL_ORDER, ELLE_ORDER, FIONA_ORDER, GEORGE_ORDER));
    }
}
