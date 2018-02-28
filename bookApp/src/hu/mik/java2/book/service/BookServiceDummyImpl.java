package hu.mik.java2.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		
		//return this.bookList.stream().sorted(Comparator.comparing(Book::getId)).collect(Collectors.toList());
		return this.bookList.stream().sorted((id1, id2) -> id1.getId() - id2.getId()).collect(Collectors.toList());
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


	public synchronized List<Book> bookListFiltered(String filterValue) {
		
		return this.bookList.stream().filter(f ->f.getAuthor().toLowerCase().contains(filterValue.toLowerCase())).collect(Collectors.toList());
	}

}
