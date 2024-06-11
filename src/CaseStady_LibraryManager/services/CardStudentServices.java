package CaseStady_LibraryManager.services;

import CaseStady_LibraryManager.model.CardStudent;
import CaseStady_LibraryManager.model.Document;
import CaseStady_LibraryManager.repository.CardStudentManager;
import CaseStady_LibraryManager.repository.DocumentManager;
import CaseStady_LibraryManager.view.LibraryInform;
import CaseStady_LibraryManager.view.LibraryView;
import CaseStady_LibraryManager.view.MyException;

import java.util.*;

public class CardStudentServices {
    private final CardStudentManager cardStudentManager;
    private final DocumentManager documentManager;
    private final LibraryView libraryView;
    private final LibraryInform libraryInform;

    public CardStudentServices(){
        this.libraryView = new LibraryView();
        this.cardStudentManager = new CardStudentManager();
        this.documentManager = new DocumentManager();
        this.libraryInform = new LibraryInform();
    }

    public void addCardStudent(LibraryView libraryView) {
        Set<CardStudent> cardStudents = CardStudentManager.getAllCardStudents();
        Map<String,Document> documents = DocumentManager.getAllDocuments();
        CardStudent cardStudent = libraryView.getDetailCardStudent(cardStudents,documents);
        cardStudentManager.addCardStudent(cardStudent);
        for (Document document : cardStudent.getDocuments()) {
            documentManager.updateDocument(document.getDocumentCode(), document.getQuantity());
        }
        libraryInform.getMessgerOK();
    }

    public void displayAllCardStudent() {
        List<CardStudent> cardStudents = new ArrayList<>(CardStudentManager.getAllCardStudents());
        Collections.sort(cardStudents);
        if (!cardStudents.isEmpty()){
            for (CardStudent cardStudent : cardStudents) {
                System.out.println(cardStudent);
            }
        } else {
            libraryInform.getMessgerOK();
        }
    }

    public void deleteCardStudent(LibraryView libraryView) {
        Set<CardStudent> cardStudents = CardStudentManager.getAllCardStudents();
        String cardCode = libraryView.getCardCode();
        boolean exists = cardStudents.stream().anyMatch(cardStudent -> cardCode.equals(cardStudent.getCardCode()));
        if (exists) {
            cardStudentManager.deleteCardStudent(cardCode);
            libraryInform.getMessgerOK();
        } else
            libraryInform.getMessgerNG();
    }

    public void SearchCardStudentByCodeCard(LibraryView libraryView) {
        Set<CardStudent> cardStudents = CardStudentManager.getAllCardStudents();
        String cardCode = libraryView.getCardCode();
        for (CardStudent cardStudent : cardStudents){
            if (checkCodeCard(cardCode)) {
                System.out.println(cardStudent);
                break;
            } else {
                libraryInform.getMessgerNG();
            }
        }
    }

    public boolean checkCodeCard(String cardCode) {
        Set<CardStudent> cardStudents = CardStudentManager.getAllCardStudents();
        return cardStudents.stream().anyMatch(cardStudent -> cardStudent.getCardCode().equals(cardCode));
    }
}
