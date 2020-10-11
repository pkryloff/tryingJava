package ru.hse.edu.sc.y2020.Books;

import java.util.Objects;

public class Book {
    // Внутренний номер книги
    private int id;
    // Название книги
    private String name;
    // Год издания книги
    private int year;
    // Взял ли кто-то эту книгу
    private boolean isBorrowed;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    public Book (int id, String name, int year){
        this.id = id;
        this.name = name;
        this.year = year;
        this.isBorrowed = false;
    }

    public void changeIsBorrowedFlag (boolean flag){
        isBorrowed = flag;
    }

    @Override
    public String toString() {
        StringBuilder bookInfo = new StringBuilder("ID: " + id + "; название: " + name + "; год издания: " + year);
        return bookInfo.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return (id == book.id) && (year == book.year)
                && Objects.equals(name, book.name) && (isBorrowed == book.isBorrowed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, isBorrowed);
    }
}
