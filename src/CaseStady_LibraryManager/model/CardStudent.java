package CaseStady_LibraryManager.model;

public class CardStudent {
    private String cardCode;
    private int borrowDay;
    private int returnDay;
    private Document document;
    private Student student;

    public CardStudent() {
    }

    public CardStudent(String cardCode, int borrowDay, int returnDay, Document document, Student student) {
        this.cardCode = cardCode;
        this.borrowDay = borrowDay;
        this.returnDay = returnDay;
        this.document = document;
        this.student = student;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public int getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(int borrowDay) {
        this.borrowDay = borrowDay;
    }

    public int getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(int returnDay) {
        this.returnDay = returnDay;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "CardStudent{" +
                "cardCode='" + cardCode + '\'' +
                ", borrowDay=" + borrowDay +
                ", returnDay=" + returnDay +
                ", document=" + document +
                ", student=" + student +
                '}';
    }
}
