/**
 * Represents the end of a recursive list of books (an empty list).
 * This class serves as the base case for all recursive operations on the list.
 */
public class EmptyNode implements IListOfBooks {

    /**
     * Explicit default constructor for EmptyNode to satisfy Javadoc requirements.
     */
    public EmptyNode() {
        // This is the base case node, no internal state needed.
    }

    /**
     * Returns the count of books in an empty list.
     * @return 0, as there are no books in an empty list.
     */
    @Override
    public int count() {
        return 0;
    }

    /**
     * Returns the total price of all books in an empty list.
     * @return 0.0f, as an empty list has no price.
     */
    @Override
    public float totalPrice() {
        return 0.0f;
    }

    /**
     * Returns a sublist containing books published before a certain year.
     * Since the list is empty, it returns the same empty list.
     * @param year the year to filter by.
     * @return this EmptyNode instance.
     */
    @Override
    public IListOfBooks allBefore(int year) {
        return this;
    }

    /**
     * Appends a book to the end of the list.
     * Adding to an empty list results in a single-element list.
     * @param book the book to add to the end.
     * @return a new ElementNode containing the book and this empty node as its rest.
     */
    @Override
    public IListOfBooks addAtEnd(Book book) {
        return new ElementNode(book, this);
    }

    /**
     * Returns an empty string representing the contents of an empty list.
     * @return an empty string.
     */
    @Override
    public String toString() {
        return "";
    }
}