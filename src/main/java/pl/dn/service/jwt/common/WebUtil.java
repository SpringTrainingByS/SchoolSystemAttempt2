package pl.dn.service.jwt.common;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.authenticator.SavedRequest;

public class WebUtil {
	
	private static final String XML_HTTP_REQUEST = "XMLHttpRequest";
	private static final String X_REQUESTED_WITH = "X-Requested-With";
	
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String CONTENT_TYPE_JSON = "application/json";
	
	public static boolean isAjax(HttpServletRequest request) {
		return XML_HTTP_REQUEST.equals(request.getHeader(X_REQUESTED_WITH));
	}
	
	public static boolean isAjax(SavedRequest request) {
		ArrayList<String> headerValues = (ArrayList<String>) request.getHeaderValues(X_REQUESTED_WITH);
		return headerValues.contains(XML_HTTP_REQUEST);
	}
	
	public static boolean isContentTypeJson(HttpServletRequest request) {
		
		boolean isValid = false;
		
		if (request.getHeader(CONTENT_TYPE) != null && request.getHeader(CONTENT_TYPE).equals(CONTENT_TYPE_JSON)) {
			isValid = true;
		}
		
		return isValid;
	}
	
}
