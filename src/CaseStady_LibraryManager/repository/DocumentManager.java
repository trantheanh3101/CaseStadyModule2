package CaseStady_LibraryManager.repository;

import CaseStady_LibraryManager.model.Document;


import java.io.*;
import java.util.ArrayList;

public class DocumentManager {

    private static final String FILEDOCUMENT_PATH = "C:\\Users\\admin\\Desktop\\TheanhCode\\CaseStadyModule2\\src\\CaseStady_LibraryManager\\repository\\DocumentManager.csv";

    public static ArrayList<Document> getAllDocuments() {
        ArrayList<Document> documents = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILEDOCUMENT_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length == 2) {
                    Document document = new Document(attributes[0],Integer.parseInt(attributes[1]));
                    documents.add(document);
                }
            }
        } catch (FileNotFoundException e) {
            // File not found, return empty list
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documents;
    }

    private void saveAllDocument(ArrayList<Document> documents) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILEDOCUMENT_PATH))){
            for (Document document : documents){
                bw.write(document.getDocumentCode() + "," + document.getQuantity());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addDocumentLibrary(Document document) {
        ArrayList<Document> documents = DocumentManager.getAllDocuments();
        documents.add(document);
        saveAllDocument(documents);
    }

    public void updateDocument(String cardCode, int quantity) {
        ArrayList<Document> documents = DocumentManager.getAllDocuments();
        for (Document document : documents){
            if (document.getDocumentCode().equals(cardCode)){
                document.setQuantity(document.getQuantity() - quantity);
            }
        }
        saveAllDocument(documents);
    }
}
