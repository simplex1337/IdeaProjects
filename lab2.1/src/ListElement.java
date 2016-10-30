/**
 * Created by alex on 30.10.16.
 */
class ListElement {
    long data;

    ListElement next;

    ListElement (long d) {
        data = d;
    }

    void displayListEl() {
        System.out.print(data + " ");
    }
}
