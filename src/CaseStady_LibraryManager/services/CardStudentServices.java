package CaseStady_LibraryManager.services;

import CaseStady_LibraryManager.model.CardStudent;
import CaseStady_LibraryManager.model.Document;
import CaseStady_LibraryManager.repository.CardStudentManager;
import CaseStady_LibraryManager.repository.DocumentManager;
import CaseStady_LibraryManager.view.LibraryView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CardStudentServices {
    private final CardStudentManager cardStudentManager;
    private final DocumentManager documentManager;
    private final LibraryView libraryView;

    public CardStudentServices(){
        this.libraryView = new LibraryView();
        this.cardStudentManager = new CardStudentManager();
        this.documentManager = new DocumentManager();
    }

    public void addCardStudent(LibraryView libraryView) {
        Set<CardStudent> cardStudents = CardStudentManager.getAllCardStudents();
        CardStudent cardStudent = libraryView.getDetailCardStudent(cardStudents);
        cardStudentManager.addCardStudent(cardStudent);
        for (Document document : cardStudent.getDocuments()) {
            documentManager.updateDocument(document.getDocumentCode(), document.getQuantity());
        }
        libraryView.getMessgerOK();
    }

    public void displayAllCardStudent() {
        List<CardStudent> cardStudents = new ArrayList<>(CardStudentManager.getAllCardStudents());
        Collections.sort(cardStudents);
        if (!cardStudents.isEmpty()){
            for (CardStudent cardStudent : cardStudents) {
                System.out.println(cardStudent);
            }
        } else {
            libraryView.getMessgerOK();
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
            if (checkCodeCard(cardCode)) {
                System.out.println(cardStudent);
                break;
            } else {
                libraryView.getMessgerNG();
            }
        }
    }

    public boolean checkCodeCard(String cardCode) {
        Set<CardStudent> cardStudents = CardStudentManager.getAllCardStudents();
        return cardStudents.stream().anyMatch(cardStudent -> cardStudent.getCardCode().equals(cardCode));
    }
}
