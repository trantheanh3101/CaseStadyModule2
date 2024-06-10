package CaseStady_LibraryManager.view;

import CaseStady_LibraryManager.model.CardStudent;
import CaseStady_LibraryManager.model.Document;
import CaseStady_LibraryManager.model.Student;
import CaseStady_LibraryManager.services.CardStudentServices;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LibraryView {
    Scanner scanner = new Scanner(System.in);

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

    public CardStudent getDetailCardStudent(Set<CardStudent> cardStudents) {
        String cardCode = "";
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("Nhập mã thẻ: ");
                cardCode = scanner.nextLine();
                if (cardCode.isEmpty() || !cardCode.matches("[A-Za-z0-9]+")) {
                    throw new IllegalArgumentException("Mã thẻ không hợp lệ. Vui lòng nhập lại.");
                }
                String finalCardCode = cardCode;
                boolean exists = cardStudents.stream().anyMatch(cardStudent -> cardStudent.getCardCode().equals(finalCardCode));
                if (exists) {
                    throw new IllegalArgumentException("Mã thẻ đã tồn tại. Vui lòng nhập mã khác.");
                }

                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Enter borrowDay: ");
        int borrowDay = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter returnDay: ");
        int returnDay = Integer.parseInt(scanner.nextLine());

        Set<Document> documents = new HashSet<>();
        while (true) {
            System.out.print("Enter documentCode (or press Enter to finish): ");
            String documentCode = scanner.nextLine();
            if (documentCode.isEmpty()) {
                break;
            }
            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            documents.add(new Document(documentCode, quantity));
        }

        System.out.println("Enter studentID: ");
        String studentID = scanner.nextLine();
        System.out.println("Enter studentName: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter studentAge: ");
        int studentAge = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter studentClass: ");
        String studentClass = scanner.nextLine();
        Student student = new Student(studentID, studentName, studentAge, studentClass);

        return new CardStudent(cardCode, borrowDay, returnDay, documents, student);
    }

    public void getMessDisplay() {
        System.out.println("het sach");
    }

    public void getMessgerNG() {
        System.out.println("that bai");
    }

    public String getCardCode() {
        System.out.println("Enter cardCode: ");
        return scanner.nextLine();
    }

    public String getDocumentCode() {
        System.out.println("Enter documentCode: ");
        return scanner.nextLine();
    }
}
