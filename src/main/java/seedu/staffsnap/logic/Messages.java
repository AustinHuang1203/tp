package seedu.staffsnap.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.staffsnap.logic.parser.Prefix;
import seedu.staffsnap.model.applicant.Applicant;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_APPLICANT_DISPLAYED_INDEX = "The applicant index provided is invalid";
    public static final String MESSAGE_APPLICANTS_LISTED_OVERVIEW = "%1$d applicants listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s): ";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code applicant} for display to the user.
     */
    public static String format(Applicant applicant) {
        final StringBuilder builder = new StringBuilder();
        builder.append(applicant.getName())
                .append("; Phone: ")
                .append(applicant.getPhone())
                .append("; Department: ")
                .append(applicant.getDepartment())
                .append("; Position: ")
                .append(applicant.getPosition())
                .append("; Interviews: ");
        applicant.getInterviews().forEach(builder::append);
        return builder.toString();
    }

}
