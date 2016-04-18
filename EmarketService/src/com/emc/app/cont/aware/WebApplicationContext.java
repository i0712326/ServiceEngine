package com.emc.app.cont.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class WebApplicationContext implements ApplicationContextAware {
	private static ApplicationContext appContext;
	public WebApplicationContext() {
		super();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		WebApplicationContext.appContext = applicationContext;
	}
	public static Object getBean(String beanName) {
		return appContext.getBean(beanName);
	}

}
