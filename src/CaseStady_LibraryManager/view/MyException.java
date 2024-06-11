package CaseStady_LibraryManager.view;

public interface MyException{

    class InvalidDayException extends Exception {
        public InvalidDayException(String message) {
            super(message);
        }
    }

    class IllegalArgumentException extends Exception {
        public IllegalArgumentException(String message) {
            super(message);
        }
    }

}
