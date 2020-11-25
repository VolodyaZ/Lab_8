package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface RegExTasks {
    /**
     * In it, you must fix the whitespace in a sentence or paragraph;
     * before, there could be multiple spaces or tabs between two words.
     * You must write a regex such that the final string has one space between words,
     * and two spaces after full stops (hint; there will never be a tab following a full stop).
     * New lines should be left alone.
     * @param s - string to modify
     * @return modified string
     */
    public static String var1(String s) {
        return s.replaceAll("(?<=\\. )\\s*|(?<=\\w)\\s+", " ");
    }

    /**
     * The seventh regex tuesday challenge is to match valid domain names with protocols (http and https)
     * in front of them and an optional slash (/) behind them.
     * To keep it simple, you do not have to worry about special characters.
     * @param s input domain name
     * @return is s valid domain name
     */
    public static boolean var3(String s) {
        return s.matches("^https?:\\/\\/((([^\\-\\.][a-zA-Z0-9\\-]{0,50}[^\\-\\.])|\\w)\\.){1,50}(([^\\-\\.][a-zA-Z0-9\\-]{0,50}[^\\-\\.])|\\w)\\/?$");
    }

    /**
     * turn a sentence into a number of "tokens"
     *
     * The four criteria are as follows:
     *     If words are in quotes, treat them as a single separate token:
     *     eg "This "huge test" is pointless" would be changed to "this,huge test,is,pointless".
     *     This applies to both single quotes and double quotes.
     *
     *     Hyphenated last names (such as "Smith-Hopper") should be a single token, but words with more hyphens,
     *     or hyphens at the beginning or end of the word,
     *     should have the hyphens stripped and be treated as separate tokens:
     *     "Suzie Smith-Hopper test--hyphens" should be changed to "Suzie,Smith-Hopper,test,hyphens".
     *
     *     Contractions should be treated as a single token; "I can't do it" would be changed to "I,can't,do,it".
     *
     *     Punctuation should be removed (but not hyphens and quotes as above); "Too long; didn't read" would turn into "Too,long,didn't,read".
     * @param s
     * @return string of tikens divided by ','
     */
    public  static String var12(String s) {
        Matcher matcher = Pattern.compile("(?<= [\"']|^['\"]).*?(?=[\"'] |[\"']$)|([\\w]+-?[\\w]*'?[\\w]+)|\\w")
                .matcher(s);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group()).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
