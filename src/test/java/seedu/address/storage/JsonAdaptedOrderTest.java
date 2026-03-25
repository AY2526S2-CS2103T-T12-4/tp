package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.AddressBook;
import seedu.address.model.order.Order;
import seedu.address.model.order.OrderDate;
import seedu.address.model.order.OrderId;
import seedu.address.model.order.OrderStatus;
import seedu.address.model.order.Price;
import seedu.address.model.order.Product;
import seedu.address.model.order.Quantity;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Region;

public class JsonAdaptedOrderTest {

    @Test
    public void saveAndLoadOrders() throws Exception, IllegalValueException {
        AddressBook ab = new AddressBook();

        Person person = new Person(
                new Name("Alice"),
                new Phone("98765432"),
                new Email("alice@gmail.com"),
                new Address("123456"),
                new Region("W"),
                new ArrayList<>(),
                new HashSet<>()
        );
        ab.addPerson(person);

        Order order = new Order(
                new OrderId("1"),
                person,
                new Product("Laptop"),
                new Quantity("2"),
                new Price("1500"),
                OrderStatus.PENDING,
                new OrderDate(LocalDate.parse("2026-03-10"))
        );
        ab.addOrder(order);

        JsonSerializableAddressBook json = new JsonSerializableAddressBook(ab);

        AddressBook loaded = json.toModelType();
        assertEquals(1, loaded.getOrderList().size());
    }
}
