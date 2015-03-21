package org.crm.webservices.filter;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class ResponseCorsFilter implements ContainerResponseFilter {

	@Override
	public ContainerResponse filter(ContainerRequest req,
			ContainerResponse contResp) {
		// Using UTF-8 char set in Content Type
		MediaType contentType = contResp.getMediaType();
		contResp.getHttpHeaders().putSingle("Content-Type",
				contentType.toString() + ";charset=UTF-8");
		// enable cross-origin resource sharing(CORS)
		contResp.getHttpHeaders().putSingle("Access-Control-Allow-Origin", "*");
		contResp.getHttpHeaders().putSingle("Access-Control-Allow-Methods",
				"GET, POST, PUT, DELETE, OPTIONS");

		String reqHead = req.getHeaderValue("Access-Control-Request-Headers");
		if (reqHead != null) {
			contResp.getHttpHeaders().putSingle("Access-Control-Allow-Headers",
					reqHead);
		}

		return contResp;
	}

}
