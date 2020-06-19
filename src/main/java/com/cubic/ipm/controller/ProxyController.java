package com.cubic.ipm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cubic.ipm.enums.Flags;
import com.cubic.ipm.model.Proxy;
import com.cubic.ipm.model.User;
import com.cubic.ipm.service.ProxyService;

@RestController
@RequestMapping(value = "/proxy")
public class 	ProxyController {
	
	@Autowired
	private ProxyService proxyService;
	@RequestMapping(value="/getProxy", method=RequestMethod.GET)
	public List<Proxy> getAll(){
		//System.out.println(proxyService.getAllProxy());
		return  proxyService.getAllProxy();
		
	}
	
	@RequestMapping(value="/editProxy", method=RequestMethod.GET)
	public Proxy proxyEdit(){
	
		return null;
	}
	 @RequestMapping(value = "/deleteProxy/{id}", method = RequestMethod.GET)
	    public void deleteUser(@PathVariable("id") Long id){
	        proxyService.deleteProxy(id);
	    }
	 @RequestMapping(value = "/getData/{id}", method = RequestMethod.GET)
		public  Proxy update(@PathVariable("id") long id) {
			Proxy std = proxyService.getProxyByid(id);
			return std;
		}
	/* @RequestMapping(value = "/update", method = RequestMethod.POST)
		public  Boolean update(Proxy proxy) {
			// System.out.println(">>>>update>>>>>");
			proxyService.updateProxy(proxy);
			return true;
		}*/
	  @RequestMapping(value = "/updateProxy", method = RequestMethod.PUT)
	    public void updateProxy(@RequestBody Proxy proxy){
		  
	        proxyService.updateProxy(proxy);
	    }

}

