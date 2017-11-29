package com.vkill.boot.service.impl;

import com.vkill.boot.hdao.FileRepository;
import com.vkill.boot.mdao.FileMapper;
import com.vkill.boot.model.File;
import com.vkill.boot.service.FileService;
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
