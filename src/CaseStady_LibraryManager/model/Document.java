package CaseStady_LibraryManager.model;

public class Document {
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
    public String toString() {
        return "documentCode : '" + documentCode + '\'' +
                ", quantity : " + quantity;
    }
}
