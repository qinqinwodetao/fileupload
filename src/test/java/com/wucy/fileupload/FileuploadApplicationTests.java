package com.wucy.fileupload;

import com.wucy.fileupload.job.WhoisFetch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileuploadApplicationTests {
	Logger logger = LoggerFactory.getLogger(FileuploadApplicationTests.class);


	@Test
	public void contextLoads() {


		WhoisFetch wf = new WhoisFetch();

		wf.timerRate();
	}

}
