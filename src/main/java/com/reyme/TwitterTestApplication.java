package com.reyme;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TwitterTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterTestApplication.class, args);
	}
}

@Configuration
class TwitterConfig {
	
	private static final String TWITTER_KEY = System.getenv("twitterKey");
	private static final String TWITTER_SECRET = System.getenv("twitterSecret");
	
	private static Twitter twitter;
	
	@Bean
	public Twitter initTwitter() {
		return twitter = new TwitterTemplate(TWITTER_KEY, TWITTER_SECRET);
	}
	
	public static Twitter getTwitter() {
		return twitter;
	}
}

@RequestMapping("/users")
@RestController
class TwitterRestController {
	
	/**
	 * Retrieving a user's Twitter profile data
	 * @param username
	 * @return
	 */
	@GetMapping("/{username}")
	public Map<String, Object> getUser(@PathVariable String username) {
		Map<String, Object> map = new HashMap<String, Object>();
		TwitterProfile profile = TwitterConfig.getTwitter().userOperations().getUserProfile(username);
		map.put("username", profile.getName());
		map.put("profileImgUrl", profile.getProfileImageUrl());
		return map;
	}
	
	/**
	 * Reading Twitter timelines
	 * @param username
	 * @return
	 */
	@GetMapping("/{username}/tweets")
	public List<Tweet> getUsersTweets(@PathVariable String username) {
		return TwitterConfig.getTwitter().timelineOperations().getUserTimeline(username);
	}
	
}
