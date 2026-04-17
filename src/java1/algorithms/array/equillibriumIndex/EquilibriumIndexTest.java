import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class EquilibriumIndexTest {
    @Test
    void testEquilibriumIndexFound() {
        int[] nums = {1, 3, 5, 2, 2};
        assertEquals(2, EquilibriumIndex.equilibriumIndex(nums));
    }

    @Test
    void testNoEquilibriumIndex() {
        int[] nums = {1, 2, 3};
        assertEquals(-1, EquilibriumIndex.equilibriumIndex(nums));
    }

    @Test
    void testSingleElement() {
        int[] nums = {10};
        assertEquals(0, EquilibriumIndex.equilibriumIndex(nums));
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        assertEquals(-1, EquilibriumIndex.equilibriumIndex(nums));
    }
}