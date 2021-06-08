package com.iot.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter ("/*") //모든URL에 대해 filter적용 
//@WebFilter ("/Notice") //NoticeURL에 대한 정보만 적용됨
public class CharacterEncodingFilter implements Filter {
	
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		/*
		response.setCharacterEncoding("UTF-8");  //보내는쪽setCharacterEncoding (Encoding은 암호화 한다는 뜻) servlet->웹브라우저
	    response.setContentType("text/html;charset=UTF-8"); //보낸걸 받는쪽setContentType 
	    request.setCharacterEncoding("UTF-8");  //글자깨짐 방지
		*/
		
		//System.out.println("before filter"); //필터링 전에 실행
	 request.setCharacterEncoding("UTF-8"); //[("/*")=모든URL]에 대해서 필터 적용
	 chain.doFilter(request, response); //어떤 페이지를 주기 전에 해야 될일 
		//System.out.println("after filter");//필터 후 실행
		
		
		
		
	}
}
