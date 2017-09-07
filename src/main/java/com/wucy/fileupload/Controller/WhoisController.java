package com.wucy.fileupload.Controller;


import com.wucy.fileupload.Model.Whois;
import com.wucy.fileupload.Service.WhoisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/whois")
public class WhoisController {

	@Autowired
	private WhoisService whoisService;


	@GetMapping(value = "/getWhoisLatest" )
	public Page<Whois> getWhoisLatest(@RequestParam("page") int page, @RequestParam("size") int size){
		Sort sort = new Sort(Sort.Direction.ASC,"createTime");
		Pageable pageable = new PageRequest(page,size, sort);
		return whoisService.findByPage(pageable);
	}


}
