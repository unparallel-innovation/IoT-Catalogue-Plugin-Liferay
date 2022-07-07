package com.iot_catalogue.portlet.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIPDownloader {
	
	public ZIPDownloader(OutputStream outputStream, ArrayList<FileRequest> fileRequests) {
		_outputStream = outputStream;
		_fileRequests = fileRequests;
	}
	
	
	private static byte[] download(URL url) throws IOException {
	    URLConnection uc = url.openConnection();
	    int len = uc.getContentLength();
	    InputStream is = new BufferedInputStream(uc.getInputStream());
	    try {
	        byte[] data = new byte[len];
	        int offset = 0;
	        while (offset < len) {
	            int read = is.read(data, offset, data.length - offset);
	            if (read < 0) {
	                break;
	            }
	          offset += read;
	        }
	        if (offset < len) {
	            throw new IOException(
	                String.format("Read %d bytes; expected %d", offset, len));
	        }
	        return data;
	    } finally {
	        is.close();
	    }
	}
	
	public void start() throws IOException {
		_zipOut = new ZipOutputStream(_outputStream);
		
		for(FileRequest fileRequest:_fileRequests ) {
			addFileToZIP(fileRequest);
		}
		
		_zipOut.close();
	}
	
	
	private void addFileToZIP(FileRequest fileRequest) throws IOException {
		URL url = new URL(fileRequest.getURL());
		byte[] binaryData = download(url);
        String prepend = "";
        String path = fileRequest.getPath();
        if(path!=null) {
        	prepend = path + "/";
        }       		
        _zipOut.putNextEntry(new ZipEntry(prepend + fileRequest.getFilename()));
        _zipOut.write(binaryData);
	}
	
	private OutputStream _outputStream = null;
	private ArrayList<FileRequest> _fileRequests;
	ZipOutputStream _zipOut;
}
