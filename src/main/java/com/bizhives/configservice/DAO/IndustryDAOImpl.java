package com.bizhives.configservice.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bizhives.configservice.VO.IndustryVO;


@Repository
public class IndustryDAOImpl implements IndustryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IndustryVO> search() {
		List<IndustryVO> industryList = new ArrayList<IndustryVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from IndustryVO");
			industryList = (List<IndustryVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return industryList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IndustryVO> findById(int id) {
		List<IndustryVO> industryList = new ArrayList<IndustryVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from IndustryVO where  id = " + id);
			industryList = (List<IndustryVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return industryList;
	}

	@Override
	public void insert(IndustryVO industryVO) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(industryVO);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
