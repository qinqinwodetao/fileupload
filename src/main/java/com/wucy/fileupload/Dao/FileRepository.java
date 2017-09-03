package com.wucy.fileupload.Dao;

import com.wucy.fileupload.Model.File;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileRepository extends JpaRepository<File, String> {

}
