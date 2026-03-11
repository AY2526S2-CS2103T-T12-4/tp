package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("/name ");
    public static final Prefix PREFIX_PHONE = new Prefix("/number ");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("/address ");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_UNIT = new Prefix("/unit ");
    public static final Prefix PREFIX_REGION = new Prefix("/region ");
    public static final Prefix PREFIX_ORDER = new Prefix("/order ");

}
