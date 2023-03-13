import java.util.Arrays;
import java.util.LinkedList;

// Пусть дан LinkedList с несколькими элементами. 
// Реализуйте метод(не void), который вернет “перевернутый” список.

public class task4_1 {
    public static void main(String[] args) {
        LinkedList<String> mylist = new LinkedList<>(Arrays.asList("Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун"));
        System.out.print("Исходный LinkedList: ");
        System.out.println(mylist);
        LinkedList<String> newlist = flippedList(mylist);
        System.out.print("LinkedList в обратном порядке: ");
        System.out.println(newlist);
        
    }

    public static LinkedList<String> flippedList(LinkedList<String> ls) {
        LinkedList<String> flipList = new LinkedList<>();
        for (int i = 0; i < ls.size(); i++) {
            flipList.addFirst(ls.get(i));
        }
        return flipList;
    }
}
