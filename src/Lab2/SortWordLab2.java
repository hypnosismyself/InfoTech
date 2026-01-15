package Lab2;

public class SortWordLab2 {
    // Дано слово. Произвести сортировку данного слова методом пузырька с использованием индекса.

    public static void bubble_sort() {
        // Сортировка пузырьком

        String word = "Слово";
        char[] chars = word.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        System.out.print(new String(chars));
    }
}
