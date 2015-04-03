package dao;

import java.util.List;

import model.Book;

public interface LibraryDAO {
	
	public void registerBooks(Book b);
	
	public List<Book> listBooks();
	
	public void updateBooks(String oldIsbn, String newIsbn, String title);
	
	public void unregisterBooks(String isbn);
	
	public void findByIsbn(String isbn);

}
