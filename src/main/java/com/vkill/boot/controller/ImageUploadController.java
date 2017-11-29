package com.vkill.boot.controller;

import com.vkill.boot.utils.CreateMd5;
import com.vkill.boot.model.File;
import com.vkill.boot.service.FileService;
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

import static com.vkill.boot.utils.IsImag.isImage;
import static com.vkill.boot.utils.SaveFile.getRealPath;
import static com.vkill.boot.utils.SaveFile.saveFile;


/**
 * @author wucy
 */
@Controller
@RequestMapping("/ImageUpload")
public class ImageUploadController {
    private static final Logger logger = LoggerFactory.getLogger(ImageUploadController.class);

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/Index", method = RequestMethod.GET)
    public String Upload() {
        return "ImageUpload/Upload";
    }

    @ResponseBody
    @RequestMapping(value = "/ImageUp", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("id") String id,
                             @RequestParam("name") String name,
                             @RequestParam("type") String type,
                             @RequestParam("lastModifiedDate") String lastModifiedDate,
                             @RequestParam("size") int size,
                             @RequestParam("file") MultipartFile file) {
        String fileName ;

        try {


            if (!isImage(file))
                return "{\"error\":true}";
            String md5 = CreateMd5.createMd5(file).toString();
            if(fileService.exists(md5)){
                return "{\"error\":true}";
            }
            String realpath = getRealPath();
            String ext = name.substring(name.lastIndexOf("."));
            fileName = UUID.randomUUID().toString() + name;
            saveFile(realpath, fileName, file);

            fileService.mybaitsSave(new File(fileName, md5, new Date()));

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return "{\"error\":true}";
        }

        return "{jsonrpc = \"2.0\",id = id,filePath = \"/Upload/\" + fileFullName}";
    }
}

