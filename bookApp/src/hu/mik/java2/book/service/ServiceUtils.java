package hu.mik.java2.book.service;

public class ServiceUtils {
	public static BookServiceDummyImpl getBookService() {
		return new BookServiceDummyImpl();
		
	}
}
