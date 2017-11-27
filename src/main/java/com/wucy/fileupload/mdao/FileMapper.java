package com.wucy.fileupload.mdao;

import com.wucy.fileupload.model.File;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by wucy
 * Date: 2017-10-12 18:12:00
 * Descript: fileMapper
 */
@Component
@Mapper
public interface FileMapper {

	@Insert("insert into file(MD5, file_name,upload_date) values(#{MD5},#{fileName},#{uploadDate})")
	int save(File file);

}
