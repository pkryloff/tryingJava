package ru.hse.edu.sc.y2020.Books;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public boolean containsBook(Book book) {
        return books.contains(book);
    }

    public void showAvailableBooks() {
        if (books.size() != 0) {
            for (int i = 0; i < books.size(); i++)
                if (!books.get(i).getIsBorrowed())
                    System.out.println(books.get(i).toString());
        } else System.out.println("Библиотека пуста, книг нет.");
    }

    public void showBorrowedBooks() {
        if (books.size() != 0) {
            for (int i = 0; i < books.size(); i++)
                if (books.get(i).getIsBorrowed())
                    System.out.println(books.get(i).toString());
        } else System.out.println("Вы ещё не взяли ни одну книгу.");
    }
    public ArrayList<Book> findBooksByName(String name) {
        ArrayList<Book> booksWithThisName = new ArrayList<>();

        for (Book book : books) {
            if (book.getName().toLowerCase().contains(name.toLowerCase())) {
                booksWithThisName.add(book);
            }
        }

        return booksWithThisName;
    }
    public void getBook(int id)  {
        for (int i = 0; i < books.size(); i++)
            if (books.get(i).getId() == id && !books.get(i).getIsBorrowed()) {
                books.get(i).changeIsBorrowedFlag(true);
                return;
            }

        System.out.println("Такой книги нет.");
    }

    public void returnBook(int id)  {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id && books.get(i).getIsBorrowed()) {
                books.get(i).changeIsBorrowedFlag(false);
                return;
            }
        }

        System.out.println("Такой книги нет.");
    }
}
