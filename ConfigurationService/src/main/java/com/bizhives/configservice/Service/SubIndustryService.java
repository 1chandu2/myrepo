package com.bizhives.configservice.Service;

import java.util.List
;

import com.bizhives.configservice.VO.SubIndustryVO;

public interface SubIndustryService {
void insertSubIndustry(SubIndustryVO subIndustryVO);
	
	List<SubIndustryVO> searchSubIndustry();
	
	List<SubIndustryVO> findSubIndustryById(int id);


}
