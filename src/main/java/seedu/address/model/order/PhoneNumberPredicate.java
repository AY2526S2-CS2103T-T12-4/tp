package seedu.address.model.order;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that an {@code OrderMap}'s person's phone matches the specified phone number.
 */
public class PhoneNumberPredicate implements Predicate<OrderMap> {
    private final String phone_num;

    public PhoneNumberPredicate(String phone_num) {
        this.phone_num = phone_num;
    }

    @Override
    public boolean test(OrderMap order) {
        return order.getPerson().getPhone().toString().equals(phone_num);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PhoneNumberPredicate)) {
            return false;
        }

        PhoneNumberPredicate otherPredicate = (PhoneNumberPredicate) other;
        return phone_num.equals(otherPredicate.phone_num);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("phone_num", phone_num).toString();
    }
}
