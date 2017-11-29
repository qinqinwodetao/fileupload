package com.vkill.boot.controller;

import com.vkill.boot.model.File;
import com.vkill.boot.model.Result;
import com.vkill.boot.service.FileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author wucy
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private FileService fileService;

	@RequestMapping
	public String index() {
		return "index";
	}

	@ApiOperation(value = "获取文件列表")
	@GetMapping(value = "/getFileList" )
	@ResponseBody
	public Result getFileList(@RequestParam("page") int page, @RequestParam("size") int size){
		Sort sort = new Sort(Sort.Direction.ASC,"uploadDate");
		Pageable pageable = new PageRequest(page, size, sort);
		return Result.ok(fileService.findByPage(pageable));
	}

}
