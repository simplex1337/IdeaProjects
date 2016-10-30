/**
 * Created by alex on 30.10.16.
 */
class ListElement {
    long data; // data item

    ListElement next; // next link in list

    ListElement (long d) {
        data = d;
    }

    void displayListEl() {
        System.out.print(data + " ");
    }
}
