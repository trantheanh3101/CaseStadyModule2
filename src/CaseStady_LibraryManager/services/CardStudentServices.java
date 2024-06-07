package CaseStady_LibraryManager.services;

import CaseStady_LibraryManager.model.CardStudent;
import CaseStady_LibraryManager.repository.CardStudentManager;
import CaseStady_LibraryManager.repository.DocumentManager;
import CaseStady_LibraryManager.view.LibraryView;

public class CardStudentServices {
    private CardStudentManager cardStudentManager;
    private DocumentManager documentManager;

    public CardStudentServices(){
        cardStudentManager = new CardStudentManager();
        documentManager = new DocumentManager();
    }

    public void addCardStudent(LibraryView libraryView) {
        CardStudent cardStudent = libraryView.getDetailCardStudent();
        cardStudentManager.addCardStudent(cardStudent);
        documentManager.updateDocument(cardStudent.getDocument().getDocumentCode(),cardStudent.getDocument().getQuantity());
        libraryView.getMessgerOK();
    }
}
