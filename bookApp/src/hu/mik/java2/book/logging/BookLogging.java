package hu.mik.java2.book.logging;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BookLogging implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {

		req.setCharacterEncoding("UTF-8");

		try {
			ServletRequest request = req;

			Enumeration<String> namesOfParameters = request.getParameterNames();

			while (namesOfParameters.hasMoreElements()) {
				String parameterName = namesOfParameters.nextElement();
				String[] parameterValues = request.getParameterValues(parameterName);
				for (String value : parameterValues) {
					System.out.println("Paraméter neve: " + parameterName + " --> Értéke: " + value);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		filterChain.doFilter(req, resp);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
