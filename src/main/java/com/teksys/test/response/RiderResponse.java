package com.teksys.test.response;

import java.util.Map;
import java.util.Objects;

public class RiderResponse {
	
	private String resMsg;
	
	private String userId;
	
	private Map<String,String> valErrors;

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Map<String, String> getValErrors() {
		return valErrors;
	}

	public void setValErrors(Map<String, String> valErrors) {
		this.valErrors = valErrors;
	}

	@Override
	public String toString() {
		return "RiderResponse [resMsg=" + resMsg + ", userId=" + userId + ", valErrors=" + valErrors + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(resMsg, userId, valErrors);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RiderResponse)) {
			return false;
		}
		RiderResponse other = (RiderResponse) obj;
		return Objects.equals(resMsg, other.resMsg) && Objects.equals(userId, other.userId)
				&& Objects.equals(valErrors, other.valErrors);
	}
	
}
