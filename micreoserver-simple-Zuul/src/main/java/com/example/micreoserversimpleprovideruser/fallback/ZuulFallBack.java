package com.example.micreoserversimpleprovideruser.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ZuulFallBack implements FallbackProvider {

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		System.out.println("route:"+route);
        System.out.println("exception:"+cause.getMessage());
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				  HttpHeaders headers = new HttpHeaders();
				  MediaType mediaType=new MediaType("application","json",Charset.forName("UTF-8"));
				  headers.setContentType(mediaType);
	                return headers;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				// TODO Auto-generated method stub
				  return new ByteArrayInputStream("oooops!error,i'm the fallback.".getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				// TODO Auto-generated method stub
				return  HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.INTERNAL_SERVER_ERROR;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.INTERNAL_SERVER_ERROR.value();
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	

	@Override
	public String getRoute() {
		// TODO Auto-generated method stub
		//
		return "microserver-info";
	}
	

}
