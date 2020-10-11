package ru.hse.edu.sc.y2020.Books;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);
    static final String OPTIONS = "Введите номер нужного действия:\n" +
            "1. Взять доступную книгу из библиотеки\n" +
            "2. Вернуть взятую книгу\n" +
            "3. Найти книгу по названию\n" +
            "4. Завершить выполнение программы";
    static final String GET_BOOK_HINT = "\nЧтобы взять книгу, введите её ID.\n";
    static final String RETURN_BOOK_HINT = "\nЧтобы вернуть книгу, введите её ID.\n";
    static final String CHOICE_ERROR_HINT = "\nТакого пункта нет. Введите корректный вариант.";

    final static ArrayList<Book> booksInLibrary = new ArrayList<Book>() {{
        add(new Book(153301,"Белый Бим Черное ухо", 2018));
        add(new Book(153302,"Шантарам", 2009));
        add(new Book(153303,"Мастер и Маргарита", 1998));
        add(new Book(153304,"1984", 2002));
        add(new Book(153305,"Над пропастью во ржи", 2015));
    }};

    public static void getBook(Library library){
        System.out.println("Доступные книги: \n");
        library.showAvailableBooks();
        System.out.println(GET_BOOK_HINT);

        int idOfChosen = 0;
        if (input.hasNextInt())
            idOfChosen = input.nextInt();

        library.getBook(idOfChosen);

        System.out.println("Взятые книги: \n");
        library.showBorrowedBooks();
        System.out.println();
    }

    public static void returnBook(Library library){
        System.out.println("Взятые книги: \n");
        library.showBorrowedBooks();
        System.out.println(RETURN_BOOK_HINT);

        int idOfChosen = 0;
        if (input.hasNextInt())
            idOfChosen = input.nextInt();

        library.returnBook(idOfChosen);

        System.out.println("Взятые книги: \n");
        library.showBorrowedBooks();
        System.out.println();
    }

    public static void searchBook(Library library){
        System.out.println("Введите название книги:");
        String inputName = input.next();
        ArrayList<Book> result = library.findBooksByName(inputName);
        if(result.isEmpty())
            System.out.println("К сожалению, такой книги нет.");
        else
            for (int i = 0; i < result.size(); i++){
                System.out.printf(result.get(i).toString());
                if(result.get(i).getIsBorrowed())
                    System.out.println("\nКнига взята.\n");
                else
                    System.out.println("\nКнига доступна.\n");
            }
    }

    public static void main(String[] args) {
        Library library = new Library(booksInLibrary);
        boolean flagToExit = false;

        do{
            System.out.println(OPTIONS);
            String choice = input.next();
            switch (choice) {
                case "1": getBook(library);
                    break;
                case "2": returnBook(library);
                    break;
                case "3": searchBook(library);
                    break;
                case "4":
                    flagToExit = true;
                    break;
                default:
                    System.out.println(CHOICE_ERROR_HINT);
                    break;
            }
        } while (!flagToExit);
    }
}
