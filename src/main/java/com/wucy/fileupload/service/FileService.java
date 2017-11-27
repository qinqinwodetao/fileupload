package com.wucy.fileupload.service;

import com.wucy.fileupload.model.File;
import org.springframework.stereotype.Service;

@Service
public interface FileService extends BaseService<File,String> {

    boolean isMd5Exist(String md5);

    int mybaitsSave(File file);

}
