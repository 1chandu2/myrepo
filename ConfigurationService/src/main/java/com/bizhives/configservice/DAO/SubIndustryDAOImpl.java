package com.bizhives.configservice.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bizhives.configservice.VO.SubIndustryVO;


@Repository

public class SubIndustryDAOImpl implements SubIndustryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public void insertSubIndustry(SubIndustryVO subIndustryVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(subIndustryVO);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubIndustryVO> searchSubIndustry() {
		List<SubIndustryVO> subIndustryList = new ArrayList<SubIndustryVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from SubIndustryVO");
			subIndustryList = (List<SubIndustryVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subIndustryList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubIndustryVO> findSubIndustryById(int id) {
		List<SubIndustryVO> subIndustryList = new ArrayList<SubIndustryVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from SubIndustryVO where  Industry_Id = " + id);
			subIndustryList = (List<SubIndustryVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subIndustryList;
	}

}
