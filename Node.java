/**
 * Generic version of the Node class
 */

public class Node<T> {
    // Thông tin của nod
    T info;
    // Node tiếp theo
    Node<T> next;

    /**
     * Hàm tạo mặc định
     */
    public Node() {
        info = null;
        next = null;
    }

    /**
     * Khởi tạo một node
     * 
     * @param info thông tin của node
     * @param next node tiếp theo
     */

    public Node(T info, Node<T> next) {
        this.info = info;
        this.next = next;
    }

    /**
     * Chuyển node về String để in ra
     */

    @Override
    public String toString() {
        return info.toString();
    }
}
