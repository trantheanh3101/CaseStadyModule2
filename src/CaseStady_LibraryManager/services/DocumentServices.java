package CaseStady_LibraryManager.services;

import CaseStady_LibraryManager.model.Document;
import CaseStady_LibraryManager.repository.DocumentManager;
import CaseStady_LibraryManager.view.LibraryView;

import java.util.Set;

public class DocumentServices {
    private LibraryView libraryView;
    private DocumentManager documentManager;

    public DocumentServices() {
        this.documentManager = new DocumentManager();
        this.libraryView = new LibraryView();
    }

    private boolean checkCode(String documentCode) {
        Set<Document> documents = DocumentManager.getAllDocuments();
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

    public void deleteDocument(LibraryView libraryView) {
        Set<Document> documents = DocumentManager.getAllDocuments();
        String documentCode = libraryView.getDocumentCode();
        boolean exists = documents.stream().anyMatch(document -> document.getDocumentCode().equals(documentCode));
        if (exists){
            documentManager.removeDocument(documentCode);
            libraryView.getMessgerOK();
        } else {
            libraryView.getMessgerNG();
        }
    }

    public void displayAllDocument() {
        Set<Document> documents = DocumentManager.getAllDocuments();
        if (documents.isEmpty()) {
            libraryView.getMessDisplay();
        } else {
            for (Document document : documents) {
                System.out.println(document);
            }
        }
    }
}
