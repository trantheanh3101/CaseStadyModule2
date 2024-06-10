package CaseStady_LibraryManager.repository;

import CaseStady_LibraryManager.model.Document;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DocumentManager {

    private static final String FILEDOCUMENT_PATH = "C:\\Users\\admin\\Desktop\\TheanhCode\\CaseStadyModule2\\src\\CaseStady_LibraryManager\\data\\DocumentManager.csv";

    public static Map<String, Document> getAllDocuments() {
        Map<String, Document> documents = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILEDOCUMENT_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length == 2) {
                    Document document = new Document(attributes[0], Integer.parseInt(attributes[1]));
                    documents.put(attributes[0], document);
                }
            }
        } catch (FileNotFoundException e) {
            // File không được tìm thấy, trả về map rỗng
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documents;
    }

    private void saveAllDocument(Map<String, Document> documents) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILEDOCUMENT_PATH))) {
            for (Document document : documents.values()) {
                bw.write(document.getDocumentCode() + "," + document.getQuantity());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addDocumentLibrary(Document document) {
        Map<String, Document> documents = DocumentManager.getAllDocuments();
        documents.put(document.getDocumentCode(), document);
        saveAllDocument(documents);
    }

    public void updateDocument(String documentCode, int quantity) {
        Map<String, Document> documents = DocumentManager.getAllDocuments();
        Document document = documents.get(documentCode);
        if (document != null) {
            document.setQuantity(document.getQuantity() - quantity);
            saveAllDocument(documents);
        }
    }

    public void removeDocument(String documentCode) {
        Map<String, Document> documents = DocumentManager.getAllDocuments();
        documents.remove(documentCode);
        saveAllDocument(documents);
    }
}
