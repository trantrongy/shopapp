package com.onlineshop.shopapp.util;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class StoreFile {
    public static String storeFile(MultipartFile file) throws IOException {
        //lấy tên file
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //dùng random UUID
        String uniqueFileName = UUID.randomUUID().toString() + "-"+ fileName;
        Path uploadPath = Paths.get("uploads");
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        //duong dan
        Path pathFile = Paths.get(uploadPath.toString(), uniqueFileName);
        Files.copy(file.getInputStream(),pathFile, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFileName;
    }
}
