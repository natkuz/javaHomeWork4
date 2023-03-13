import java.util.Scanner;
import java.util.Stack;

// Реализовать простой калькулятор (+ - / *)
// Ввод числа ->
// Ввод знака ->
// Ввод числа ->
// В калькулятор добавьте возможность отменить последнюю операцию.
// Пример

// 1
// +
// 2
// ответ:
// 3

// +
// 4
// ответ:
// 7

// Отмена
// 3
// *
// 3

// ответ:
// 9

// From Postfix to Answer
// Алгоритм: поддерживать стек и сканировать постфиксное выражение слева направо
// – Если элемент является числом, вставьте его в стэк
// - Если элемент является оператором O, всплывает дважды и получить A и B соответственно. 
// Рассчитать BOA и поместите его обратно в стек
// – Когда выражение заканчивается, число в стеке окончательный ответ

// Transform Infix to Postfix
// • Наблюдение 1: порядок вычислений зависит от порядка операторов
// – Скобки должны быть добавлены в соответствии с приоритет операций.
// – Приоритет оператора * и / выше, чем операции + и –
// – Если имеется более одного равноприоритетного операторов, мы предполагаем, что левый приоритет выше правого
// • Это называется анализом слева направо.
// Алгоритм: поддерживать стек и сканировать постфиксное выражение слева направо
// - Когда получим число, выведем его
// - Когда мы получим оператор O, вытащите верх элемент в стеке, если стек не пустой, а затем вставьте (O) в стек
// – Когда выражение закончится, вытащите все 
// операторы остаются в стеке

public class task4_3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        Stack<Double> st = new Stack<>();
        Double res;
        Double num1;
        Double num2;

        while (true) {
            System.out.println("Введите оператор (+, -, *, /) или 'cancel' для отмены последней операции или 'stop' для выхода: ");
            String operator = iScanner.next();
            operator.substring(operator.length() - 1);
            if ("+-*/".contains(operator)) {
                if (st.empty()) {
                    System.out.println("Введите число 1: ");
                    num1 = iScanner.nextDouble();
                    iScanner.nextLine();
                    st.push(num1);
                    System.out.println("Введите число 2: ");
                    num2 = iScanner.nextDouble();
                    iScanner.nextLine();
                    st.push(num2);
                    res = operation(operator, num1, num2);
                    st.push(res);
                    System.out.println("Результат: " + res);
                } else if (st.size() == 1) {
                    System.out.println("Введите число: ");
                    num1 = iScanner.nextDouble();
                    iScanner.nextLine();
                    st.push(num1);
                    res = operation(operator, st.get(0), num1);
                    st.push(res);
                    System.out.println("Результат: " + res);
                    st.remove(st.get(0));
                    st.remove(st.get(0));
                } else {
                    System.out.println("Введите число: ");
                    num1 = iScanner.nextDouble();
                    iScanner.nextLine();
                    st.push(num1);
                    res = operation(operator, st.get(2), num1);
                    st.push(res);
                    System.out.println("Результат: " + res);
                    st.remove(st.get(0));
                    st.remove(st.get(0));
                }
              
            } else if (operator.equalsIgnoreCase("cancel")) {
                System.out.println("Отмена последней операции.");
                System.out.printf("Предыдущий результат: %.2f \n", st.get(0));
                st.remove(st.get(1));
                st.remove(st.get(1));
            } else if (operator.equalsIgnoreCase("stop")) {
                break;
            }
    }
    iScanner.close();
        }
    
        private static double operation(String operator, Double num1, Double num2) {
            switch (operator) {
                case "+":
                    return num1 + num2;
                case "-":
                    return num1 - num2;
                case "*":
                    return num1 * num2;
                case "/":
                    return num1 / num2;
                default:
                    throw new IllegalArgumentException("Неверный оператор: " + operator);
        }
    }
}

