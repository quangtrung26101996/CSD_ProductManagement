import java.util.EmptyStackException;

/**
 * Generic version of the stack class
 * 
 * @param <T> the type of the value
 */
public class MyStack<T> {
    // Head node
    Node<T> head;

    /**
     * Hàm tạo mặc định
     */
    public MyStack() {
        head = null;
    }

    /**
     * Kiểm tra stack rỗng
     * 
     * @return true/false
     */
    boolean isEmpty() {
        return (head == null);
    }

    /**
     * Thêm node vào đầu stack
     * 
     * @param item item được thêm
     */
    void push(T item) {
        head = new Node<T>(item, head);
    }

    /**
     * Xem thông tin node head
     * 
     * @return info node head
     * @throws EmptyStackException ngoại lệ nếu stack rỗng
     */
    T top() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return head.info;
    }

    /**
     * Xóa node head ra khỏi stack
     * 
     * @return item node head
     * @throws EmptyStackException ngoại lệ nếu stack rỗng
     */
    T pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        T item = head.info;
        head = head.next;
        return item;
    }

}
