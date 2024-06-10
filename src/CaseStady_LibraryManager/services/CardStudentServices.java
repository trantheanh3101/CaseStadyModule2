package CaseStady_LibraryManager.services;

import CaseStady_LibraryManager.model.CardStudent;
import CaseStady_LibraryManager.model.Document;
import CaseStady_LibraryManager.repository.CardStudentManager;
import CaseStady_LibraryManager.repository.DocumentManager;
import CaseStady_LibraryManager.view.LibraryView;

import java.util.Set;

public class CardStudentServices {
    private final CardStudentManager cardStudentManager;
    private final DocumentManager documentManager;

    public CardStudentServices(){
        cardStudentManager = new CardStudentManager();
        documentManager = new DocumentManager();
    }

    public void addCardStudent(LibraryView libraryView) {
        CardStudent cardStudent = libraryView.getDetailCardStudent();
        cardStudentManager.addCardStudent(cardStudent);
        for (Document document : cardStudent.getDocuments()) {
            documentManager.updateDocument(document.getDocumentCode(), document.getQuantity());
        }
        libraryView.getMessgerOK();
    }

    public void displayAllCardStudent() {
        Set<CardStudent> cardStudents = CardStudentManager.getAllCardStudents();
        for (CardStudent cardStudent : cardStudents) {
            System.out.println(cardStudent);
        }
    }

    public void deleteCardStudent(LibraryView libraryView) {
        Set<CardStudent> cardStudents = CardStudentManager.getAllCardStudents();
        String cardCode = libraryView.getCardCode();
        boolean exists = cardStudents.stream().anyMatch(cardStudent -> cardCode.equals(cardStudent.getCardCode()));
        if (exists) {
            cardStudentManager.deleteCardStudent(cardCode);
            libraryView.getMessgerOK();
        } else
            libraryView.getMessgerNG();
    }

    public void SearchCardStudentByCodeCard(LibraryView libraryView) {
        Set<CardStudent> cardStudents = CardStudentManager.getAllCardStudents();
        String cardCode = libraryView.getCardCode();
        for (CardStudent cardStudent : cardStudents){
            if (cardStudent.getCardCode().equals(cardCode)) {
                System.out.println(cardStudent);
                break;
            }
            else {
                libraryView.getMessgerNG();
            }
        }
    }
}
