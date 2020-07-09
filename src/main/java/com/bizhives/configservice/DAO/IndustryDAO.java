package com.bizhives.configservice.DAO;

import java.util.List;

import com.bizhives.configservice.VO.IndustryVO;

public interface IndustryDAO {
	List<IndustryVO> search();
	
	List<IndustryVO> findById(int id);

	void insert(IndustryVO industryVO);

}
