package uk.org.tombolo.core.utils;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import uk.org.tombolo.core.Provider;

public class ProviderUtils {

	static Session session = HibernateUtil.getSessionFactory().openSession();
	
	public static Provider getTestProvider(){
		return (Provider)session.load(Provider.class, "uk.org.tombolo.test");
	}
	
	public static void save(Provider provider){
		session.beginTransaction();
		// FIXME: This might be inefficient if we are updating the provider over and over again without actually changing it
		session.saveOrUpdate(provider);
		session.getTransaction().commit();
	}

	public static Provider getByLabel(String label){
		Criteria criteria = session.createCriteria(Provider.class);
		Map<String,Object> restrictions = new HashMap<String,Object>();
		restrictions.put("label", label);
		Provider provider = (Provider)criteria.add(Restrictions.allEq(restrictions)).uniqueResult();
		return provider;
	}
}