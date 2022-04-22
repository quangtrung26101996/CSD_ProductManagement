/**
 * Generic version of the Queue class
 * 
 * @param <T> the type of the value
 */
public class MyQueue<T> {
    // Node head
    Node<T> head;
    // Node tail
    Node<T> tail;

    /**
     * Hàm tạo mặc định
     */
    public MyQueue() {
        head = tail = null;
    }

    /**
     * Kiểm tra xem queue có rỗng không
     * 
     * @return true/false
     */
    boolean isEmpty() {
        return (head == null);
    }

    /**
     * Xem thông tin của node head
     * 
     * @return info của node head
     * @throws Exception ngoại lệ nếu queue trống
     */
    T front() throws Exception {
        if (isEmpty())
            throw new Exception();
        return (head.info);
    }

    /**
     * Xóa node đầu trong queue
     * 
     * @return item được xóa
     * @throws Exception ngoại lệ nếu queue trống
     */
    T dequeue() throws Exception {
        if (isEmpty())
            throw new Exception();
        T item = head.info;
        head = head.next;
        if (head == null)
            tail = null;
        return item;
    }

    /**
     * Thêm node cuối trong queue
     * 
     * @param item item được thêm
     */
    void enqueue(T item) {
        if (isEmpty()) {
            head = tail = new Node<T>(item, null);
        } else {
            tail.next = new Node<T>(item, null);
            tail = tail.next;
            // Cách viết khác:
            // Node newNode = new Node (item, null);
            // tail.next = newNode;
            // tail = newNode;
        }
    }

}
