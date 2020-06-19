package com.cubic.ipm.service;

import java.util.List;

import com.cubic.ipm.model.Proxy;

public interface ProxyService {

	public Proxy createProxy(Proxy proxy);
	
	public List<Proxy> getAllProxy();

	public void deleteProxy(Long id);

	public Proxy getProxyByid(Long id);

	public void updateProxy(Proxy proxy);
}
