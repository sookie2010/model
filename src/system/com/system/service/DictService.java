package com.system.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.model.Dict;
import com.system.model.Dict.DictClause;

@Service
public class DictService extends HibernateDaoSupport implements IDictService {
	
	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	@Transactional
	@Override
	public List<DictClause> getDictClauseList(Dict dict) {
		List<DictClause> dictClauseList = null;
		dict = (Dict) this.getSessionFactory().getCurrentSession().get(Dict.class, dict.getId());
		if(dict != null){
			dictClauseList = dict.getClauses();
			dictClauseList.remove(null);
		}
		return dictClauseList;
	}

	@Transactional
	@Override
	public void saveDictClause(DictClause dictClause) {
		Dict dict = (Dict) this.getSessionFactory().getCurrentSession().get(Dict.class, dictClause.getDict().getId());
		if(dict != null){
			dict.getClauses().add(dictClause);
		}
	}

}
