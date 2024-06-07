package CaseStady_LibraryManager.view;

import CaseStady_LibraryManager.model.CardStudent;
import CaseStady_LibraryManager.model.Document;
import CaseStady_LibraryManager.model.Student;

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
        System.out.println("1.Cấp thẻ mượn");
        System.out.println("2.Xóa thẻ mượn");
        System.out.println("3.Thêm tài liệu");
        System.out.println("4.Xoa tai liêu");
        System.out.println("5.Hiển thị thong tin all the muon");
        System.out.println("6.Hiển thị thong tin the muon theo CodeCard");
        System.out.println("7.Hiên thi thong tin sach co trong thu vien");
        System.out.println("0.Return User");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getMenuStudent() {
        System.out.println("-------Student------");
        System.out.println("1.Hiển thị thong tin the muon theo CodeCard");
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

    public CardStudent getDetailCardStudent() {
        System.out.println("Enter cardCode: ");
        String cardCode = scanner.nextLine();
        System.out.print("Enter borrowDay: ");
        int borrowDay = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter returnDay: ");
        int returnDay = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter documentCode: ");
        String documentCode = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        Document document = new Document(documentCode,quantity);

        System.out.println("Enter studentID: ");
        String studentID = scanner.nextLine();
        System.out.println("Enter studentName: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter studentAge: ");
        int studentAge = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter studentClass: ");
        String studentClass = scanner.nextLine();
        Student student = new Student(studentID,studentName,studentAge,studentClass);

        return new CardStudent(cardCode,borrowDay,returnDay,document,student);
    }

    public void getMessDisplay() {
        System.out.println("het sach");
    }
}
