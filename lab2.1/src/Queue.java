class Queue {
    private List list;

    Queue() {
        list = new List();
    }

    void Enqueue(long j) {
        list.insertFirst(j);
    }

    long Dequeue() {
        return (list.deleteLast());
    }

    boolean isEmpty() {
        return (list.isEmpty());
    }

    void displayQueue() {
        System.out.print("Queue: ");
        list.displayList();
    }

    int Size() {
        return list.calc();
    }
}
