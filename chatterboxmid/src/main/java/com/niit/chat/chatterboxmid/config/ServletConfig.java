package com.niit.chat.chatterboxmid.config;

import javax.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.niit.chat.chatterboxback.config.ChatConfiguration;;

public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*public void onStartup(ServletContext ctx) throws ServletException {
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(WebConfig.class);
        webCtx.setServletContext(ctx);        
        ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(webCtx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }*/

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		System.out.println("Registration of servlet");
		registration.setInitParameter("dispatchOptionsRequest", "true");
		registration.setAsyncSupported(true);
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{WebConfig.class,ChatConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return  new String[] { "/" };
	}
}
