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

		req.setAttribute("books", bookService.listBooks());

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book_list.jsp");
		requestDispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		BookService bookService = ServiceUtils.getBookService();

		String[] filterValue = req.getParameterValues("szures");

		RequestDispatcher requestDispatcher;

		if (bookService.bookListFiltered(filterValue[0]).isEmpty()) {
			requestDispatcher = req.getRequestDispatcher("/book_not_found.jsp");

		} else {
			req.setAttribute("books", bookService.bookListFiltered(filterValue[0]));
			requestDispatcher = req.getRequestDispatcher("/book_list.jsp");
		}

		requestDispatcher.forward(req, resp);

	}

}
