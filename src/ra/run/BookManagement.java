package ra.run;

import java.lang.reflect.Constructor;
import java.util.*;

import ra.bussinessIMPL.Book;
import ra.bussinessIMPL.Author;

public class BookManagement {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("     JAVA-HACKTHON-05-AVANCE-1-MENU     ");
            System.out.println("Chon 1 nhập số tác giả và nhập thông tin tác giả");
            System.out.println("Chon 2 nhập số sách và thông tin các sách");
            System.out.println("Chon 3 sắp xếp theo giá sách tăng dần");
            System.out.println("Chon 4 tìm kiếm sách theo tên tác giả ");
            System.out.println("Chon 5 Thoát ");
            System.out.print("Mời chọn lựa : ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addAuthor();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    sortPriceBookASC();
                    break;
                case 4:
                    searchBookByAuthor();
                    break;
                case 5:
                    System.err.println("Goodbye!!!");
                    return;
                default:
                    System.err.println("Chỉ được nhập (1/2/3/4/5)");
                    break;
            }
        }

    }

    private static void searchBookByAuthor() {
        System.out.print("Nhập vào tên tác giả: ");
        boolean check = false;
        String name = sc.nextLine();


        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getAuthor().getAuthorName().equalsIgnoreCase(name)) {
                bookList.get(i).displayData();
                check = true;
            }
            }
        if (!check) {
            System.out.println("Không tìm thấy tác giả");

        }
    }


    private static void sortPriceBookASC() {
        Collections.sort(bookList);
        System.out.println(" THÔNG TIN SÁCH ");
        System.out.printf("%-10s%-30s%-30s%-15s%-10s%-10s\n", "Mã Sách", "Tên Sách", "Tên TG", "Giá Bán", "Số Lượng", "Trạng Thái");
        for (Book book : bookList) {
            book.displayData();
        }
    }

    public static List<Author> authorList = new ArrayList<>();
    public static List<Book> bookList = new ArrayList<>();

    private static void addBook() {
        System.out.print("Nhập số sách cần nhập: ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= count; i++) {
            System.out.println("Cuốn sách thứ " + i + ": ");
            Book book = new Book();
            book.inputData();
            bookList.add(book);
        }
        System.out.println(" THÔNG TIN SÁCH ");
        System.out.printf("%-10s%-30s%-30s%-15s%-10s%-10s\n", "Mã Sách", "Tên Sách", "Tên TG", "Giá Bán", "Số Lượng", "Trạng Thái");
        for (Book book : bookList) {
            book.displayData();
        }
    }

    private static void addAuthor() {
        System.out.print("Nhập sô tác giả cần nhập: ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= count; i++) {
            System.out.println("Tác gải thứ " + i + ": ");
            Author author = new Author();
            author.inputData();
            authorList.add(author);
        }
    }

}


