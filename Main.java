import java.util.Scanner;

/**
 * Product Management
 * 
 * @author Vu Quang Trung - FX14135
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int choice;
        // Tạo linked list của sản phẩm
        MyList<Product> listProduct = new MyList<Product>();
        // Tạo stack của sản phẩm
        MyStack<Product> stackProduct = new MyStack<Product>();
        // Tạo queue của sản phẩm
        MyQueue<Product> queueProduct = new MyQueue<Product>();
        // Chọn chức năng cho ứng dụng
        do {
            menu();
            System.out.print("Choose one of this options (0 - 10): ");
            choice = input.nextInt();
            System.out.println();
            switch (choice) {
                // Đọc dữ liệu từ file text và lưu vào linked list, in ra màn hình console
                case 1:
                    OperationToProduct.getAllItemsFromFileSaveToList("data.txt", listProduct);
                    OperationToProduct.displayAllList(listProduct);
                    break;
                // Thêm sản phẩm mới vào cuối linked list
                case 2:
                    OperationToProduct.addLast(listProduct, input);
                    System.out.println("New product has been saved !");
                    break;
                // Hiển thị linked list
                case 3:
                    OperationToProduct.displayAllList(listProduct);
                    break;
                // Lưu dữ liệu từ linked list vào file text
                case 4:
                    OperationToProduct.writeAllItemsToFile("data.txt", listProduct);
                    break;
                // Tìm kiếm theo ID và in ra thông tin sản phẩm
                case 5:
                    OperationToProduct.searchByCode(listProduct, input);
                    break;
                // Xóa sản phẩm theo ID
                case 6:
                    OperationToProduct.deleteByCode(listProduct, input);
                    break;
                // Sắp xếp sản phẩm theo ID
                case 7:
                    OperationToProduct.sortByCode(listProduct);
                    break;
                // Chuyển số lượng sản phẩm đầu tiên sang dạng Binary
                case 8:
                    Product firstProduct = listProduct.head.info;
                    System.out.println("Quantity of first Product is " + firstProduct.quantity);
                    System.out
                            .println("Convert to Binary: " + OperationToProduct.convertToBinary(firstProduct.quantity));
                    break;
                // Đọc dữ liệu từ file text, lưu vào stack và in ra màn hình console
                case 9:
                    OperationToProduct.getAllItemsFromFileSaveToStack("data.txt", stackProduct);
                    OperationToProduct.displayAllStack(stackProduct);
                    break;
                // Đọc dữ liệu từ file text, lưu vào queue và in ra màn hình console
                case 10:
                    OperationToProduct.getAllItemsFromFileSaveToQueue("data.txt", queueProduct);
                    OperationToProduct.displayAllQueue(queueProduct);
                    break;
                // Kết thúc chương trình
                case 0:
                    System.out.println("Tks you ! See you soon.");
                    break;
                // Lựa chọn sai chức năng, lựa chọn lại chức năng có sẵn
                default:
                    System.out.println("Invalid choice ! Try again.");
                    break;
            }
        } while (choice != 0);
        input.close();
    }

    /**
     * Hiển thị menu chức năng ứng dụng
     */

    public static void menu() {
        System.out.println();
        System.out.println("Product list:");
        System.out.println("1.  Load data from file and display");
        System.out.println("2.  Input and add to the end");
        System.out.println("3.  Display data");
        System.out.println("4.  Save product list to file");
        System.out.println("5.  Search by ID");
        System.out.println("6.  Delete by ID");
        System.out.println("7.  Sort by ID");
        System.out.println("8.  Convert to Binary");
        System.out.println("9.  Load to stack and display");
        System.out.println("10. Load to queue and display");
        System.out.println("0.  Exit");
    }
}
