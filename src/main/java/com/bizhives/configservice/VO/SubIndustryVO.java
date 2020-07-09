package com.bizhives.configservice.VO;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SubIndustries")

public class SubIndustryVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	
	@Column(name="SubIndustryName")
	private String subIndustryName;
	
	@Column(name="SubIndustryDescription")
	private String subIndustryDesc;

	@ManyToOne
	@JoinColumn(name="Industry_Id")
	private IndustryVO industryVO;
	
	
	public IndustryVO getIndustryVO() {
		return industryVO;
	}

	public void setIndustryVO(IndustryVO industryVO) {
		this.industryVO = industryVO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	

}
