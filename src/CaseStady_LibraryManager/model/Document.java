package CaseStady_LibraryManager.model;

public class Document implements Comparable<Document> {
    private String documentCode;
    private int quantity;

    public Document() {
    }

    public Document(String documentCode, int quantity) {
        this.documentCode = documentCode;
        this.quantity = quantity;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Document o) {
        return this.documentCode.compareTo(o.documentCode);
    }

    @Override
    public String toString() {
        return "documentCode : '" + documentCode + '\'' +
                ", quantity : " + quantity;
    }
}
