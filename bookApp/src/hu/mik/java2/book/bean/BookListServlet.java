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

@WebServlet("/book_list")
public class BookListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookService bookService = ServiceUtils.getBookService();
		bookService.sort();

		req.setAttribute("books", bookService.listBooks());

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book_list.jsp");
		requestDispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		BookService bookService = ServiceUtils.getBookService();
		bookService.sort();

		String[] feltetel = req.getParameterValues("szures");
		bookService.createFilteredBookList(feltetel[0]);

		req.setAttribute("books", bookService.bookListFiltered());

		if (bookService.bookListFiltered().isEmpty()) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book_not_found.jsp");
			requestDispatcher.forward(req, resp);

		} else {

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book_list.jsp");
			requestDispatcher.forward(req, resp);
		}

	}

}
