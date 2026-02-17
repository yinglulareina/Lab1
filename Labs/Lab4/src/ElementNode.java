/**
 * Represents a non-empty node in a recursive list of books.
 * Each node stores one Book and a reference to the remaining part of the list.
 */
public class ElementNode implements IListOfBooks {
    private final Book book;
    private final IListOfBooks rest;

    /**
     * Constructs a new ElementNode with the given book and the rest of the list.
     * @param book the book to be stored in this node.
     * @param rest the remainder of the recursive list.
     */
    public ElementNode(Book book, IListOfBooks rest) {
        this.book = book;
        this.rest = rest;
    }

    /**
     * Recursively counts the number of books in the list.
     * @return 1 (for this node) plus the count of the rest of the list.
     */
    @Override
    public int count() {
        return 1 + this.rest.count();
    }

    /**
     * Recursively calculates the total price of all books in the list.
     * @return the price of this node's book plus the total price of the rest.
     */
    @Override
    public float totalPrice() {
        return this.book.getPrice() + this.rest.totalPrice();
    }

    /**
     * Filters the list to return only books published before a specified year.
     * @param year the year to filter by.
     * @return a new list containing books that satisfy the year condition.
     */
    @Override
    public IListOfBooks allBefore(int year) {
        if (this.book.before(year)) {
            return new ElementNode(this.book, this.rest.allBefore(year));
        } else {
            return this.rest.allBefore(year);
        }
    }

    /**
     * Appends a specified book to the end of this recursive list.
     * @param book the book to append.
     * @return a new list with the book added at the very end.
     */
    @Override
    public IListOfBooks addAtEnd(Book book) {
        return new ElementNode(this.book, this.rest.addAtEnd(book));
    }

    /**
     * Generates a string representation of all books in the list.
     * @return a formatted string of books, separated by spaces.
     */
    @Override
    public String toString() {
        String currentBookStr = this.book.toString();
        String restStr = this.rest.toString();
        if (restStr.isEmpty()) {
            return currentBookStr;
        }
        return currentBookStr + " " + restStr;
    }
}