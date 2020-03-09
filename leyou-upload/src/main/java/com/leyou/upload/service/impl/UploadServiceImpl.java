package com.leyou.upload.service.impl;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.upload.config.UploadProrerties;
import com.leyou.upload.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@EnableConfigurationProperties(UploadProrerties.class)
public class UploadServiceImpl implements UploadService {
    @Autowired
    private FastFileStorageClient storageClient;
    @Autowired
    private UploadProrerties prop;
    //private static final List<String> ALLOW_TYPES= Arrays.asList("image/jpeg","image/png","image/bmp","image/jpg");
    @Override
    public String uploadImage(MultipartFile file) {
        try {
            //校验文件类型
            String contentType=file.getContentType();
            if (!prop.getAllowTypes().contains(contentType)){
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            //校验文件内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image==null){
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            //上传到FastDFS
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(),".");
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);
//            //准备目标路径
//            File dest = new File("D:\\upload",file.getOriginalFilename());
//            //保存到本地
//            file.transferTo(dest);

            //返回路径
           // return "http://imae.leyou.com/"+storePath.getFullPath();
            return prop.getBaseUrl()+storePath.getFullPath();
        } catch (IOException e) {
            log.error("【文件上传】文件上传失败",e);
            throw new LyException(ExceptionEnum.UPLOAD_FILE_ERROR);
        }

    }
}
