public class Program1 {
    // This method accepts an Object array, allowing it to handle any reference type
    public static void printArray(Object[] array) {
        for (Object element : array) {
            System.out.print(element + " ");
        }
        System.out.println(); // New line after printing all elements
    }

    public static void main(String[] args) {
        // Initializing wrapper class arrays
        Integer[] intArry = {1, 2, 3, 4, 5};
        Double[] doubArry = {1.1, 2.2, 3.3, 4.4};
        Character[] charArry = {'H', 'E', 'L', 'L', 'O'};
        String[] strArry = {"once", "upon", "a", "time"};

        System.out.println("Object Array output:");
        printArray(intArry);
        printArray(doubArry);
        printArray(charArry);
        printArray(strArry);
    }
}