package com.zwh.store.utils;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {
	
	public static String location = "F:/uploadImgs";

	/**
     * 上传文件
     * @param file  文件对应的byte数组流   使用file.getBytes()方法可以获取
     * @param filePath  上传文件路径，不包含文件名
     * @param fileName 上传文件名
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+"/"+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

	
}
