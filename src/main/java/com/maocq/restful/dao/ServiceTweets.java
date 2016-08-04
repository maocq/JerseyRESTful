package com.maocq.restful.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.maocq.restful.model.Tweet;

public class ServiceTweets implements ServiceTweetsDAO {

	public ServiceTweets() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tweet> all() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceJersey");
		EntityManager manager = emf.createEntityManager();

		List<Tweet> tweets = (List<Tweet>) manager.createQuery("SELECT t FROM Tweet t").getResultList();
		// System.out.println("Numero de usuarios: " + tweets.size());

		manager.close();
		emf.close();

		return tweets;
	}

	@Override
	public Tweet get(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceJersey");
		EntityManager manager = emf.createEntityManager();

		Tweet tweet = manager.find(Tweet.class, id);

		manager.close();
		emf.close();

		return tweet;
	}

	@Override
	public void add(Tweet tweet) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceJersey");
		EntityManager manager = emf.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(tweet);
		manager.getTransaction().commit();
		
		manager.close();
		emf.close();
	}

	@Override
	public void update(Tweet tweet) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceJersey");
		EntityManager manager = emf.createEntityManager();

		manager.getTransaction().begin();
		
		Tweet tw = manager.find(Tweet.class, tweet.getId());
		tw.setTweet(tweet.getTweet());
		
		manager.getTransaction().commit();

		manager.close();
		emf.close();
	}

	@Override
	public void delete(Tweet tweet) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceJersey");
		EntityManager manager = emf.createEntityManager();

		manager.getTransaction().begin();
		Tweet tw = manager.find(Tweet.class, tweet.getId());
		manager.remove(tw);
		manager.getTransaction().commit();
		
		manager.close();
		emf.close();
	}

}
