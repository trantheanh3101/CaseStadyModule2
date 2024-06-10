package CaseStady_LibraryManager.model;

import java.util.Set;

public class CardStudent implements Comparable<CardStudent>{
    private String cardCode;
    private int borrowDay;
    private int returnDay;
    Set<Document> documents;
    private Student student;

    public CardStudent() {
    }

    public CardStudent(String cardCode, int borrowDay, int returnDay, Set<Document> documents, Student student) {
        this.cardCode = cardCode;
        this.borrowDay = borrowDay;
        this.returnDay = returnDay;
        this.documents = documents;
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

//    public Document getDocument() {
//        return document;
//    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int compareTo(CardStudent o) {
        return this.cardCode.compareTo(o.cardCode);
    }

    @Override
    public String toString() {
        return "------CardStudent: Code: " +  cardCode + "------\n" +
                "borrowDay: " + borrowDay + ", returnDay: " + returnDay + "\n" +
                documents + "\n" + student ;

    }
}
