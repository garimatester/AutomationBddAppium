package utils.tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class contains methods to compare values. It could be extended at any time you need access to this methods where
 * 
 *
 * 
 */
public abstract class QaComparator{

    /**
     *
     */
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Compares two values. The key is required for the logging. When expected is null, the current value must be null
     * as well.
     *
     * @param <T>
     * @param testCase
     * @param key
     * @param expected
     * @param current
     * @param omitNullValues
     * @return true when expected matches current
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public <T extends Comparable> boolean compareObjectValue(final String key, final T expected, final T current,
            final boolean omitNullValues) {

        log.info(buildCompareMessage(key, expected, current));

        if (omitNullValues && expected == null) {
            return true;
        }

        if (expected == null) {
            if (current != null) {
                writeToErrorSummary(key, "ERROR: " + key + " is not null. expected: " + expected + ", actual: " + current);
                return false;
            } else {
                return true;
            }
        }
        if (current == null) {
            writeToErrorSummary(key, "ERROR: " + key + " does not match (null). expected: " + expected + ", actual: " + current);
            return false;
        }

        if (expected.compareTo(current) != 0) {
            writeToErrorSummary(key, "ERROR: " + key + " does not match. expected: " + expected + ", actual: " + current);
            return false;
        }
        return true;
    }

    /**
     *
     * @param <T>
     * @param key
     * @param expected
     * @param current
     * @return
     */
    @SuppressWarnings("rawtypes")
    private <T extends Comparable> String buildCompareMessage(final String key, final T expected, final T current) {
        return "Comparing object value of " + key + ". expected: " + expected + ", actual: " + current + ", type: (" + getType(expected, current) + ")";
    }

    /**
     *
     * @param <T>
     * @param expected
     * @param current
     * @return
     */
    private <T> String getType(final T expected, final T current) {
        if (expected != null) {
            return expected.getClass().getName();
        } else if (current != null) {
            return current.getClass().getSimpleName();
        } else {
            return "unknown/null";
        }
    }

  
    /**
     * 
     *
     * @param testCase
     * @param errorMessage
     */
    protected void writeToErrorSummary(final String key, final String errorMessage) {
        log.error(errorMessage);
    }

    

}
