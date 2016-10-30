/**
 * Created by alex on 30.10.16.
 */
class List {
    private ListElement head;
    private ListElement tail;

    List() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void insertFirst(long d) {
        ListElement newLink = new ListElement(d);
        if (head == null) {
            head = newLink;
            tail = newLink;
        }
        else {
            //ListElement newLink = new ListElement(d);
            newLink.next = head;
            head = newLink;
        }
    }

    long deleteFirst() {
        if (head == null)
            return 0;
        else {
            ListElement buf = head;
            head = head.next;
            return buf.data;
        }
    }

    long deleteLast() {
        if (head == null)
            return 0;
        else {
            ListElement buf = tail;
            int cc = calc();
            //System.out.println(cc);
            delElidx((cc - 1));
            return buf.data;
        }
    }

    void displayList() {
        ListElement current = head;
        while (current != null) {
            current.displayListEl();
            current = current.next;
        }
        System.out.println("");
    }

    void delElidx(int idx)          //удаление элемента
    {
        if(head == null)        //если список пуст -
            return;             //ничего не делаем

        if ((head == tail) && idx == 0) {     //если список состоит из одного искомого элемента
            head = null;        //очищаем указатели начала и конца
            tail = null;
            return;             //и выходим
        }

        if (idx == 0) {    //если первый элемент - тот, что нам нужен
            head = head.next;       //переключаем указатель начала на второй элемент
            return;                 //и выходим
        }

        ListElement t = head;       //иначе начинаем искать
        for(int i = 0; t.next != null; i++) {    //пока следующий элемент существует
            if (i == (idx - 1)) {  //проверяем не дошел ли до индекса
                if(tail == t.next)      //если он последний
                {
                    tail = t;           //то переключаем указатель хвоста на текущий
                }
                t.next = t.next.next;   //найденный элемент выкидываем
                return;                 //и выходим
            }
            t = t.next;                //иначе ищем дальше
        }
    }

    int calc() {
        int i = 0;
        ListElement t = head;
        while (t != null)
        {
            i++;
            t = t.next;
        }
        return i;
    }


}
