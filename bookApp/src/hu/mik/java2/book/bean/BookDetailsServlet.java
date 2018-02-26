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

@WebServlet("/book_details")
public class BookDetailsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	
		
		BookService bookService = ServiceUtils.getBookService();
		
		Book book;
		
		if(req.getParameter("bookId") != null)
		{
			Integer bookId = new Integer(req.getParameter("bookId"));
			book = bookService.getBookById(bookId);
		}
		else
		{
			book = null;
		}
		
		req.setAttribute("book",book);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/book_details.jsp");
		requestDispatcher.forward(req,resp);
	}

	
	
	
}
