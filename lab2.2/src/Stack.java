class Stack {
    private List list;

    Stack() {
        list = new List();
    }

    void push(long j) {
        list.insertFirst(j);
    }

    long pop() {
        return list.deleteFirst();
    }

    public boolean isEmpty() {
        return (list.isEmpty());
    }

    void displayStack() {
        System.out.print("Stack: ");
        list.displayList();
    }
}