package seedu.coursepilot.model.tutorial;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

/**
 * Represents a tutorial in CoursePilot.
 * A tutorial has a code, scheduled day, time slot, and a maximum capacity.
 */
public class Tutorial {
    private final String tutorialCode;
    private final String day;
    private final String timeSlot;
    private final int capacity;

    /**
     * Constructs a {@code Tutorial}.
     *
     * @param tutorialCode unique code identifying the tutorial
     * @param day the day the tutorial is held
     * @param timeSlot the time slot of the tutorial
     * @param capacity maximum number of students allowed
     */
    public Tutorial(String tutorialCode, String day, String timeSlot, int capacity) {
        requireNonNull(tutorialCode);
        requireNonNull(day);
        requireNonNull(timeSlot);

        this.tutorialCode = tutorialCode;
        this.day = day;
        this.timeSlot = timeSlot;
        this.capacity = capacity;
    }

    /**
     * Returns the tutorial code.
     */
    public String getTutorialCode() {
        return tutorialCode;
    }

    /**
     * Returns the day the tutorial takes place.
     */
    public String getDay() {
        return day;
    }

    /**
     * Returns the time slot of the tutorial.
     */
    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * Returns the maximum capacity of the tutorial.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns true if both tutorials have the same fields.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Tutorial)) {
            return false;
        }

        Tutorial otherTutorial = (Tutorial) other;
        return tutorialCode.equals(otherTutorial.tutorialCode)
                && day.equals(otherTutorial.day)
                && timeSlot.equals(otherTutorial.timeSlot)
                && capacity == otherTutorial.capacity;
    }

    /**
     * Returns the hash code based on tutorial attributes.
     */
    @Override
    public int hashCode() {
        return Objects.hash(tutorialCode, day, timeSlot, capacity);
    }
}
