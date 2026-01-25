import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoeTest {

    private Shoe shoe1;
    private Shoe shoe2;

    @BeforeEach
    void setUp() {
        // normal shoes：testing getters / toString
        shoe1 = new Shoe(Brand.ZARA, Color.BLACK, Kind.SNEAKER, 9.5);

        // test the default setting in color toString
        shoe2 = new Shoe(Brand.TAOBAO, Color.BROWN, Kind.BOOT, 7.0);
    }

    @Test
    void constructor_validObjectCreated() {
        assertNotNull(shoe1);
        assertNotNull(shoe2);

        assertEquals(Brand.ZARA, shoe1.getBrand());
        assertEquals(9.5, shoe1.getSize());
    }

    @Test
    void constructor_invalidCombinationThrows() {
        // abnormal shoes
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Shoe(Brand.NIKE, Color.WHITE, Kind.DRESS, 8.0)
        );

        // test message
        assertTrue(ex.getMessage().toLowerCase().contains("nike"));
    }

    @Test
    void getBrand() {
        assertEquals(Brand.ZARA, shoe1.getBrand());
        assertEquals(Brand.TAOBAO, shoe2.getBrand());
    }

    @Test
    void getColor() {
        assertEquals(Color.BLACK, shoe1.getColor());
        assertEquals(Color.BROWN, shoe2.getColor());
    }

    @Test
    void getKind() {
        assertEquals(Kind.SNEAKER, shoe1.getKind());
        assertEquals(Kind.BOOT, shoe2.getKind());
    }

    @Test
    void getSize() {
        assertEquals(9.5, shoe1.getSize());
        assertEquals(7.0, shoe2.getSize());
    }

    @Test
    void toString_includesAllAttributes() {
        String s1 = shoe1.toString();

        assertTrue(s1.contains("brand="));
        assertTrue(s1.contains("color="));
        assertTrue(s1.contains("kind="));
        assertTrue(s1.contains("size="));

        assertTrue(s1.contains("Zara"));
        assertTrue(s1.contains("Sneaker"));
    }

    @Test
    void toString_colorDefaultBranchWorks() {
        String s2 = shoe2.toString();

        // test default color BROWN
        assertTrue(s2.contains("BROWN") || s2.contains("Brown"));
        assertTrue(s2.contains("Taobao"));
    }
}
