package com.chengxuunion.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import com.chengxuunion.common.exception.BaseException;


/**
 * 文件工具类
 *
 * @author kutome
 * @date 2018年8月31日
 * @version V1.0
 */
public class FileUtils {

	/**
	 * 如果指定的路径不存在则创建，否则不做任何处理
	 * 
	 * @param path
	 */
	public static void mkdir(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	/**
	 * 删除指定路径的文件
	 * 
	 * @param path
	 */
	public static void deleteFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		
		file.delete();
	}
	
	/**
	 * 获取文件后缀
	 * 
	 * @param fileName	文件名，例 你好.doc
	 * @return	例 doc
	 */
	public static String getSuffix(String fileName) {
		if (fileName.contains(".")) {
			return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		} 
		
		return "";
	}
	
	/**
	 * 下载文件
	 * 
	 * @param response	输出流
	 * @param filePath	文件绝对路径
	 * @param fileName	文件名称
	 * @throws BaseException
	 */
	public static void downloadFile(HttpServletResponse response, String filePath, String fileName) throws BaseException {
		File file = new File(filePath);
		if (!file.exists()) {
			throw new BaseException("文件不存在");
		}
		OutputStream toClient = null;
		InputStream fis = null;
		try {
			fis = new BufferedInputStream(new FileInputStream( file));   
            //response.reset();   
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename="+ new String(fileName.getBytes("utf-8"),"ISO-8859-1"));
            response.addHeader("Content-Length", "" + file.length());   
            response.setContentType("application/octet-stream;charset=UTF-8");
            toClient = new BufferedOutputStream(response.getOutputStream());  
            byte[] buffer = new byte[1024 * 4];   
            int i = -1;   
            while ((i = fis.read(buffer)) != -1) {   
                toClient.write(buffer, 0, i);  
            }   
            fis.close();   
            toClient.flush();   
            toClient.close();
            //response.wait();
		} catch (Exception e) {
			throw new BaseException(e.getMessage());
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (toClient != null) {
				try {
					toClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
