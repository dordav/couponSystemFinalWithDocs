package filters;

import java.io.IOException;
/**
* <h1>CompanyFilter</h1>
* Inside the CompanyFilter there is a method called "doFilter",
* in this method wrote the definitions of actions sequence  that the filter performs
*/

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import facade.CompanyFacade;
import webServices.LoggerService;
/**
* <h1>CompanyFilter</h1>
* Inside the CompanyFilter there is a method called "doFilter",
* in this method wrote the definitions of actions sequence  that the filter performs
*/
public class CompanyFilter implements Filter{
Logger logger = LoggerService.getLogger();

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if (req.getSession().getAttribute("companyFacade")==null) {
			logger.warn(request+" no company facade from this IP " + request.getRemoteAddr());
			res.sendRedirect("http://localhost:8080/login.html");
		} else if(!(req.getSession().getAttribute("companyFacade") instanceof CompanyFacade)){
			logger.warn(request+" no company facade from this IP " + request.getRemoteAddr());
			res.sendRedirect("http://localhost:8080/login.html");
		}else {
			chain.doFilter(request, response);
		}
		
	}
}
