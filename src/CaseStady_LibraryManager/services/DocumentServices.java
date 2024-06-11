package CaseStady_LibraryManager.services;

import CaseStady_LibraryManager.model.Document;
import CaseStady_LibraryManager.repository.DocumentManager;
import CaseStady_LibraryManager.view.LibraryInform;
import CaseStady_LibraryManager.view.LibraryView;

import java.util.*;

public class DocumentServices {
    private LibraryView libraryView;
    private DocumentManager documentManager;
    private LibraryInform libraryInform;

    public DocumentServices() {
        this.documentManager = new DocumentManager();
        this.libraryView = new LibraryView();
        this.libraryInform = new LibraryInform();
    }

    private boolean checkCode(String documentCode) {
        Map<String, Document> documents = DocumentManager.getAllDocuments();
        return documents.containsKey(documentCode);
    }

    public void addDocument(LibraryView libraryView) {
        Map<String, Document> documents = DocumentManager.getAllDocuments();
        Map<String,Document> documentMap = libraryView.getDetailDocument(documents);
        for (Document document : documentMap.values()){
            documentManager.addDocumentLibrary(document);
        }
        libraryInform.getMessgerOK();
    }

    public void deleteDocument(LibraryView libraryView) {
        Map<String, Document> documents = DocumentManager.getAllDocuments();
        String documentCode = libraryView.getDocumentCode();
        if (documents.containsKey(documentCode)) {
            documentManager.removeDocument(documentCode);
            libraryInform.getMessgerOK();
        } else {
            libraryInform.getMessgerNG();
        }
    }

    public void displayAllDocument() {
        Map<String, Document> documentsMap = DocumentManager.getAllDocuments();
        List<Document> documents = new ArrayList<>(documentsMap.values());
        if (documents.isEmpty()) {
            libraryInform.getMessDisplay();
        } else {
            Collections.sort(documents);
            for (Document document : documents) {
                System.out.println(document);
            }
        }
    }
}
