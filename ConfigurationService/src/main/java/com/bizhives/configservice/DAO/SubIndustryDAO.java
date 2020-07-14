package com.bizhives.configservice.DAO;

import java.util.List;

import com.bizhives.configservice.VO.SubIndustryVO;

public interface SubIndustryDAO {
void insertSubIndustry(SubIndustryVO subIndustryVO);
	
	List<SubIndustryVO> searchSubIndustry();
	
	List<SubIndustryVO> findSubIndustryById(int id);

}
