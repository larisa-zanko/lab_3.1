
import java.util.Scanner;
import java.util.StringTokenizer;// класс для разделения строк на слова


//3.Строка состоит из слов. За один просмотр символов строки найти все слова, начинающиеся с гласных букв,
// и занести их в новую строку, заменяя первую букву каждого слова на прописную. Слова в исходной строке разделяются
// некоторым множеством разделителей. Слова в новой строке должны разделяться ровно одним пробелом.

// Задание переделанное. Будем искать слова, которые начинаются с СОГЛАСНЫХ букв и заносить их в новую строку, заменяя первую букву каждого слова на прописную. 

public class lab_3_1_zanko {
    public static void main(String[] args) {
        String input = "привет, как дела? у меня всё хорошо. это пример строки!";
        String result = findAndCapitalizeConsonantWords(input);
        System.out.println(result);
    }

    public static String findAndCapitalizeConsonantWords(String input) {
        // Определяем согласные буквы
        String consonants = "бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ";
        StringBuilder result = new StringBuilder();
        boolean isWord = false; // Флаг для отслеживания слова
        StringBuilder currentWord = new StringBuilder(); // Для хранения текущего слова

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) { // Проверяем, является ли символ буквой
                currentWord.append(ch); // Добавляем букву к текущему слову
                isWord = true; // Устанавливаем флаг, что мы внутри слова
            } else {
                // Если символ не буква и мы находимся внутри слова
                if (isWord) {
                    if (currentWord.length() > 0 && consonants.indexOf(currentWord.charAt(0)) != -1) {
                        // Если слово начинается с согласной, добавляем его в результат
                        String capitalizedWord = Character.toUpperCase(currentWord.charAt(0)) + currentWord.substring(1);
                        if (result.length() > 0) {
                            result.append(" "); // Добавляем пробел перед следующим словом
                        }
                        result.append(capitalizedWord);
                    }
                    currentWord.setLength(0); // Очищаем текущее слово
                }
                isWord = false; // Сбрасываем флаг, так как мы вышли из слова
            }
        }

        // Обработка последнего слова, если оно есть
        if (isWord && currentWord.length() > 0 && consonants.indexOf(currentWord.charAt(0)) != -1) {
            String capitalizedWord = Character.toUpperCase(currentWord.charAt(0)) + currentWord.substring(1);
            if (result.length() > 0) {
                result.append(" "); // Добавляем пробел перед следующим словом
            }
            result.append(capitalizedWord);
        }
        return result.toString();
    }
}
