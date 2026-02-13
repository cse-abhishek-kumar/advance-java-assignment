package com.capgemini.libraryBookManagementSystem;

import jakarta.persistence.*;

import java.util.List;

public class LibraryBookJpaApp {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("libraryPU");

        EntityManager em = emf.createEntityManager();

        

        em.getTransaction().begin();

        Book b1 = new Book(1, "Atomic Habits",
                "James Clear", "Self-help",
                550, "Available", 2018);

        Book b2 = new Book(2, "The Alchemist",
                "Paulo Coelho", "Fiction",
                400, "Available", 1988);

        Book b3 = new Book(3, "Clean Code",
                "Robert C. Martin", "Programming",
                750, "Issued", 2008);

        em.persist(b1);
        em.persist(b2);
        em.persist(b3);

        em.getTransaction().commit();

        System.out.println("Books inserted successfully!\n");




        Book book = em.find(Book.class, 1);
        System.out.println("Fetched by ID:");
        System.out.println(book);

        System.out.println("\nAll Books:");

        List<Book> books =
                em.createQuery("FROM Book", Book.class)
                        .getResultList();

        books.forEach(System.out::println);


        em.getTransaction().begin();

        Book updateBook = em.find(Book.class, 2);

        updateBook.setPrice(450);
        updateBook.setAvailabilityStatus("Issued");

        em.getTransaction().commit();

        System.out.println("\nBook Updated!");


        em.getTransaction().begin();

        Book deleteBook = em.find(Book.class, 3);

        if(deleteBook != null){
            em.remove(deleteBook);
        }

        em.getTransaction().commit();

        System.out.println("\nBook Deleted!");


        em.close();
        emf.close();
    }
}