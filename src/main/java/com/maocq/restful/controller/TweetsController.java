package com.maocq.restful.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.maocq.restful.dao.ServiceTweets;
import com.maocq.restful.dao.ServiceTweetsDAO;
import com.maocq.restful.model.Tweet;



@Path("tweets")
@Produces(MediaType.APPLICATION_JSON)
public class TweetsController {

	private static final ServiceTweetsDAO Tweet = new ServiceTweets();

	@GET
	@Path("/{tweetId}")
	// @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Tweet getTweet(@PathParam("tweetId") Integer id) throws NotFoundException {
		Tweet tweet = Tweet.get(id);
		if (tweet == null) 
			throw new NotFoundException("Tweet no encontrado");
		return tweet;
	}

	@GET
	public List<Tweet> getTweets(@QueryParam("q") String q) {
		System.out.println(q);
		return Tweet.all();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTweet(@Valid Tweet tweet) {
		Tweet.add(tweet);
		return Response.status(Response.Status.CREATED).entity(tweet).build();
	}

	@PUT
	@Path("/{tweetId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Tweet editTweet(@PathParam("tweetId") Integer id, Tweet tweet) {
		tweet.setId(id);
		Tweet.update(tweet);
		return tweet;
	}

	@DELETE
	@Path("/{tweetId}")
	public void deleteTweet(@PathParam("tweetId") Integer id) {
		Tweet tw = new Tweet();
		tw.setId(id);
		Tweet.delete(tw);
	}

}
