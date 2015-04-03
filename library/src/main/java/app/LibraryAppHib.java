package app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.Book;
import dao.LibraryDAO;
import dao.LibraryDAOFactory;

public class LibraryAppHib {
	
	static boolean end = false;

	public static void menu() {

		System.out.println("1. Register books");
		System.out.println("2. List register books");
		System.out.println("3. Update book registation");
		System.out.println("4. Unregister books");
		System.out.println("5. Exit");
	}
	
	public static void main(String[] args) throws SQLException{
		
		LibraryDAOFactory factory = new LibraryDAOFactory();
		LibraryDAO dao = factory.createLibraryHibernate();
		
		Scanner in = new Scanner(System.in);
		
		while(!end){
			menu();
			String str = in.next();
			switch(str){
			case "1":
				System.out.println("Enter isbn: ");
				String isbn = in.next();
				if(isbn != null){
					System.out.println("Enter title: ");
					String title = in.next();
					Book b = new Book(isbn,title);
					dao.registerBooks(b);
				}
				break;
			case "2":
				List<Book> list = dao.listBooks();
				for(Book books : list){
					System.out.println(books + "\n");
				}
				break;
			case "3":
				System.out.println("Enter isbn: ");
				String oldIsbn = in.next();
				System.out.println("New isbn: ");
				String newIsbn = in.next();
				System.out.println("New title: ");
				String newTitle = in.next();
				dao.updateBooks(oldIsbn, newIsbn, newTitle);
				break;
			case "4":
				System.out.println("Enter isbn: ");
				String isbnDel = in.next();
				dao.unregisterBooks(isbnDel);
				break;
			case "5":
				in.close();
				end = true;
				break;
			}
		}		
		
	}	
	

}

