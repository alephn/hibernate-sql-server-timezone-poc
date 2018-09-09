
package com.alephn.standalonetimezonejpa.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "calls")
@Entity
public class Call implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final DateTimeFormatter FORMATTER_TO_DB_ISO8601 = DateTimeFormatter.ofPattern(
		      "yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

	@Id
	@Column(name = "id", nullable = false, unique=true)
	private String id;
	
	@Column(name = "fromNumber", nullable = false, unique=false)
	private String fromNumber;
	
	@Column(name = "toNumber", nullable = false, unique=false)
	private String toNumber;
	
	transient ZonedDateTime zonedDateTime;
	
	@Column(name = "timestamp", nullable = false, unique=false)
	private String strTimestamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFromNumber() {
		return fromNumber;
	}

	public void setFromNumber(String fromNumber) {
		this.fromNumber = fromNumber;
	}

	public String getToNumber() {
		return toNumber;
	}

	public void setToNumber(String toNumber) {
		this.toNumber = toNumber;
	}

	public ZonedDateTime getZonedDateTime() {
		return zonedDateTime;
	}

	public void setZonedDateTime(ZonedDateTime zonedDateTime) {
		this.zonedDateTime = zonedDateTime;
		if (zonedDateTime == null) {
            strTimestamp = null;
        }
        strTimestamp = zonedDateTime.format(FORMATTER_TO_DB_ISO8601);
		
	}

	public String getStrTimestamp() {
		return strTimestamp;
	}

	public void setStrTimestamp(String strTimestamp) {
		this.strTimestamp = strTimestamp;
	}

	@Override
	public String toString() {
		return "Call [id=" + id + ", from=" + fromNumber + ", to=" + toNumber+", at=" + strTimestamp +"]";
	}
}
