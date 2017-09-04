package com.wucy.fileupload.Service;

import com.wucy.fileupload.Dao.FileRepository;
import com.wucy.fileupload.Model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {


    @Autowired
    private FileRepository fileRepository;

    public boolean isMd5Exist(String md5) {
        return fileRepository.exists(md5);
    }


    public void save (File file){
        fileRepository.save(file);
    }



}
