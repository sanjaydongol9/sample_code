package com.cubic.ipm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.ipm.dao.ProxyDaoService;
import com.cubic.ipm.enums.Flags;
import com.cubic.ipm.model.Proxy;
import com.cubic.ipm.service.ProxyService;

@Service
@Transactional
public class ProxyServiceImpl implements ProxyService{
	
	@Autowired
	private ProxyDaoService proxyDaoService;

	@Override
	public Proxy createProxy(Proxy proxy) {
		// TODO Auto-generated method stub
		return proxyDaoService.save(proxy);
	}

	@Override
	public List<Proxy> getAllProxy() {
		// TODO Auto-generated method stub
		return proxyDaoService.findAll();
	}



	@Override
	public void deleteProxy(Long id) {
		
		proxyDaoService.delete(id);
	}

	@Override
	public Proxy getProxyByid(Long id) {
		// TODO Auto-generated method stub
		return proxyDaoService.find(id);
	}

	@Override
	public void updateProxy(Proxy proxy) {
		// TODO Auto-generated method stub
		proxy.setFlag(Flags.UPDATED);
		proxyDaoService.update(proxy);
		
	}

	

}
