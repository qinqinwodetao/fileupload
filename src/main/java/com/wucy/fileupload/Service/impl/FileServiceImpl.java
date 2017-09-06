package com.wucy.fileupload.Service.impl;

import com.wucy.fileupload.Dao.FileRepository;
import com.wucy.fileupload.Model.File;
import com.wucy.fileupload.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FileServiceImpl extends BaseServiceImpl<File,String> implements FileService {

	@Autowired
	private FileRepository fileRepository;

	public boolean isMd5Exist(String md5) {
		return fileRepository.exists(md5);
	}

}
