package hu.mik.java2.book.service;


import java.util.ArrayList;
import java.util.List;

import hu.mik.java2.book.bean.Book;

public class BookServiceDummyImpl implements BookService {
	private static List<Book> bookList;
	List<Book> filteredBookList = new ArrayList<>();

	static {
		init();
	}

	private static void init() {
		bookList = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Book temp = new Book();
			temp.setId(i + 1);
			temp.setTitle(i + 1 + " cím");
			temp.setAuthor(i + 1 + ". szerzõ");
			temp.setDescription(i + 1 + ". leírás");
			temp.setPubYear(2000 + i);
			bookList.add(temp);
		}

	}

	private synchronized Integer getNextId() {
		if (bookList.isEmpty()) {
			return 1;
		}
		int max = 0;
		for (Book book : bookList) {
			if (max < book.getId()) {
				max = book.getId();
			}
		}
		return max + 1;
	}

	@Override
	public synchronized List<Book> listBooks() {
		return bookList;
	}

	@Override
	public synchronized Book getBookById(Integer id) {
		for (Book book : bookList) {
			if (book.getId().equals(id)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public synchronized Book saveBook(Book book) {
		book.setId(getNextId());
		bookList.add(book);
		return book;
	}

	@Override
	public synchronized Book updateBook(Book book) {
		Book bookById = getBookById(book.getId());
		deleteBook(bookById);
		bookList.add(book);
		return book;
	}

	@Override
	public synchronized void deleteBook(Book book) {
		if (book != null) {
			Book bookToRemove = null;
			for (Book b : bookList) {
				if (b.getId().equals(book.getId())) {
					bookToRemove = b;
					break;
				}
			}
			bookList.remove(bookToRemove);
		}
	}
	
	public synchronized void sort()
	{
		Book tempBook;
		for (int i = 0; i < bookList.size(); i++) {
			for (int j = 0; j < bookList.size()-1; j++) {
				
				if(bookList.get(j).getId()>bookList.get(j+1).getId())
				{
					tempBook=bookList.get(j);
					bookList.set(j,bookList.get(j+1));
					bookList.set(j+1,tempBook);
			
				}
			}
		}
	}
	
	public synchronized void createFilteredBookList(String feltetel) {
		
		filteredBookList.clear();
			
		for (Book book : bookList) {
			if(book.getAuthor().toLowerCase().contains(feltetel.toLowerCase()))
			{
				filteredBookList.add(book);
			}
		}
		
	}
	
	
	public synchronized List<Book> bookListFiltered(){
		return filteredBookList;
	}

}
