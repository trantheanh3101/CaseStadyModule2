package CaseStady_LibraryManager.view;

import CaseStady_LibraryManager.model.CardStudent;
import CaseStady_LibraryManager.model.Document;
import CaseStady_LibraryManager.model.Student;

import java.util.*;

public class LibraryView implements MyException{
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

    public Map<String, Document> getDetailDocument(Map<String, Document> documentMap) {
        Map<String, Document> documents = new HashMap<>(); // Khởi tạo biến documents
        while (true) {
            String documentCode = "";
            int quantity = 0;
            try {
                System.out.print("Enter documentCode (nhập exit nếu đã xong): ");
                documentCode = scanner.nextLine();
                if (documentCode.equalsIgnoreCase("exit")) break; // Thoát vòng lặp nếu nhập "exit"
                if (documentCode.isEmpty()) {
                    throw new IllegalArgumentException("Không được để trống documentCode. Vui lòng nhập lại.");
                }
                boolean existsInMap = documentMap.containsKey(documentCode);
                if (existsInMap) {
                    throw new IllegalArgumentException("Mã tài liệu đã tồn tại. Vui lòng nhập mã khác.");
                }

                System.out.print("Enter quantity: ");
                quantity = Integer.parseInt(scanner.nextLine());

                // Thêm tài liệu vào map
                documents.put(documentCode, new Document(documentCode, quantity));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            }
        }
        return documents; // Trả về map chứa các tài liệu
    }



    public CardStudent getDetailCardStudent(Set<CardStudent> cardStudents, Map<String, Document> documentMap) {
        String cardCode = "";
        int borrowDay = 0;
        int returnDay = 0;
        String documentCode = "";
        int quantity = 0;
        int studentAge = 0;
        String studentClass = "";

        // Nhập mã thẻ
        boolean validCardCode = false;
        while (!validCardCode) {
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

                validCardCode = true; // Nếu không có exception nào được ném ra, mã thẻ là hợp lệ và thoát khỏi vòng lặp
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Nhập borrowDay
        boolean validBorrowDay = false;
        while (!validBorrowDay) {
            System.out.print("Enter borrowDay: ");
            String input = scanner.nextLine();
            try {
                borrowDay = Integer.parseInt(input);
                if (borrowDay < 1 || borrowDay > 31) {
                    throw new InvalidDayException ("borrowDay phải nằm trong khoảng từ 1 đến 31.");
                } else {
                    validBorrowDay = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            } catch (InvalidDayException e) {
                System.out.println(e.getMessage());
            }
        }

        // Nhập returnDay
        boolean validReturnDay = false;
        while (!validReturnDay) {
            try {
                System.out.print("Enter returnDay: ");
                returnDay = Integer.parseInt(scanner.nextLine());
                if (returnDay < 1 || returnDay > 31) {
                    throw new InvalidDayException ("borrowDay phải nằm trong khoảng từ 1 đến 31.");
                } else {
                    validReturnDay = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            } catch (InvalidDayException e) {
                System.out.println(e.getMessage());
            }
        }

        // Nhập mã tài liệu và số lượng
        Set<Document> documents = new HashSet<>();
        while (true) {
            try {
                System.out.print("Enter documentCode (or press Enter to finish): ");
                documentCode = scanner.nextLine();
                if (documentCode.isEmpty()) {
                    break; // Kết thúc vòng lặp nếu không có mã tài liệu được nhập
                }
                boolean existsInMap = documentMap.containsKey(documentCode);
                if (!existsInMap) {
                    throw new IllegalArgumentException("Mã tài liệu không tồn tại. Vui lòng nhập mã khác.");
                }
                System.out.print("Enter quantity: ");
                quantity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            documents.add(new Document(documentCode, quantity));
        }


        // Nhập thông tin sinh viên
        String studentID;
        while (true) {
            System.out.print("Enter studentID: ");
            studentID = scanner.nextLine();
            if (studentID.isEmpty()) {
                System.out.println("Không được để trống studentID. Vui lòng nhập lại.");
            } else {
                break;
            }
        }

        String studentName;
        while (true) {
            System.out.print("Enter studentName: ");
            studentName = scanner.nextLine();
            if (studentName.isEmpty()) {
                System.out.println("Không được để trống studentName. Vui lòng nhập lại.");
            } else {
                break;
            }
        }

        boolean validStudentAge = false;
        while (!validStudentAge) {
            System.out.print("Enter studentAge: ");
            String input = scanner.nextLine();
            try {
                studentAge = Integer.parseInt(input);
                validStudentAge = true;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            }
        }

        while (true) {
            System.out.print("Enter studentClass: ");
            studentClass = scanner.nextLine();
            if (studentClass.isEmpty()) {
                System.out.println("Không được để trống studentClass. Vui lòng nhập lại.");
            } else {
                break;
            }
        }

        // Tạo đối tượng Student và trả về CardStudent
        Student student = new Student(studentID, studentName, studentAge, studentClass);
        return new CardStudent(cardCode, borrowDay, returnDay, documents, student);
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
