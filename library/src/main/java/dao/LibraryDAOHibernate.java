package dao;

import java.util.List;

import model.Book;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import conn.LibraryConfiguration;

public class LibraryDAOHibernate implements LibraryDAO{

	public LibraryDAOHibernate() {
		LibraryConfiguration.createSessionFactory();
	}

	@Override
	public void registerBooks(Book b) {
		// TODO Auto-generated method stub
		Session session = LibraryConfiguration.createSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new Book(b.getIsbn(), b.getTitle()));
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException();
		} finally {
			session.close();
		}	
	}

	@Override
	public List<Book> listBooks() {
		Session session = LibraryConfiguration.createSession();
		List<Book> results = session.createQuery("FROM Book").list();
		session.close();
		return results;
	}

	@Override
	public void updateBooks(String oldIsbn, String newIsbn, String title) {
		// TODO Auto-generated method stub
		Session session = LibraryConfiguration.createSession();
		Query query = session.createQuery("UPDATE Book SET isbn=:newIsbn, title=:title WHERE isbn=:oldIsbn");
		query.setParameter("newIsbn", newIsbn);
		query.setParameter("title", title);
		query.setParameter("oldIsbn", oldIsbn);
		int result = query.executeUpdate();
		session.close();
		if (result == 0) {
			//
		}		
	}

	@Override
	public void unregisterBooks(String isbn) {
		// TODO Auto-generated method stub
		Session session = LibraryConfiguration.createSession();
		Query query = session.createQuery("DELETE FROM Book WHERE isbn=:isbn");
		query.setParameter("isbn", isbn);
		int result = query.executeUpdate();
		session.close();
		if (result == 0) {
			//
		}	
	}

	@Override
	public void findByIsbn(String isbn) {
		// TODO Auto-generated method stub
		Session session = LibraryConfiguration.createSession();
		Query query = session.createQuery("FROM Book WHERE isbn=:isbn");
		query.setParameter("isbn", isbn);
		List<Book> results = query.list();
		if (!results.isEmpty()) {
			//
		}
		session.close();
	}
}
