package com.bizhives.configservice.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bizhives.configservice.DAO.SubIndustryDAO;
import com.bizhives.configservice.VO.SubIndustryVO;


@Service
@Transactional

public class SubIndustryServiceImpl implements SubIndustryService {


	@Autowired SubIndustryDAO subIndustryDAO;
	@Override
	public void insertSubIndustry(SubIndustryVO subIndustryVO) {
		this.subIndustryDAO.insertSubIndustry(subIndustryVO);
	}

	@Override
	public List<SubIndustryVO> searchSubIndustry() {
		return this.subIndustryDAO.searchSubIndustry();
	}

	@Override
	public List<SubIndustryVO> findSubIndustryById(int id) {
		return this.subIndustryDAO.findSubIndustryById(id);
	}

}
