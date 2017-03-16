package com.telek.ghj.dao;

import java.util.List;

import com.telek.ghj.mapping.TStation;

public interface StationDao {
	/**
	 * 获得岗位
	 * @param nature
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public List<TStation> getTstation(String nature,String keyword) throws Exception;
	
	/**
	 * 单个岗位
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TStation getPostion(long id) throws Exception;
}
