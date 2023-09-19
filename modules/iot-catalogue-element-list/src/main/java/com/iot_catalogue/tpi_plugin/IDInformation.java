package com.iot_catalogue.tpi_plugin;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class IDInformation {
	private String _id;
	private String lastUpdate;
	private long _lastUpdateTimestamp;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public long get_lastUpdateTimestamp() {
		return _lastUpdateTimestamp;
	}
	public void set_lastUpdateTimestamp(long _lastUpdateTimestamp) {
		this._lastUpdateTimestamp = _lastUpdateTimestamp;
	}
	

	
}
