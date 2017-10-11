package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类功能描述:文件处理工具类
 * @className FileUtils.java
 * 
 * @author Allen Gong
 * @version 1.0
 * 
 * @history 2017-01-01 Allen Gong 创建 FileUtils.java
 */
public class FileUtils extends org.apache.commons.io.FileUtils{
	private static final int BUF = 1024;
	private static final String encoding = "UTF-8";
	/**
	 * 下载文件
	 * @param destFileWithPath 带路径的文件（包含绝对路径）
	 * @param response
	 * @throws Exception 
	 */
	public static void downloadFile(String destFileWithPath, String fileName, HttpServletResponse response) throws Exception{
		OutputStream output = null;
        InputStream input = null;
        try {
        	input = new FileInputStream(new File(destFileWithPath));
	        // 设置头信息
	        setResponse(fileName, "pdf", response);
	        response.setHeader("Content-length", String.valueOf(input.available()));
	        // 输出文件
	        output = response.getOutputStream();
	        IOUtils.copy(input, output);
        }  catch (Exception e) {
			throw e;
		} finally{
			try {
				if(output != null){
					output.close();
				}
				if(input != null){
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    /**
     * 设置Response参数
     * @param fileName
     * @param fileType
     * @param response
     * @throws UnsupportedEncodingException
     */
    public static void setResponse(String fileName, String fileType, HttpServletResponse response) throws UnsupportedEncodingException {
        if (fileType.equalsIgnoreCase("doc") || fileType.equalsIgnoreCase("docx")) {
            response.setContentType("application/msword");
        } else if (fileType.equalsIgnoreCase("pdf")) {
            response.setContentType("application/pdf");
        } else if (fileType.equalsIgnoreCase("tif")) {
            response.setContentType("image/tiff");
        } else if (fileType.equalsIgnoreCase("xls") || fileType.equalsIgnoreCase("xlsx")) {
            response.setContentType("application/vnd.ms-excel");
        } else {
            response.setContentType("application/x-download");
        }
        String codeFileName = URLEncoder.encode(fileName, "UTF-8");
        codeFileName = codeFileName.replace("+", "%20");
        response.setHeader("Content-Disposition", "attachment; filename=" + codeFileName);
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        response.setDateHeader("Expires", (System.currentTimeMillis() + 1000));
    }
    
    /**
     * 指定位置开始写入文件
     * @param tempFile  输入文件
     * @param outPath  输出文件的路径(路径+文件名)
     * @throws IOException
     */
    public static void randomAccessFile( String outPath,File tempFile) throws IOException{
        RandomAccessFile  raFile = null;
        BufferedInputStream inputStream=null;
        try{
            File dirFile = new File(outPath);
            //以读写的方式打开目标文件
            raFile = new RandomAccessFile(dirFile, "rw"); 
            raFile.seek(raFile.length());
            inputStream = new BufferedInputStream(new FileInputStream(tempFile));
            byte[] buf = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buf)) != -1) {
                raFile.write(buf, 0, length);
            }
        }catch(Exception e){
            throw new IOException(e.getMessage());
        }finally{
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (raFile != null) {
                    raFile.close();
                }
            }catch(Exception e){
                throw new IOException(e.getMessage());
            }
        }
    }
    
