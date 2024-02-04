package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dao.PushNotificationDao;
import com.entity.PushNotification;

public class PushNotificationDaoImpl implements PushNotificationDao {
	
	private Session session;
	
	

	public PushNotificationDaoImpl(Session session) {
		this.session = session;
	}


	@Override
	public List<PushNotification> findAllPushNotifications() {
		String hql = "FROM PushNotification";
        Query<PushNotification> query = session.createQuery(hql, PushNotification.class);
        List<PushNotification> lis = query.list();
        return lis;   
	}


	@Override
	public void insertNotification(PushNotification thePushNotification) {
		session.persist(thePushNotification);
	}


	@Override
	public void updateNotification(PushNotification thePushNotification) {
		session.merge(thePushNotification);
		
	}


	@Override
	public PushNotification findPushNotificationById(Integer theId) {
		PushNotification thePushNotification = session.get(PushNotification.class, theId);
		return thePushNotification;
	}

}
