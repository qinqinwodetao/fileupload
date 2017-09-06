package com.wucy.fileupload.Service;

import com.wucy.fileupload.Model.File;
import org.springframework.stereotype.Service;

@Service
public interface FileService extends BaseService<File,String> {

    boolean isMd5Exist(String md5);

}