    /**
	 * 使用apache开源包commons-compress压缩文件（可防止中文文件名乱码）
	 * @param files 需要压缩的文件SS
	 * @param zipFile 压缩后的文件
	 */
	public static void doZip(List<File> files, File zipFile){
		if(files==null || files.isEmpty() || zipFile == null){
			log.error("文件压缩失败，未传入被压缩文件");
			return;
		}
		ZipArchiveOutputStream zos = null;
		try{
			zos =(ZipArchiveOutputStream) new ArchiveStreamFactory()
			.createArchiveOutputStream("zip", new FileOutputStream(zipFile)); //or new ZipArchiveOutputStream(new FileOutputStream(path)) 
			zos.setEncoding(encoding);
			String rootPath =files.get(0).getParent();  //获取要压缩文件根路径
			ZipArchiveEntry ze = null;
			for(File f : files){
				if(!f.exists())
					continue;
				ze =new ZipArchiveEntry(getEntryName(f,rootPath));//获取每个文件相对路径,作为在ZIP中路径
				zos.putArchiveEntry(ze);
				//folder
				if(ze.isDirectory()){
					zos.closeArchiveEntry();
					continue;
				}
				FileInputStream fis = null;
				try{
					//file
					fis =new FileInputStream(f);
					IOUtils.copy(fis, zos, BUF);
				} catch (IOException e){
					log.error("文件压缩失败", e);
				} finally {
					if(fis != null){
						fis.close();
					}
					if(zos != null){
						zos.closeArchiveEntry();
					}
				}
			}
		} catch (ArchiveException e){
			log.error("文件压缩失败", e);
		} catch (IOException e){
			log.error("文件压缩失败", e);
		} finally{
			try {
				if(zos != null){
					zos.close();
				}
			} catch (IOException e) {
				log.error("文件压缩失败", e);
			}
		}
	}
	
	/**
	 * 获取文件名
	 * @param file 
	 * @param rootPath
	 * @return
	 */
	private static String getEntryName(File file,String rootPath){
		String entryName;
		String fPath =file.getAbsolutePath();
		if(fPath.indexOf(rootPath)!=-1)
			entryName =fPath.substring(rootPath.length()+1);
		else
			entryName =file.getName();
		
		if(file.isDirectory())
			entryName +="/";//"/"后缀表示entry是文件夹
		return entryName;
	}
	
	/**
	 * 使用apache开源包commons-compress解压文件（可防止中文文件名乱码）
	 * @param zipFilePath 要解压压缩包路径
	 * @param destDirPath 将文件解压到路径
	 */
	public static void unZip(String zipFilePath, String destDirPath){
		if(zipFilePath==null || destDirPath==null){
			log.error("文件解压失败， 未传入解压文件路径或目的解压路径");
			return;
		}
		ZipFile file = null;
		ZipArchiveEntry ze = null;
		try{
			file =new ZipFile(zipFilePath, encoding);
			Enumeration<ZipArchiveEntry> en =file.getEntries();
			while(en.hasMoreElements()){
				ze =en.nextElement();
				File f =new File(destDirPath, ze.getName());//创建完整路径
				if(ze.isDirectory()){
					f.mkdirs();
					continue;
				} else {
					f.getParentFile().mkdirs();
				}
				InputStream is =null;
				OutputStream os = null;
			    try{
			    	is =file.getInputStream(ze);
					os =new FileOutputStream(f);
					IOUtils.copy(is, os, BUF);
			    } catch (IOException e){
			    	log.error("文件解压失败", e);
			    } finally{
			    	if(is != null){
			    		is.close();
			    	}
					if(os != null){
						os.close();
					}
			    }
			}
		}catch(IOException e){
			log.error("文件解压失败", e);
		}finally{
			try {
				if(file != null){
					file.close();
				}
			} catch (IOException e) {
				log.error("文件解压失败", e);
			}
		}
	}

	/**
	 * 判断是否为合法文件类型
	 * @param fileType 文件类型（如：.txt）
	 * @return
	 */
//	public static boolean isLegalFileType(String[] fileTypeArray, String fileType) {
//		for(String meta : fileTypeArray) {
//			if(meta.toLowerCase().equals(fileType.toLowerCase())) {
//				return true;
//			}else {
//				continue;
//			}
//		}
//		return false;
//	}
    
    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);
    public static void  main(String[] args){
//    	StringBuilder sb = new StringBuilder();
//    	for(int i=1; i<62583; i++){
//    		sb.append(i).append(",");
//    	}
//    	log.error(sb.toString());
	}
    
    
}
