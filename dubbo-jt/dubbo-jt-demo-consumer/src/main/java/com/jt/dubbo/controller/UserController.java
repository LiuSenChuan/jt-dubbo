package com.jt.dubbo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jt.dubbo.pojo.User;
import com.jt.dubbo.service.UserService;

@RestController
public class UserController {
	/**
	 * timeout:定义链接超时时间
	 * check:消费者启动时检查是否有服务的提供者
	 * 调整负载均衡策略:
	 * loadbalance=
	 * 1.随机策略:random
	 * 2.轮询策略:roundrobin
	 * 3.IPHSAH策略:consistenthash
	 * 4.最小访问策略:leastactive  根据访问的链接数量挑选少的进行访问
	 * 
	 */
	@Reference(timeout=3000,check=true,loadbalance = "roundrobin")
	private UserService userService;
	
	@RequestMapping("/findAll")
	public List<User> findAll(){
		
		return userService.findAll();
	}
	
	@RequestMapping("/saveUser/{name}/{age}/{sex}")
	public String saveUser(User user) {
		
		userService.saveUser(user);
		return "用户入库成功!!!";
	}
}
