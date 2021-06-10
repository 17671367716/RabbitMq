package com.example.test;


/**
 * nio 创建文件并写入内容
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class demo2 {

    public static void main(String[] args) throws IOException {

        String content = "12321432";

        Path path = Paths.get("D:\\data\\fileUpload"+ File.separator+"test");
        Path path1 = Paths.get("D:\\data\\fileUpload" + File.separator + "test" + File.separator + "test.log");
        Files.createDirectories(path);
        if(!Files.exists(path)){
            Files.createFile(path1);
        }
        Files.write(path1,content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND,StandardOpenOption.CREATE);
    }
}
