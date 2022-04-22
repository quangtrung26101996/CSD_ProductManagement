/**
 * Generic version of the linked list class
 * 
 * @param <T> the type of the value
 */
public class MyList<T> {
    // Head node
    Node<T> head;
    // Tail node
    Node<T> tail;

    /**
     * Hàm tạo mặc định
     */
    public MyList() {
        head = tail = null;
    }

    /**
     * Khởi tạo linked list
     * 
     * @param head node head
     * @param tail node tail
     */
    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Kiểm tra xem linked list có rỗng không
     * 
     * @return trả về true/false
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Tính độ dài của linked list
     * 
     * @return trả về độ dài linked list
     */
    public int length() {
        Node<T> current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    /**
     * Chèn vào đầu linked list
     * 
     * @param item item được chèn
     */

    public void insertToHead(T item) {
        head = new Node<T>(item, head);
    }

    /**
     * Chèn vào cuối linked list
     * 
     * @param item item được chèn
     */
    public void insertToTail(T item) {
        Node<T> newNode = new Node<T>(item, null);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        if (tail != null) {
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * Xóa node tại một vị trí
     * 
     * @param position vị trí cần xóa
     */
    public void deleteAtPosition(int position) {
        if (head == null)
            return;
        Node<T> temp = head;
        if (position == 1) {
            head = temp.next;
            return;
        }
        for (int i = 1; temp != null && i < position; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null)
            return;
        Node<T> next = temp.next.next;
        temp.next = next;
    }

    /**
     * Xóa node tail
     */
    public void deleteTail() {
        Node<T> current = head;
        for (int i = 0; i < length() - 1; i++) {
            if (current.next == tail) {
                current.next = null;
                tail = current;
                break;
            }
            current = current.next;
        }
    }

    /**
     * Xóa node chứa item
     * 
     * @param item item cần xóa
     */
    public void deleteElement(T item) {
        // Nếu phần tử cần xóa là head
        if (head.info == item) {
            head = head.next;
            return;
        }
        // Nếu phần tử cần xóa là tail
        if (tail.info == item) {
            deleteTail();
            return;
        }
        // Nếu phần tử cần xóa nằm giữa head và tail
        Node<T> current = head;
        for (int i = 0; i < length() - 2; i++) {
            if (current.next.info == item) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
    }

    /**
     * Đổi vị trí 2 node
     * 
     * @param firstNode  node cần đổi
     * @param secondNode node cần đổi
     */
    public void swap(Node<T> firstNode, Node<T> secondNode) { // có cần thay đổi cả node ko hay chỉ cần đổi info

        // Nếu 2 Node bằng nhau
        if (firstNode.info == secondNode.info) // so sánh 2 đối tượng dùng hàm equals
            return;

        // Tìm kiếm firstNode và p1
        Node<T> prevFirstNode = null, currFirstNode = head;
        while (currFirstNode != null && !(currFirstNode.info == firstNode.info)) {
            prevFirstNode = currFirstNode;
            currFirstNode = currFirstNode.next;
        }

        // Tìm kiếm secondNode và p2
        Node<T> prevSecondNode = null, currSecondNode = head;
        while (currSecondNode != null && !(currSecondNode.info == secondNode.info)) {
            prevSecondNode = currSecondNode;
            currSecondNode = currSecondNode.next;
        }

        // Nếu firstNode hoặc secondNode không có trong list
        if (currFirstNode == null || currSecondNode == null)
            return;

        // Nếu firstNode không là head, p1.next = 2 (đổi con trỏ nút p1)
        if (prevFirstNode != null)
            prevFirstNode.next = currSecondNode;
        else // Nếu first là head
            head = currSecondNode;

        // Nếu secondNode không là head, p2.next = 1 (đổi con trỏ nút p2)
        if (prevSecondNode != null)
            prevSecondNode.next = currFirstNode;
        else // Nếu second là head
            head = currFirstNode;

        // Đổi con trỏ nút 1 và nút 2 (1.next đổi thành 2.next và ngược lại)
        Node<T> temp = currFirstNode.next;
        currFirstNode.next = currSecondNode.next;
        currSecondNode.next = temp;
    }

    /**
     * Xóa toàn bộ linked list
     */
    public void clear() {
        head = tail = null;
    }
}
