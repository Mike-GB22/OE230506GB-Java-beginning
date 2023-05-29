import java.util.LinkedList;
import java.util.List;

public class DZ2_MyQueue<E> {
    public static final String TASK = """
            2023/05/29 mip
            Семинар 4. Домашняя Задача №2

            Реализуйте очередь с помощью LinkedList со следующими методами:
            enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
            """;

    private LinkedList<E> queueList = new LinkedList<E>();

    public static void main(String[] args) {
        System.out.println(TASK);

        DZ2_MyQueue<Integer> myQueue = new DZ2_MyQueue();

        for (int i = 0; i < 10; i++) {
            myQueue.enqueue(i);
        }

        System.out.println("Заполнили очередь: " + myQueue);
        System.out.println("Извлекаем элементы по очереди: ");

        while (!myQueue.isEmpty()){
            System.out.println("Извлекли: " + myQueue.dequeue());
        }


    }

    public E first(){
        if(queueList.size() == 0) throw new IndexOutOfBoundsException();
        return queueList.get(0);
    }

    public E dequeue() {
        if (queueList.size() == 0) throw new IndexOutOfBoundsException();
        return queueList.pollFirst();
    }

    public void enqueue(E element) {
        queueList.add(element);
    }

    public int size(){
        return queueList.size();
    }

    public boolean isEmpty(){
        if(queueList.size() == 0) return true;
        return false;
    }

    public void empty(){
        queueList.clear();
    }

    @Override
    public String toString() {
        return queueList.toString();
    }
}
