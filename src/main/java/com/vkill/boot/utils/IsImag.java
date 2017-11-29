package com.vkill.boot.utils;


import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

@SuppressWarnings("ConstantConditions")
public class IsImag {
    public static boolean isImage(MultipartFile tempFile)
            throws Exception {

        InputStream is = tempFile.getInputStream();
        BufferedImage bi=ImageIO.read(is);
        Image im = bi;
        return im != null;
    }
}
