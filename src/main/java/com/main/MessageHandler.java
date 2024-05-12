package com.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MessageHandler {

    private static final Set<String> KeywordMedic = new HashSet<>(Arrays.asList(Dictionary.MEDIC));
    private static final Set<String> KeywordPolice = new HashSet<>(Arrays.asList(Dictionary.POLICE));
    private static final Set<String> KeywordFirefighter = new HashSet<>(Arrays.asList(Dictionary.FIREFIGHTER));

    public static boolean needMedic(String message){
        String[] words = message.split("\\s+"); // Разбиваем сообщение на слова
        for (String word : words) {
            if (KeywordMedic.contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    public static boolean needPolice(String message){
        String[] words = message.split("\\s+"); // Разбиваем сообщение на слова
        for (String word : words) {
            if (KeywordPolice.contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    public static boolean needFirefighter(String message){
        String[] words = message.split("\\s+"); // Разбиваем сообщение на слова
        for (String word : words) {
            if (KeywordFirefighter.contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
