package com.vkill.boot.controller;


import com.vkill.boot.model.Whois;
import com.vkill.boot.service.WhoisService;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boot
 */
@RestController
@RequestMapping(value = "/whois")
public class WhoisController {

	@Autowired
	private WhoisService whoisService;

	@ApiOperation(value = "查询whios信息")
	@GetMapping(value = "/getWhoisLatest" )
	public Page<Whois> getWhoisLatest(@RequestParam("page") int page, @RequestParam("size") int size){
		Sort sort = new Sort(Sort.Direction.ASC,"createTime");
		Pageable pageable = new PageRequest(page,size, sort);
		return whoisService.findByPage(pageable);
	}


}
