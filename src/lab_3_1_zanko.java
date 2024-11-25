
import java.util.Scanner;
import java.util.StringTokenizer;// класс для разделения строк на слова



//3.Строка состоит из слов. За один просмотр символов строки найти все слова, начинающиеся с гласных букв,
// и занести их в новую строку, заменяя первую букву каждого слова на прописную. Слова в исходной строке разделяются
// некоторым множеством разделителей. Слова в новой строке должны разделяться ровно одним пробелом.

public class lab_3_1_zanko {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        // вызываем метод для поиска слов, начинающихся на гласную
        String result = find_Words(input);
        System.out.println("Результат: " + result);
    }

    public static String find_Words(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        // Используем StringTokenizer для разделения входной строки на слова по заданным разделителям
        StringTokenizer tokenizer = new StringTokenizer(input, " ,.;:!?-");

        // проходим по всем словам
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();

            // проверяем начинается ли слово с гласной буквы
            if (startsWithVowel(word)) {
                //если да, то заменяем первую букву на прописную
                String capitalizedWord = capitalizeFirstLetter(word);
                //добавляем слово в созданую ранее результитующую строк, слова разделяем одним пробелом
                resultBuilder.append(capitalizedWord).append(" ");
            }
        }

        // Преобразуем StringBuilder в строку и удаляем лишний пробел в конце
        return resultBuilder.length() > 0 ? resultBuilder.toString().trim() : "";
    }

    // метод проверки, начинается ли слово на гласную
    private static boolean startsWithVowel(String word) {
        char firstChar = Character.toLowerCase(word.charAt(0));
        // проверяем, является ли первый символ гласной буквой (два варианта либо русский язык, либо английский)
        return "aeiouаеёиоуыэюя".indexOf(firstChar) != -1; // Гласные буквы
    }

    private static String capitalizeFirstLetter(String word) {
        if (word.length() == 0) return word;
        //заменяем первую буку на прописную и добавляем остальную чвасть слова
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }
}