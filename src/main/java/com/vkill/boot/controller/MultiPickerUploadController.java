package com.vkill.boot.controller;

import com.vkill.boot.model.File;
import com.vkill.boot.service.FileService;
import com.vkill.boot.utils.CreateMd5;
import com.vkill.boot.utils.SaveFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

/**
 * Created by boot
 * 多个文件选择器上传文件，一个选择器对应一个文件
 */
@Controller
@RequestMapping("/MultiPickerUpload")
public class MultiPickerUploadController {


    @Autowired
    private FileService fileService;


    @GetMapping(value = "/Index")
    public String Index() {
        return "MultiPicker/Index";
    }

    @PostMapping("/")
    public ResponseEntity<Void> fileUpload(@RequestParam("type") String type,
                                           @RequestParam("name") String name,
                                           @RequestParam("file") MultipartFile file) throws Exception {

        String fileName = UUID.randomUUID().toString() + "--" + name;
        String md5 = CreateMd5.createMd5(file).toString();
        if(fileService.exists(md5))
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        SaveFile.saveFile(SaveFile.getRealPath(), fileName, file);
        switch (type) {
            case "researchReport": //研究报告
                //save file
                fileService.save(new File(fileName, CreateMd5.createMd5(file).toString(), new Date()));
                break;
            case "researchReportStuff": //研究报告支撑材料(限PDF)
                //save file
                fileService.save(new File(fileName, CreateMd5.createMd5(file).toString(), new Date()));
                break;
            case "applyReport": //应用报告
                //save file
                fileService.save(new File(fileName, CreateMd5.createMd5(file).toString(), new Date()));
                break;
            case "applyReportStuff": //应用报告支撑材料(限PDF)
                //save file
                fileService.save(new File(fileName, CreateMd5.createMd5(file).toString(), new Date()));
                break;
            default:
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
