package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue
	private int id;
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="isbn", unique = true)
	private String isbn;
	@Column(name="title")
	private String title;
	
	public Book(){}
	
	public Book(String isbn, String title){
		this.isbn = isbn;
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}
	
	public String toString(){
		//return "Book id: " + getId() + "\n"
		 return "isbn: " + getIsbn() +"\n"
				+"title: " + getTitle() ;
		
	}

}
