public class Program4 {
    // This method accepts an array of elements that implement the Comparable interface
    public static Comparable getMax(Comparable[] anArray) {
        if (anArray == null || anArray.length == 0) return null;

        // Start by assuming the first element is the maximum
        Comparable max = anArray[0];
        for (int i = 1; i < anArray.length; i++) {
            // compareTo returns > 0 if the current element is greater than the current max
            if (anArray[i].compareTo(max) > 0) {
                max = anArray[i]; // Update the maximum
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] intArry = {1, 2, 3, 4, 5};
        Double[] doubArry = {1.1, 2.2, 3.3, 4.4};
        Character[] charArry = {'H', 'E', 'L', 'L', 'O'};
        String[] strArry = {"once", "upon", "a", "time"};

        // Outputting results by calling getMax for each different type
        System.out.println("Max Integer is: " + getMax(intArry));
        System.out.println("Max Double is: " + getMax(doubArry));
        System.out.println("Max Character is: " + getMax(charArry));
        System.out.println("Max String is: " + getMax(strArry));
    }
}