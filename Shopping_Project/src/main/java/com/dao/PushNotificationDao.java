package com.dao;

import java.util.List;

import com.entity.PushNotification;

public interface PushNotificationDao {
	public List<PushNotification> findAllPushNotifications();
	
	public void insertNotification(PushNotification thePushNotification);
	
	public void updateNotification(PushNotification thePushNotification);
	
	public PushNotification findPushNotificationById(Integer theId);
}
