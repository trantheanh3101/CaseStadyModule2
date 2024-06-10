package CaseStady_LibraryManager.repository;

import CaseStady_LibraryManager.model.CardStudent;
import CaseStady_LibraryManager.model.Document;
import CaseStady_LibraryManager.model.Student;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class CardStudentManager {
    private static final String FILECARDSTUDENT_PATH = "C:\\Users\\admin\\Desktop\\TheanhCode\\CaseStadyModule2\\src\\CaseStady_LibraryManager\\repository\\CardStudentManager.csv";

    public static Set<CardStudent> getAllCardStudents() {
        Set<CardStudent> cardStudents = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILECARDSTUDENT_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",", 5);
                if (attributes.length == 5) {
                    String cardCode = attributes[0];
                    int borrowDay = Integer.parseInt(attributes[1]);
                    int returnDay = Integer.parseInt(attributes[2]);

                    String[] documentData = attributes[3].split(";");
                    Set<Document> documents = new HashSet<>();
                    for (String doc : documentData) {
                        String[] docAttributes = doc.split(":");
                        if (docAttributes.length == 2) {
                            documents.add(new Document(docAttributes[0], Integer.parseInt(docAttributes[1])));
                        }
                    }

                    String[] studentAttributes = attributes[4].split(":");
                    Student student = new Student(studentAttributes[0], studentAttributes[1], Integer.parseInt(studentAttributes[2]), studentAttributes[3]);

                    cardStudents.add(new CardStudent(cardCode, borrowDay, returnDay, documents, student));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException roi!!!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException roi!!!");
            e.printStackTrace();
        }
        return cardStudents;
    }

    private void saveAllCardStudents(Set<CardStudent> cardStudents) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILECARDSTUDENT_PATH))) {
            for (CardStudent cardStudent : cardStudents) {
                StringBuilder documentsBuilder = new StringBuilder();
                for (Document document : cardStudent.getDocuments()) {
                    if (documentsBuilder.length() > 0) {
                        documentsBuilder.append(";");
                    }
                    documentsBuilder.append(document.getDocumentCode()).append(":").append(document.getQuantity());
                }

                Student student = cardStudent.getStudent();
                String studentData = student.getStudentID() + ":" + student.getStudentName() + ":" + student.getStudentAge() + ":" + student.getStudentClass();

                bw.write(cardStudent.getCardCode() + "," + cardStudent.getBorrowDay() + "," + cardStudent.getReturnDay() + "," + documentsBuilder + "," + studentData);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCardStudent(CardStudent cardStudent) {
        Set<CardStudent> cardStudents = CardStudentManager.getAllCardStudents();
        cardStudents.add(cardStudent);
        saveAllCardStudents(cardStudents);
    }

    public void deleteCardStudent(String cardCode) {
        Set<CardStudent> cardStudents = CardStudentManager.getAllCardStudents();
        cardStudents.removeIf(cardStudent -> cardCode.equals(cardStudent.getCardCode()));
        saveAllCardStudents(cardStudents);
    }
}
