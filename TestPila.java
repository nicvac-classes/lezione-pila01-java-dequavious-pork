import java.util.Stack;

public class TestPila {

    public static boolean parentesiBilanciate(String espressione) {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < espressione.length(); i++) {
            char c = espressione.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) return false;

                char aperta = pila.pop();

                if ((c == ')' && aperta != '(') ||
                    (c == ']' && aperta != '[') ||
                    (c == '}' && aperta != '{')) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }

    public static void main(String[] args) {
        String[] test = {
            "{[()]}",
            "{[(])}",
            "((()))",
            "(]",
            "{[}",
            ""
        };

        for (String s : test) {
            System.out.println(s + " -> " + (parentesiBilanciate(s) ? "bilanciata" : "sbilanciata"));
        }
    }
}