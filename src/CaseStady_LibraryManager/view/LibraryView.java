package CaseStady_LibraryManager.view;

import CaseStady_LibraryManager.model.Document;

import java.util.Scanner;

public class LibraryView {
    Scanner scanner = new Scanner(System.in);


    public void displayMessage() {
        System.out.println("fill choise again!!!");
    }

    public int getMenuChoice() {
        System.out.println("---------USER----------");
        System.out.println("1.Student");
        System.out.println("2.Library Manager");
        System.out.println("0.Exit Programming");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getMenuLibraryManager() {
        System.out.println("-------LibraryManager------");
        System.out.println("1.Đăng ký sinh viên");
        System.out.println("2.Cấp thẻ mượn");
        System.out.println("3.Xóa phiếu mượn");
        System.out.println("4.Thêm phiêu mượn");
        System.out.println("5.Thêm tài liệu");
        System.out.println("6.Xoa tai liêu");
        System.out.println("7.Hiển thị thong tin the muon");
        System.out.println("8.Hiên thi thong tin sach co trong thu vien");
        System.out.println("0.Return User");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getMenuStudent() {
        System.out.println("-------Student------");
        System.out.println("1.Hiển thị thong tin the muon");
        System.out.println("2.Hiên thi thong tin sach co trong thu vien");
        System.out.println("0.Return User");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public Document getDetailDocument() {
        System.out.print("Enter documentCode: ");
        String documentCode = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        return new Document(documentCode,quantity);
    }

    public void getMessDocumentCode() {
        System.out.println("da ton tai tai lieu nay ");
    }

    public void getMessgerOK() {
        System.out.println("thanh cong");
    }
}
