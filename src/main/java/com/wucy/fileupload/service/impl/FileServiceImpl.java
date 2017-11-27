package com.wucy.fileupload.service.impl;

import com.wucy.fileupload.hdao.FileRepository;
import com.wucy.fileupload.mdao.FileMapper;
import com.wucy.fileupload.model.File;
import com.wucy.fileupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FileServiceImpl extends BaseServiceImpl<File,String> implements FileService {

	@Autowired
	private FileRepository fileRepository;

	@Autowired
	private FileMapper fileMapper;

	@Override
	public boolean isMd5Exist(String md5) {
		return fileRepository.exists(md5);
	}

	@Override
	public int mybaitsSave(File file) {
		return fileMapper.save(file);
	}

}
