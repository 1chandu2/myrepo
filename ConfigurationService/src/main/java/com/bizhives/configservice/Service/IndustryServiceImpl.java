package com.bizhives.configservice.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizhives.configservice.DAO.IndustryDAO;
import com.bizhives.configservice.VO.IndustryVO;

@Service
@Transactional

public class IndustryServiceImpl  implements IndustryService{

	@Autowired IndustryDAO industryDAO;
	
	@Override
	public void insert(IndustryVO industryVO) {
		this.industryDAO.insert(industryVO);
	}

	@Override
	public List<IndustryVO> search() {
		return this.industryDAO.search();
	}

	@Override
	public List<IndustryVO> findById(int id) {
		return this.industryDAO.findById(id);
	}

}
