/**
 * Created by alex on 25.10.16.
 */
public class Main {
    public static void main(String[] args) {
        Stack theStack = new Stack();

        theStack.push(20);
        theStack.push(40);

        theStack.displayStack();

        theStack.push(60);
        //theStack.push(80);

        theStack.displayStack();

        theStack.pop();
        theStack.pop();

        System.out.println(theStack.isEmpty());

        theStack.displayStack();

        Queue q = new Queue();

        q.Enqueue(45);
        q.Enqueue(34);

        q.displayQueue();

        q.Enqueue(1337);

        q.displayQueue();
        q.Dequeue();

        q.displayQueue();

        System.out.println(q.isEmpty());


        System.out.println(q.Size());
    }
}
