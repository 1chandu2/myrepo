package com.bizhives.configservice.VO;

public class SubIndustryDTO {
	private String subIndustryName;
	private String subIndustryDesc;
	private int industryId;
	public String getSubIndustryName() {
		return subIndustryName;
	}
	public void setSubIndustryName(String subIndustryName) {
		this.subIndustryName = subIndustryName;
	}
	public String getSubIndustryDesc() {
		return subIndustryDesc;
	}
	public void setSubIndustryDesc(String subIndustryDesc) {
		this.subIndustryDesc = subIndustryDesc;
	}
	public int getIndustryId() {
		return industryId;
	}
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	public SubIndustryDTO(String subIndustryName, String subIndustryDesc, int industryId) {
		//super();
		this.subIndustryName = subIndustryName;
		this.subIndustryDesc = subIndustryDesc;
		this.industryId = industryId;
	}
	public SubIndustryDTO() {
		
	}

}
