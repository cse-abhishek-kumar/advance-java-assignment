package com.bookstoremanagementsystem.web.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bookstoremanagementsystem.web.entity.Book;
import com.bookstoremanagementsystem.web.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	
	public List<Book> getByAuthor(String author){
		return repo.findByAuthor(author);
	}
	public Page<Book> getByGenre(String genre, int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		return repo.findByGenre(genre, pageable);
	}
	public List<Book> cheaperThan(Double price){
		return repo.findByPriceLessThan(price);
	}
	public List<Book> expensiveThan(Double price){
		return repo.findByPriceGreaterThan(price);
	}
	public List<Book> newArrivals(LocalDate date){
		return repo.findByPublishedDateAfter(date);
	}
	public List<Book> searchTitle(String keyword){
		return repo.findByTitleContaining(keyword);
	}
	public List<Book> genreAndAuthor(String genre,String author){
        return repo.findByGenreAndAuthor(genre,author);
    }
    public List<Book> genreOrAuthor(String genre,String author){
        return repo.findByGenreOrAuthor(genre,author);
    }
    public List<Book> priceRange(Double min,Double max){
        return repo.findByPriceBetween(min,max);
    }
    public List<Book> genreDiscount(String genre,Double price){
        return repo.findByGenreAndPriceLessThan(genre,price);
    }
    public List<Book> latest(){
        return repo.findByOrderByPublishedDateDesc();
    }
    public List<Book> priceAsc(){
        return repo.findByOrderByPriceAsc();
    }

}
