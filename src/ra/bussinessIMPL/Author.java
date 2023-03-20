package ra.bussinessIMPL;

import ra.bussiness.IShop;

public class Author implements IShop {
    int authorId;
    String authorName;
    Boolean sex;
    int year;

    public Author() {

    }

    public Author(int authorId, String authorName, Boolean sex, int year) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
        this.year = year;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Boolean getSex() {
        return this.sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Tác giar {Mã tác giả: %s, Tên tác giả: %s, Giới tính: %s, Năm sinh: %s}",
                this.authorId, this.authorName, this.sex ? "Nam" : "Nữ", this.year);
    }

    @Override
    public void inputData() {
        this.authorId = Integer.parseInt(this.getInput("Nhập mã tác giả: "));
        this.authorName = this.getInput("Nhập tên tác giả: ");
        this.sex = Boolean.parseBoolean(this.getInput("Nhập giới tính (true / false)? "));
        this.year = Integer.parseInt(this.getInput("Nhập năm sinh: "));
    }

    @Override
    public void displayData() {
        System.out.println(this.toString());
    }

    public String getInput(String title) {
        System.out.println(title);
        String input = "";
        do {
            input = sc.nextLine();
        } while (input.trim() == "");
        return input;
    }
}
