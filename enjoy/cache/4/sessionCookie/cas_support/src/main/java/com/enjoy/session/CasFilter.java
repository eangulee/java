package com.enjoy.session;

import com.enjoy.utils.CookieBasedSession;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Peter on 2018/8/15.
 */
public class CasFilter implements Filter {
	public static final String USER_INFO = "user";

	private RedisTemplate redisTemplate;

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		MyRequestWrapper myRequestWrapper = new MyRequestWrapper(request, redisTemplate);

		// 如果未登陆状态，进入下面逻辑
		String requestUrl = request.getServletPath();
		if (!"/toLogin".equals(requestUrl) && !requestUrl.startsWith("/login") && !myRequestWrapper.isLogin()) {

			/**
			 * ticket为空，或无对应sessionid为空 --- 表明不是自动登陆请求--直接强制到登陆页面
			 */
			String ticket = request.getParameter("ticket");
			if (null == ticket || null == redisTemplate.opsForValue().get(ticket)) {
				HttpServletResponse response = (HttpServletResponse) servletResponse;
				response.sendRedirect("http://cas.com:8090/toLogin?url=" + request.getRequestURL().toString());
				return;
			}

			/**
			 * 是自动登陆请求，则种cookie值进去---本次请求是302重定向 重定向后的下次请求，自带本cookie，将直接是登陆状态
			 */
			// 如果已经登录，从cas重定向过来已经携带了ticket，则直接可以拿到sessionid
			myRequestWrapper.setSessionId((String) redisTemplate.opsForValue().get(ticket));
			myRequestWrapper.createSession();
			// 种cookie
			CookieBasedSession.onNewCookie(myRequestWrapper, (HttpServletResponse) servletResponse);

			// 重定向自流转一次，原地跳转重向一次，为了立即将cookie写入到客户端，避免被其他请求相应覆盖
			HttpServletResponse response = (HttpServletResponse) servletResponse;
			response.sendRedirect(request.getRequestURL().toString());
			return;
		}

		try {
			filterChain.doFilter(myRequestWrapper, servletResponse);
		} finally {
			myRequestWrapper.commitSession();
		}
	}

	@Override
	public void destroy() {

	}
}
