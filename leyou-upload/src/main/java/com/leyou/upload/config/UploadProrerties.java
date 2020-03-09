package com.leyou.upload.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
/*@Component
@Primary*/
@ConfigurationProperties(prefix = "leyou.upload")
public class UploadProrerties {
    private String baseUrl;
    private List<String> allowTypes;
}
