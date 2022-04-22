/**
 * Product class
 */

public class Product {
    String bcode;
    String title;
    Integer quantity;
    Double price;

    /**
     * Hàm tạo mặc định
     */
    public Product() {
        bcode = null;
        title = null;
        quantity = null;
        price = null;
    }

    /**
     * Khởi tạo một sản phẩm
     * 
     * @param bcode    ID của sản phẩm
     * @param title    tên sản phẩm
     * @param quantity số lượng sản phẩm
     * @param price    giá sản phẩm
     */

    public Product(String bcode, String title, Integer quantity, Double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Chuyển sản phẩm sang String để in ra
     */

    @Override
    public String toString() {
        return String.format("|%-7s|%-12s|%9d|%8.1f|", bcode, title, quantity, price);
    }

}
