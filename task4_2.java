import java.util.LinkedList;
import java.util.Scanner;


// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.

public class task4_2 {
    public static void main(String[] args) {
        LinkedList<Object> myList = new LinkedList<>();
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter element of LinkedList: ");
        String el = iScanner.next();
        
        enqueue(el, myList);
        enqueue(35, myList);
        enqueue("gjkg", myList);
        System.out.println(myList);
        Object x = dequeue(myList);
        System.out.println(x);
        System.out.println(myList);
        Object firstEl = first(myList);
        System.out.println(firstEl);
        System.out.println(myList);

        iScanner.close();
    }

    public static void enqueue(Object element, LinkedList<Object> ls) {
        ls.addLast(element);
    }

    public static Object dequeue(LinkedList<Object> ls) {
        return ls.removeFirst();
    }

    public static Object first(LinkedList<Object> ls) {
        return ls.getFirst();
    }
}
