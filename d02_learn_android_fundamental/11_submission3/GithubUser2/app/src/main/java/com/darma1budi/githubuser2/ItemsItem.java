package com.darma1budi.githubuser2;

import com.google.gson.annotations.SerializedName;

public class ItemsItem{

	@SerializedName("followers")
	private String followers;

	@SerializedName("avatar_url")
	private String avatarUrl;

	@SerializedName("following")
	private String following;

	@SerializedName("following_url")
	private String followingUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private String location;

	@SerializedName("company")
	private String company;

	@SerializedName("id")
	private int id;

	@SerializedName("public_repos")
	private String publicRepos;

	@SerializedName("login")
	private String login;

	@SerializedName("type")
	private String type;

	@SerializedName("followers_url")
	private String followersUrl;

	public String getFollowers(){
		return followers;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public String getFollowing(){
		return following;
	}

	public String getFollowingUrl(){
		return followingUrl;
	}

	public String getName(){
		return name;
	}

	public String getLocation(){
		return location;
	}

	public String getCompany(){
		return company;
	}

	public int getId(){
		return id;
	}

	public String getPublicRepos(){
		return publicRepos;
	}

	public String getLogin(){
		return login;
	}

	public String getType(){
		return type;
	}

	public String getFollowersUrl(){
		return followersUrl;
	}
}