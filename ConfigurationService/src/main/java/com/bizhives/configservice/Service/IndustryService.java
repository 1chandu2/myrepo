package com.bizhives.configservice.Service;

import java.util.List;

import com.bizhives.configservice.VO.IndustryVO;

public interface IndustryService {

	void insert(IndustryVO industryVO);
	
	List<IndustryVO> search();
	
	List<IndustryVO> findById(int id);


}
