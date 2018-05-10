import java.util.*;

public class posfixa {

    public static void main(String args[]) {

        String infixa = "95+2-";

        System.out.println("Infixa : " + infixa);
        System.out.println("Posfixa : " + inf2posf(infixa));

    }

    private static String inf2posf(String infixa) {

        String posfixa = "";
        Stack<Character> operator = new Stack<Character>();
        char pop;

        for (int i = 0; i < infixa.length(); i++) {

            char get = infixa.charAt(i);

            if (!isOperator(get))
                posfixa += get;

            else if (get == ')')
                while ((pop = operator.pop()) != '(')
                    posfixa += pop;

            else {
                while (!operator.isEmpty() && get != '(' && precedente(operator.peek()) >= precedente(get))
                    posfixa += operator.pop();

                operator.push(get);
            }
        }
        // pop any remaining operator
        while (!operator.isEmpty())
            posfixa += operator.pop();

        return posfixa;
    }

    private static boolean isOperator(char i) {
        return precedente(i) > 0;
    }

    private static int precedente(char i) {

        if (i == '(' || i == ')') return 1;
        else if (i == '-' || i == '+') return 2;
        else if (i == '*' || i == '/') return 3;
        else return 0;
    }
}
