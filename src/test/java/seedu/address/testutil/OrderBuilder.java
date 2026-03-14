package seedu.address.testutil;

import seedu.address.model.order.*;
import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OrderBuilder {

    public static final String DEFAULT_ORDER_ID = "1";
    public static final String DEFAULT_PRODUCT = "Fried Rice";
    public static final String DEFAULT_QUANTITY = "1";
    public static final String DEFAULT_PRICE = "5";
    public static final OrderStatus DEFAULT_STATUS = OrderStatus.PENDING;
    public static final LocalDate DEFAULT_DATE = LocalDate.of(2026, 3, 10);

    private OrderId orderId;
    private Person person;
    private Product product;
    private Quantity quantity;
    private Price price;
    private OrderStatus status;
    private OrderDate orderDate;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public OrderBuilder() {
        orderId = new OrderId(DEFAULT_ORDER_ID);
        product = new Product(DEFAULT_PRODUCT);
        quantity = new Quantity(DEFAULT_QUANTITY);
        price = new Price(DEFAULT_PRICE);
        status = DEFAULT_STATUS;
        orderDate = new OrderDate(DEFAULT_DATE);
    }

    /**
     * Initializes the OrderBuilder with the data of {@code orderToCopy}.
     */
    public OrderBuilder(Order orderToCopy) {
        orderId = orderToCopy.getOrderId();
        person = orderToCopy.getPerson();
        product = orderToCopy.getProduct();
        quantity = orderToCopy.getQuantity();
        price = orderToCopy.getPrice();
        status = orderToCopy.getOrderStatus();
        orderDate = orderToCopy.getDate();
    }

    /**
     * Sets the {@code OrderId} of the {@code Order} that we are building.
     */
    public OrderBuilder withOrderId(String orderId) {
        this.orderId = new OrderId(orderId);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public OrderBuilder withPerson(Person person) {
        this.person = person;
        return this;
    }
    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public OrderBuilder withProduct(String product) {
        this.product = new Product(product);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public OrderBuilder withQuantity(String quantity) {
        this.quantity = new Quantity(quantity);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public OrderBuilder withPrice(String price) {
        this.price = new Price(price);
        return this;
    }

    /**
     * Sets the {@code Region} of the {@code Person} that we are building.
     */
    public OrderBuilder withStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Sets the orders of the {@code Person} that we are building.
     */
    public OrderBuilder withOrderDate(LocalDate date) {
        this.orderDate = new OrderDate(date);
        return this;
    }

    /**
     * Builds the Order.
     */
    public Order build() {
        return new Order(orderId, person, product, quantity, price, status, orderDate);
    }
}
