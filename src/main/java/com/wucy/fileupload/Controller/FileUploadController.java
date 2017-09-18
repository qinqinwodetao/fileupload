package com.wucy.fileupload.Controller;

import com.wucy.fileupload.Model.File;
import com.wucy.fileupload.Service.FileService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

import static com.wucy.fileupload.Utils.CreateMd5.createMd5;
import static com.wucy.fileupload.Utils.SaveFile.getRealPath;
import static com.wucy.fileupload.Utils.SaveFile.saveFile;


@Controller
@RequestMapping("/FileUpload")
public class FileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/Index", method = RequestMethod.GET)
	public String Index() {
		return "FileUpload/Index";
	}

	@ResponseBody
	@RequestMapping(value = "/FileUp", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("id") String id,
	                         @RequestParam("name") String name,
	                         @RequestParam("type") String type,
	                         @RequestParam("lastModifiedDate") String lastModifiedDate,
	                         @RequestParam("size") int size,
	                         @RequestParam("file") MultipartFile file) {
		String fileName;
		String md5;

		try {
			fileName = UUID.randomUUID().toString() + "--" + name;
			md5 = createMd5(file).toString();
			if(fileService.exists(md5)){
				return "{\"error\":true}";
			}
			saveFile(getRealPath(), fileName, file);
		} catch (Exception ex) {
			return "{\"error\":true}";
		}
		try {
			fileService.save(new File(fileName, createMd5(file).toString(), new Date()));
		} catch (Exception e) {
			return "{\"error\":true}";
		}

		return "{jsonrpc = \"2.0\",id = id,filePath = \"/Upload/\" + fileFullName}";
	}
}
