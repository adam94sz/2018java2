package hu.mik.java2.book.bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.mik.java2.book.service.BookService;
import hu.mik.java2.book.service.ServiceUtils;

@WebServlet("/book_delete")
public class BookDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BookService bookService = ServiceUtils.getBookService();

		Book book;

		if (req.getParameter("bookId") != null) {
			Integer bookId = new Integer(req.getParameter("bookId"));
			book = bookService.getBookById(bookId);

		} else {
			book = null;
		}

		req.setAttribute("book", book);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book_delete.jsp");
		requestDispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BookService bookService = ServiceUtils.getBookService();

		if (req.getParameter("id") != null) {
			Integer bookId = new Integer(req.getParameter("id"));
			Book deleteBook = bookService.getBookById(bookId);
			bookService.deleteBook(deleteBook);
		}

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book_delete_successful.jsp");
		requestDispatcher.forward(req, resp);

	}

}
