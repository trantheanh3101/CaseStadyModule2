package CaseStady_LibraryManager.services;

import CaseStady_LibraryManager.model.Document;
import CaseStady_LibraryManager.repository.DocumentManager;
import CaseStady_LibraryManager.view.LibraryView;

import java.util.ArrayList;

public class DocumentServices {
    private DocumentManager documentManager;

    public DocumentServices() {
        this.documentManager = new DocumentManager();
    }

    private boolean checkCode(String documentCode) {
        ArrayList<Document> documents = DocumentManager.getAllDocuments();
        boolean exists = documents.stream().anyMatch(document -> document.getDocumentCode() == documentCode );
        if (exists) return true;
        return false;
    }

    public void addDocument(LibraryView libraryView) {
        while (true){
            Document document = libraryView.getDetailDocument();
            if (!checkCode(document.getDocumentCode())){
                documentManager.addDocumentLibrary(document);
                libraryView.getMessgerOK();
                break;
            } else {
                libraryView.getMessDocumentCode();
            }
        }
    }


}
