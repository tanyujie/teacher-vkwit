package org.easymis.vkwit.teacher.client.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class UserRestService {
	@Autowired
	private UserClient userClient;

	@HystrixCommand(fallbackMethod = "findByIdFallback")
	public String findById(String id) {
		return userClient.findById(id);
	}
	private String findByIdFallback(String id){
		return null;
	}
}
