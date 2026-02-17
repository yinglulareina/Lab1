import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit5 tests for the recursive IListOfBooks implementation.
 */
public class IListOfBooksTest {
    private Book javaBook;
    private Book pythonBook;
    private IListOfBooks empty;
    private IListOfBooks singleList;
    private IListOfBooks multiList;

    /**
     * Default constructor for test class.
     */
    public IListOfBooksTest() {}

    /**
     * Sets up the test environment before each test case.
     */
    @BeforeEach
    public void setUp() {
        javaBook = new Book("Java Basics", "John Smith", 2020, 45.50f);
        pythonBook = new Book("Python Advanced", "Jane Doe", 2010, 30.00f);
        empty = new EmptyNode();
        singleList = new ElementNode(javaBook, empty);
        multiList = new ElementNode(javaBook, new ElementNode(pythonBook, empty));
    }

    /**
     * Tests the count method.
     */
    @Test
    public void testCount() {
        assertEquals(0, empty.count());
        assertNotEquals(1, empty.count());
        assertEquals(1, singleList.count());
        assertEquals(2, multiList.count());
    }

    /**
     * Tests the totalPrice method.
     */
    @Test
    public void testTotalPrice() {
        assertEquals(0.0f, empty.totalPrice(), 0.01);
        assertEquals(0.0f, empty.allBefore(2000).totalPrice(), 0.01);
        assertEquals(45.50f, singleList.totalPrice(), 0.01);
        assertEquals(75.50f, multiList.totalPrice(), 0.01);
    }

    /**
     * Tests the allBefore filter method.
     */
    @Test
    public void testAllBefore() {
        assertEquals(0, empty.allBefore(2015).count());
        assertInstanceOf(EmptyNode.class, empty.allBefore(2025));
        IListOfBooks filtered = multiList.allBefore(2015);
        assertEquals(1, filtered.count());
        assertEquals(2, multiList.allBefore(2025).count());
        assertInstanceOf(ElementNode.class, filtered);
    }

    /**
     * Tests the addAtEnd method.
     */
    @Test
    public void testAddAtEnd() {
        IListOfBooks res1 = empty.addAtEnd(javaBook);
        assertEquals(1, res1.count());
        assertEquals(45.50f, res1.totalPrice(), 0.01);
        IListOfBooks res2 = singleList.addAtEnd(pythonBook);
        assertEquals(2, res2.count());
        assertEquals(75.50f, res2.totalPrice(), 0.01);
    }

    /**
     * Tests the toString method.
     */
    @Test
    public void testToString() {
        assertEquals("", empty.toString());
        assertTrue(empty.toString().isEmpty());
        assertFalse(singleList.toString().isEmpty());
        assertTrue(multiList.toString().contains("Jane Doe"));
    }
}