/*
 * Copyright 2008-2009 MOPAS(MINISTRY OF SECURITY AND PUBLIC ADMINISTRATION).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.com.cmm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class HTMLTagFilter implements Filter{

	@SuppressWarnings("unused")
	private FilterConfig config;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		if(excludePatternUrl(httpRequest)) {
			chain.doFilter(new HTMLTagFilterRequestWrapper((HttpServletRequest)request), response);	
		} else {
			chain.doFilter(new HttpServletRequestWrapper(httpRequest), response);
		}
	}
	
	private boolean excludePatternUrl(HttpServletRequest request) {
		String uri = request.getRequestURI().toString().trim();
		
		// HTML 특수문자 변환 예외 처리
		if(uri.startsWith("/opm/")) { //운영관리
			return false;
		} else if(uri.startsWith("/dlm/")) { //근태관리
			return false;
		} else if(uri.startsWith("/rsm/")) { //보고ㆍ현황관리
			return false;
		} else if(uri.startsWith("/sys/")) { //시스템관리
			return false;
		} else if(uri.startsWith("/cop/bbs/")) { //게시판
			return false;
		} else {
			return true;
		}
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void destroy() {

	}
}
