package com.iot_catalogue.portlet.utils;

public class FileRequest {
	
	public FileRequest(String url, String filename, String path) {
		_url = url;
		_filename = filename;
		_path = path;
	}

	public String getURL() {
		return _url;
	}
	
	public String getFilename() {
		return _filename;
	}
	
	public String getPath() {
		return _path;
	}
	
	private String _url;

	private String _filename;	
	private String _path;
}
