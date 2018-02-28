package hu.mik.java2.book.bean;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hu.mik.java2.book.service.BookService;
import hu.mik.java2.book.service.ServiceUtils;

@WebServlet("/book_edit")
public class BookEditServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookService bookService = ServiceUtils.getBookService();

		Book book;
		if (req.getParameter("bookId") != null) {
			Integer bookId = new Integer(req.getParameter("bookId"));
			book = bookService.getBookById(bookId);
		} else {
			book = new Book();
		}

		req.setAttribute("book", book);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book_edit.jsp");
		requestDispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book = new Book();

		req.setCharacterEncoding("UTF-8");

		try {
			BeanUtils.populate(book, req.getParameterMap());

			if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
				book.setId(null);
			}

			BookService service = ServiceUtils.getBookService();
			Book updateBook;
			if (book.getId() == null) {
				updateBook = service.saveBook(book);
			} else {
				updateBook = service.updateBook(book);
			}
			req.setAttribute("book", updateBook);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book_details.jsp");
		requestDispatcher.forward(req, resp);

	}

}
