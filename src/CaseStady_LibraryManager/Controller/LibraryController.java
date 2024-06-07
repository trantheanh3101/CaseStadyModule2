package CaseStady_LibraryManager.Controller;

import CaseStady_LibraryManager.services.CardStudentServices;
import CaseStady_LibraryManager.services.DocumentServices;
import CaseStady_LibraryManager.view.LibraryView;

public class LibraryController {
    private CardStudentServices cardStudentServices;
    private DocumentServices documentServices;
    private LibraryView libraryView;

    public LibraryController(LibraryView libraryView) {
        this.libraryView = libraryView;
        this.cardStudentServices = new CardStudentServices();
        this.documentServices = new DocumentServices();
    }

    public void start() {
        boolean run = true;
        while (run){
            int choice = libraryView.getMenuChoice();
            switch (choice){
                case 1:
                    int option = libraryView.getMenuStudent();
                    switch (option) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 0:
                            break;
                        default:
                            libraryView.displayMessage();
                            break;
                    }
                    break;
                case 2:
                    int options = libraryView.getMenuLibraryManager();
                    switch (options){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            documentServices.addDocument(libraryView);
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        case 0:
                            break;
                        default:
                            libraryView.displayMessage();
                            break;
                    }
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    libraryView.displayMessage();
            }
        }
    }
}