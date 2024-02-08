package com.ezio.Common;




public class AppJsonResponse {
	
	
	private Integer dailyBooking;
	private Integer weeklyBooking;
	private Integer monthlyBooking;
	private Integer yearlyBooking;
	private Integer ConfirmedBooking;
	
	public Integer getConfirmedBooking() {
		return ConfirmedBooking;
	}
	public void setConfirmedBooking(Integer confirmedBooking) {
		ConfirmedBooking = confirmedBooking;
	}
	
	
	public Integer getYearlyBooking() {
		return yearlyBooking;
	}
	public void setYearlyBooking(Integer yearlyBooking) {
		this.yearlyBooking = yearlyBooking;
	}
	public Integer getDailyBooking() {
		return dailyBooking;
	}
	public void setDailyBooking(Integer dailyBooking) {
		this.dailyBooking = dailyBooking;
	}
	public Integer getWeeklyBooking() {
		return weeklyBooking;
	}
	public void setWeeklyBooking(Integer weeklyBooking) {
		this.weeklyBooking = weeklyBooking;
	}
	public Integer getMonthlyBooking() {
		return monthlyBooking;
	}
	public void setMonthlyBooking(Integer monthlyBooking) {
		this.monthlyBooking = monthlyBooking;
	}
	private String message;
	private String value;
	private String status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AppJsonResponse [dailyBooking=" + dailyBooking + ", weeklyBooking=" + weeklyBooking
				+ ", monthlyBooking=" + monthlyBooking + ", yearlyBooking=" + yearlyBooking + ", message=" + message
				+ ", value=" + value + ", status=" + status + "]";
	}
	
	

}
