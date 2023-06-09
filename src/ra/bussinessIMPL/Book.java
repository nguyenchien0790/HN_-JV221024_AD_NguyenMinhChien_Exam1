package ra.bussinessIMPL;

import ra.bussiness.IShop;
import ra.run.BookManagement;

public class Book implements IShop,Comparable<Book>{

    int bookId;
    String bookName;
    String title;
    int numberOfPages;
    Author author;
    float importPrice;
    float exportPrice;
    int quantity;
    Boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, Author author, float importPrice, float exportPrice, int quantity, Boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {

        this.bookId = Integer.parseInt(this.getInput("Nhập mã sách: "));
        this.title = this.getInput("Nhập tiêu đề sách: ");
        this.bookName = this.getInput("Nhập tên sách: ");
        this.numberOfPages = Integer.parseInt(this.getInput("Nhập số trang của sách: "));
        this.importPrice = Float.parseFloat(this.getInput("Nhập giá nhập: "));
        this.quantity = Integer.parseInt(this.getInput("Nhập số lượng sách: "));
        this.bookStatus = Boolean.parseBoolean(this.getInput("Nhập tình trạng sách: "));
        this.exportPrice = this.importPrice * RATE;

        for (int i = 0; i < BookManagement.authorList.size(); i++) {
            System.out.print(i + 1 + ": ");
            BookManagement.authorList.get(i).displayData();
        }

        System.out.println("Mời chọn tác giả : ");
        int choice = Integer.parseInt(sc.nextLine());
        this.author = BookManagement.authorList.get(choice - 1);
    }

    @Override
    public void displayData() {
        System.out.printf("%-10d%-30s%-30s%-15f%-10d%-10b\n",this.bookId,this.bookName,author.getAuthorName(),
                this.importPrice,this.quantity,this.bookStatus);
    }

    public String getInput(String title) {
        System.out.println(title);
        String input = "";
        do {
            input = sc.nextLine();
        } while (input.trim() == "");
        return input;
    }


    @Override
    public int compareTo(Book o) {
        return (int) (this.exportPrice - o.exportPrice);
    }
}
