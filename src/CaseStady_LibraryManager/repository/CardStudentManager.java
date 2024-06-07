package CaseStady_LibraryManager.repository;

import CaseStady_LibraryManager.model.CardStudent;
import CaseStady_LibraryManager.model.Document;
import CaseStady_LibraryManager.model.Student;

import java.io.*;
import java.util.ArrayList;

public class CardStudentManager {
    private static final String FILECARDSTUDENT_PATH = "C:\\Users\\admin\\Desktop\\TheanhCode\\CaseStadyModule2\\src\\CaseStady_LibraryManager\\repository\\CardStudentManager.csv";

    public static ArrayList<CardStudent> getAllCardStudens() {
        ArrayList<CardStudent> cardStudents = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILECARDSTUDENT_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length == 9) {
                    Document document = new Document(attributes[3], Integer.parseInt(attributes[4]));
                    Student student = new Student(attributes[5], attributes[6], Integer.parseInt(attributes[7]), attributes[8]);
                    CardStudent cardStudent = new CardStudent(attributes[0], Integer.parseInt(attributes[1]), Integer.parseInt(attributes[2]), document, student);
                    cardStudents.add(cardStudent);
                }
            }
        } catch (FileNotFoundException e) {
            // File not found, return empty list
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cardStudents;
    }

    private void saveAllCardStudent(ArrayList<CardStudent> cardStudents) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILECARDSTUDENT_PATH))){
            for (CardStudent cardStudent : cardStudents){
                bw.write(cardStudent.getCardCode() + "," + cardStudent.getBorrowDay() + "," + cardStudent.getReturnDay() + "," + cardStudent.getDocument() + "," + cardStudent.getStudent());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCardStudent(CardStudent cardStudent) {
        ArrayList<CardStudent> cardStudents = CardStudentManager.getAllCardStudens();
        cardStudents.add(cardStudent);
        saveAllCardStudent(cardStudents);
    }
}
