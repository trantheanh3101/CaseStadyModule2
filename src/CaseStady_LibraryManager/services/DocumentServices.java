package CaseStady_LibraryManager.services;

import CaseStady_LibraryManager.model.Document;
import CaseStady_LibraryManager.repository.DocumentManager;
import CaseStady_LibraryManager.view.LibraryView;

import java.util.*;

public class DocumentServices {
    private LibraryView libraryView;
    private DocumentManager documentManager;

    public DocumentServices() {
        this.documentManager = new DocumentManager();
        this.libraryView = new LibraryView();
    }

    private boolean checkCode(String documentCode) {
        Map<String, Document> documents = DocumentManager.getAllDocuments();
        return documents.containsKey(documentCode);
    }

    public void addDocument(LibraryView libraryView) {
        while (true) {
            Document document = libraryView.getDetailDocument();
            if (!checkCode(document.getDocumentCode())) {
                documentManager.addDocumentLibrary(document);
                libraryView.getMessgerOK();
                break;
            } else {
                libraryView.getMessDocumentCode();
            }
        }
    }

    public void deleteDocument(LibraryView libraryView) {
        Map<String, Document> documents = DocumentManager.getAllDocuments();
        String documentCode = libraryView.getDocumentCode();
        if (documents.containsKey(documentCode)) {
            documentManager.removeDocument(documentCode);
            libraryView.getMessgerOK();
        } else {
            libraryView.getMessgerNG();
        }
    }

    public void displayAllDocument() {
        Map<String, Document> documentsMap = DocumentManager.getAllDocuments();
        List<Document> documents = new ArrayList<>(documentsMap.values());
        if (documents.isEmpty()) {
            libraryView.getMessDisplay();
        } else {
            Collections.sort(documents);
            for (Document document : documents) {
                System.out.println(document);
            }
        }
    }
}
