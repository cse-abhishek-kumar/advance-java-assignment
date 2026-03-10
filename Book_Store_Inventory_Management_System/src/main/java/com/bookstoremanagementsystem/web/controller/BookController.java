package com.bookstoremanagementsystem.web.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoremanagementsystem.web.Service.BookService;
import com.bookstoremanagementsystem.web.entity.Book;

@RestController
@RequestMapping("/api/books")
public class BookController {

	
	@Autowired
	private BookService service;
	
	@GetMapping("/author")
	public ResponseEntity<List<Book>> getByAuthor(@RequestParam String author){
		List<Book> books = service.getByAuthor(author);
		return ResponseEntity.ok(books);
	}
	
	@GetMapping("/genre")
    public ResponseEntity<Page<Book>> getByGenre(
            @RequestParam String genre,
            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="5") int size){

        return ResponseEntity.ok(service.getByGenre(genre,page,size));
    }
	
	@GetMapping("/cheaper")
	public ResponseEntity<List<Book>> cheaper(@RequestParam Double price){
		return ResponseEntity.ok(service.cheaperThan(price));
	}
	
	@GetMapping("/expensive")
	public ResponseEntity<List<Book>> expensive(@RequestParam Double price){
		return ResponseEntity.ok(service.expensiveThan(price));
	}
	
	@GetMapping("/new-arrivals")
	public ResponseEntity<List<Book>> newArrivals(@RequestParam LocalDate publishedDate){
		return ResponseEntity.ok(service.newArrivals(publishedDate));
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Book>> search(@RequestParam String keyword){
		return ResponseEntity.ok(service.searchTitle(keyword));
	}
	
	@GetMapping("/genre-author")
    public ResponseEntity<List<Book>> genreAuthor(
            @RequestParam String genre,
            @RequestParam String author){

        return ResponseEntity.ok(service.genreAndAuthor(genre,author));
    }

    @GetMapping("/genre-or-author")
    public ResponseEntity<List<Book>> genreOrAuthor(
            @RequestParam String genre,
            @RequestParam String author){

        return ResponseEntity.ok(service.genreOrAuthor(genre,author));
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<Book>> priceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice){

        return ResponseEntity.ok(service.priceRange(minPrice,maxPrice));
    }

    @GetMapping("/genre-discount")
    public ResponseEntity<List<Book>> genreDiscount(
            @RequestParam String genre,
            @RequestParam Double maxPrice){

        return ResponseEntity.ok(service.genreDiscount(genre,maxPrice));
    }

    @GetMapping("/latest")
    public ResponseEntity<List<Book>> latest(){
        return ResponseEntity.ok(service.latest());
    }

    @GetMapping("/by-price")
    public ResponseEntity<List<Book>> byPrice(){
        return ResponseEntity.ok(service.priceAsc());
    }
}
