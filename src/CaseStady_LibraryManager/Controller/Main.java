package CaseStady_LibraryManager.Controller;

import CaseStady_LibraryManager.view.LibraryView;

public class Main {
    public static void main(String[] args) {
        LibraryView libraryView = new LibraryView();
        LibraryController libraryController = new LibraryController(libraryView);
        libraryController.start();
    }
}
