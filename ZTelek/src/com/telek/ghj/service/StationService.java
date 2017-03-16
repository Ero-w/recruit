package com.telek.ghj.service;

import java.util.List;

import com.telek.ghj.mapping.TStation;

public interface StationService {
	public List<TStation> getTstation(String nature,String keyword) throws Exception;

	public TStation getPostion(long id) throws Exception;
}
