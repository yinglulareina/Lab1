public class Program3 {
    // Generic method: <T> is a type placeholder determined at runtime
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArry = {1, 2, 3, 4, 5};
        Double[] doubArry = {1.1, 2.2, 3.3, 4.4};
        Character[] charArry = {'H', 'E', 'L', 'L', 'O'};
        String[] strArry = {"once", "upon", "a", "time"};

        System.out.println("Generic Method output:");
        printArray(intArry);
        printArray(doubArry);
        printArray(charArry);
        printArray(strArry);
    }
}