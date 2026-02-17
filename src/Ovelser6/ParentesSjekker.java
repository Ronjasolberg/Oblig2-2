package Ovelser6;

public class ParentesSjekker {

    public static boolean sjekkParenteser(String s) {

        StabelADT<Character> stabel = new TabellStabel<>();
        char[] tegn = s.toCharArray();

        for (char c : tegn) {
            if(erStartparentes(c)) {
                stabel.push(c);
                continue;
            }
            if(erSluttparentes(c)) {
                if (stabel.isEmpty()) {
                    return false;
                } else {
                    char start = stabel.pop();
                    if (!erParentesPar(start, c)) {
                        return false;
                    }
                }

            }
        } return stabel.isEmpty();
    }

    public static boolean erStartparentes(char c) {

        return (c == '{' || c == '[' || c == '(');

    }

    public static boolean erSluttparentes(char c) {
        return (c == '}' || c == ']' || c == ')');
    }

    public static boolean erParentesPar(char start, char slutt) {
        return (start == '{' && slutt == '}' || start == '[' && slutt == ']' || start == '(' && slutt == ')');
    }

}
