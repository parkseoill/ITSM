package truebon.com.fai.prd.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FailPeriodVO extends FailPeriod implements Serializable  {
	private int p1;
	private int p2;
	private int p3;
	private int p4;
	private int p5;
	/* 분 배열 */
	private String[] totalMinutes;
	private String calculatedMinutes;
	/* 업무시스템 이름 */
	private String bizSytmNm;
	/* 장애등급 이름 */
	private String failrGrdNm;
	/* 검색조건 사용여부 */
	private String searchUseYn;
	
	public int getP1() {
		return p1;
	}
	public void setP1(int p1) {
		this.p1 = p1;
	}
	public int getP2() {
		return p2;
	}
	public void setP2(int p2) {
		this.p2 = p2;
	}
	public int getP3() {
		return p3;
	}
	public void setP3(int p3) {
		this.p3 = p3;
	}
	public int getP4() {
		return p4;
	}
	public void setT4(int p4) {
		this.p4 = p4;
	}
	public int getP5() {
		return p5;
	}
	public void setP5(int p5) {
		this.p5 = p5;
	}
	public String[] getTotalMinutes() {
		return totalMinutes;
	}
	public void setTotalMinutes(String[] totalMinutes) {
		this.totalMinutes = totalMinutes;
	}
	public String getCalculatedMinutes() {
		return calculatedMinutes;
	}
	public void setCalculatedMinutes(String calculatedMinutes) {
		this.calculatedMinutes = calculatedMinutes;
	}
	public String getBizSytmNm() {
		return bizSytmNm;
	}
	public void setBizSytmNm(String bizSytmNm) {
		this.bizSytmNm = bizSytmNm;
	}
	public String getFailrGrdNm() {
		return failrGrdNm;
	}
	public void setFailrGrdNm(String failrGrdNm) {
		this.failrGrdNm = failrGrdNm;
	}
	public String getSearchUseYn() {
		return searchUseYn;
	}
	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}
}
