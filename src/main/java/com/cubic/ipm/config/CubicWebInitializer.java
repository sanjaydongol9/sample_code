/**
 * Copyright 2016 (C) Cubic Technologies LLC
 * All Rights Reserved
 * @author Sanjay Dongol
 */

package com.cubic.ipm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/* replacement class for web.xml */
public class CubicWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//return new Class[] { SpringWebConfig.class };
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
