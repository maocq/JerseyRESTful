package com.maocq.restful.dao;

import java.util.List;

import com.maocq.restful.model.Tweet;

public interface ServiceTweetsDAO {
	public List<Tweet> all();
	public Tweet get(Integer id);
	public void add(Tweet tweet);
	public void update(Tweet tweet);
	public void delete(Tweet tweet);
}
