/**
 * This interface represents a basic subset of methods for a recursive list of books.
 */
public interface IListOfBooks {
    /**
     * Return the number of books in this list.
     * @return the size of this list
     */
    int count();

    /**
     * Return the sum of the prices of all books in this list.
     * @return the total price of the list of books
     */
    float totalPrice();

    /**
     * Return a sublist containing the books published before the given year.
     * @param year the year before which all the returned books are published
     * @return the list of all books published before the given year
     */
    IListOfBooks allBefore(int year);

    /**
     * Return an IListOfBooks obtained by appending a specified book to the end.
     * @param book an instance of Class Book
     * @return IListOfBooks the modified list
     */
    IListOfBooks addAtEnd(Book book);

    /**
     * Create and return a string that can be used to print this list.
     * @return String for printing
     */
    @Override
    String toString();
}