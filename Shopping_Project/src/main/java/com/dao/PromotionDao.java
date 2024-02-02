package com.dao;

import java.util.List;

import com.entity.Promotion;

public interface PromotionDao {
	public Promotion insertPromotion(Promotion thePromotion);
	public Promotion findPromotionById(int theId);
	public List<Promotion> findAll();
	public Promotion updatePromotion(Promotion thePromotion);
	public void deletePromotionById(Integer theId);

}
