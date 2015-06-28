package com.salk.legacy.web.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ViewSchemaCheck {
	// @Before("execution(* com.salk.legacy.web.controller..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	// @Around("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")
	public void test() {
		System.out.println("已经拦截=====================");
	}

	// @Before("execution(* com.salk.legacy.web.controller.ProductController.listForHandler(..)) && args(..,request)")
	public void test2(HttpServletRequest request) {
		request.setAttribute("test", "test");
		System.out.println("已经拦截2=====================");
	}
}
