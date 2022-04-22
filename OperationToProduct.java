import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class OperationToProduct {

    /**
     * Tìm kiếm index của sản phẩm
     * 
     * @param p    sản phẩm cần tìm kiếm
     * @param list linked list của sản phẩm
     * @return index của sản phẩm đã được tìm kiếm, nếu không thấy trả về -1
     */

    public int index(Product p, MyList<Product> list) {
        int index = 0;
        Node<Product> current = list.head;
        while (current != null) {
            if (current.info == p) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    /**
     * Tạo sản phẩm mới
     * 
     * @param input cho phép nhập dữ liệu từ bàn phím và lưu vào
     * @return trả về sản phẩm mới đã được tạo
     */

    public static Product createProduct(Scanner input) {
        System.out.print("Input new ID: ");
        String bcode = input.next();
        System.out.print("Input Product's Name: ");
        input.nextLine();
        String title = input.nextLine();
        System.out.print("Input Product's Quantity: ");
        int quantity = input.nextInt();
        System.out.print("Input Product's Price: ");
        double price = input.nextDouble();
        Product newProduct = new Product(bcode, title, quantity, price);
        return newProduct;
    }

    /**
     * Đọc dữ liệu từ file text và lưu vào linked list của sản phẩm
     * 
     * @param fileName tên file dùng để đọc dữ liệu
     * @param list     linked list của sản phẩm
     */

    public static void getAllItemsFromFileSaveToList(String fileName, MyList<Product> list) {
        try {
            // Tạo luồng dữ liệu đầu vào để đọc file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            // Đọc file và lưu dữ liệu vào linked list
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Product product = new Product(row[0], row[1], Integer.parseInt(row[2]), Double.parseDouble(row[3]));
                list.insertToTail(product);
            }
            // Đóng luồng
            reader.close();
            System.out.println("Successfully !");
        } catch (Exception e) {
            System.out.println("Error !");
        }
    }

    /**
     * Lưu dữ liệu từ linked list vào file text
     * 
     * @param fileName tên file dùng để lưu dữ liệu
     * @param list     linked list của sản phẩm
     */

    public static void writeAllItemsToFile(String fileName, MyList<Product> list) {
        try {
            // Tạo luồng dữ liệu đầu ra để ghi file
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            Node<Product> current = list.head;
            while (current != null) {
                // Ghi dữ liệu có trong từng Node của list
                writer.write(current.info.bcode + "," + current.info.title + "," + current.info.quantity + ","
                        + current.info.price);
                // Ghi tất cả dữ liệu trong bộ nhớ đệm vào tệp đích
                writer.flush();
                // Ghi một dòng mới
                writer.newLine();
                current = current.next;
            }
            writer.close();
            System.out.println("Successfully ! Product has been saved to " + fileName);
        } catch (Exception e) {
            System.out.println("Error !");
        }
    }

    /**
     * Đọc dữ liệu từ file text và lưu vào stack
     * 
     * @param fileName tên file dùng để đọc dữ liệu
     * @param stack    stack của sản phẩm
     */

    public static void getAllItemsFromFileSaveToStack(String fileName, MyStack<Product> stack) {
        try {
            // Tạo luồng liên kết dữ liệu đầu vào để đọc file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                // Tạo sản phẩm mới
                Product product = new Product(row[0], row[1], Integer.parseInt(row[2]), Double.parseDouble(row[3]));
                // Thêm sản phẩm vào đầu stack
                stack.push(product);
            }
            reader.close();
            System.out.println("Successfully !");
        } catch (Exception e) {
            System.out.println("Error !");
        }
    }

    /**
     * Đọc dữ liệu từ file text và lưu vào Queue
     * 
     * @param fileName tên file dùng để đọc dữ liệu
     * @param queue    queue của sản phẩm
     */

    public static void getAllItemsFromFileSaveToQueue(String fileName, MyQueue<Product> queue) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Product product = new Product(row[0], row[1], Integer.parseInt(row[2]), Double.parseDouble(row[3]));
                queue.enqueue(product);
            }
            reader.close();
            System.out.println("Successfully !");
        } catch (Exception e) {
            System.out.println("Error !");
        }
    }

    /**
     * Thêm sản phẩm vào cuối linked list
     * 
     * @param list  linked list của sản phẩm
     * @param input nhập thông tin sản phẩm từ bàn phím
     */

    public static void addLast(MyList<Product> list, Scanner input) {
        Product newProduct = createProduct(input);
        list.insertToTail(newProduct);
    }

    /**
     * Hiển thị linked list của sản phẩm
     * 
     * @param list linked list của sản phẩm
     */

    public static void displayAllList(MyList<Product> list) {
        if (list.isEmpty())
            return;
        System.out.println(String.format("|%-7s|%-12s|%9s|%8s|", "ID", "Title", "Quantity", "Price"));
        System.out.println(String.format("%s", "-----------------------------------------"));
        Node<Product> current = list.head;
        while (current != null) {
            System.out.println(current.info.toString());
            current = current.next;
        }
    }

    /**
     * Hiển thị stack của sản phẩm
     * 
     * @param stack stack của sản phẩm
     */

    public static void displayAllStack(MyStack<Product> stack) {
        if (stack.isEmpty())
            return;
        System.out.println(String.format("|%-7s|%-12s|%9s|%8s|", "ID", "Title", "Quantity", "Price"));
        System.out.println(String.format("%s", "-----------------------------------------"));
        while (!(stack.isEmpty())) {
            System.out.println(stack.pop().toString());
        }
    }

    /**
     * Hiển thị queue của sản phẩm
     * 
     * @param queue queue của sản phẩm
     * @throws Exception Exception của method dequeue()
     */

    public static void displayAllQueue(MyQueue<Product> queue) throws Exception {
        if (queue.isEmpty())
            return;
        System.out.println(String.format("|%-7s|%-12s|%9s|%8s|", "ID", "Title", "Quantity", "Price"));
        System.out.println(String.format("%s", "-----------------------------------------"));
        while (!(queue.isEmpty())) {
            System.out.println(queue.dequeue().toString());
        }
    }

    /**
     * Tìm kiếm theo ID của sản phẩm
     * 
     * @param list  linked list của sản phẩm
     * @param input nhập thông tin từ bàn phím
     */

    public static void searchByCode(MyList<Product> list, Scanner input) {
        System.out.print("Input the ID to search: ");
        String bcodeInput = input.next();
        Node<Product> current = list.head;
        while (current != null) {
            if (current.info.bcode.equalsIgnoreCase(bcodeInput)) {
                System.out.println(current.toString());
                return;
            }
            current = current.next;
        }
        System.out.println("Not found product !");
    }

    /**
     * Tìm kiếm ID và xóa sản phẩm trong linked list
     * 
     * @param list  linked list của sản phẩm
     * @param input nhập thông tin từ bàn phím
     */

    public static void deleteByCode(MyList<Product> list, Scanner input) {
        System.out.print("Input the ID to delete: ");
        String bcodeInput = input.next();
        Node<Product> current = list.head;
        while (current != null) {
            if (current.info.bcode.equalsIgnoreCase(bcodeInput)) {
                list.deleteElement(current.info);
                System.out.println("Deleted the product !");
                return;
            }
            current = current.next;
        }
    }

    /**
     * Sắp xếp sản phẩm theo ID
     * 
     * @param list linked list của sản phẩm
     */

    public static void sortByCode(MyList<Product> list) {
        if (list.isEmpty())
            return;
        // Hàm sắp xếp sản phẩm
        selectionSortByCode(list, list.head);
        System.out.println("List Product is sorted !");
    }

    /**
     * Sắp xếp sản phẩm sử dụng thuật toán selectionSort
     * 
     * @param list linked list của sản phẩm
     * @param i    duyệt từng node trong linked list
     */

    public static void selectionSortByCode(MyList<Product> list, Node<Product> i) {
        if (i == list.tail)
            return;
        Node<Product> minPosition = i;
        for (Node<Product> j = i.next; j != null; j = j.next) {
            if (j.info.bcode.compareToIgnoreCase(minPosition.info.bcode) < 0) {
                minPosition = j;
            }
        }
        Product temp = minPosition.info;
        minPosition.info = i.info;
        i.info = temp;
        selectionSortByCode(list, i.next);
    }

    /**
     * Thêm sản phẩm vào đầu linked list
     * 
     * @param list  linked list của sản phẩm
     * @param input nhập thông tin từ bàn phím
     */

    public void addFirst(MyList<Product> list, Scanner input) {
        Product newProduct = createProduct(input);
        list.insertToHead(newProduct);
    }

    /**
     * Chuyển decimal sang Binary
     * 
     * @param decimalNumber số thập phân
     * @return số nhị phân đã được chuyển đổi
     */

    public static int convertToBinary(int decimalNumber) {
        int remainder = decimalNumber % 2;
        if (decimalNumber == 0) {
            return 0;
        }
        return remainder + 10 * convertToBinary(decimalNumber / 2);
    }

    /**
     * Xóa sản phẩm tại vị trí nào đó
     * 
     * @param list linked list của sản phẩm
     * @param pos  vị trí cần xóa
     */

    public void deleteAtPosition(MyList<Product> list, int pos) {
        list.deleteAtPosition(pos);
    }
}
