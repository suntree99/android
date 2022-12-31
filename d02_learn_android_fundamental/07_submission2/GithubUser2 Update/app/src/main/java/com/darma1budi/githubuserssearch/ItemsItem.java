package com.darma1budi.githubuserssearch;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ItemsItem implements Parcelable {

	@SerializedName("gists_url")
	private String gistsUrl;

	@SerializedName("repos_url")
	private String reposUrl;

	@SerializedName("following_url")
	private String followingUrl;

	@SerializedName("starred_url")
	private String starredUrl;

	@SerializedName("login")
	private String login;

	@SerializedName("followers_url")
	private String followersUrl;

	@SerializedName("type")
	private String type;

	@SerializedName("url")
	private String url;

	@SerializedName("subscriptions_url")
	private String subscriptionsUrl;

	@SerializedName("score")
	private int score;

	@SerializedName("received_events_url")
	private String receivedEventsUrl;

	@SerializedName("avatar_url")
	private String avatarUrl;

	@SerializedName("events_url")
	private String eventsUrl;

	@SerializedName("html_url")
	private String htmlUrl;

	@SerializedName("site_admin")
	private boolean siteAdmin;

	@SerializedName("id")
	private int id;

	@SerializedName("gravatar_id")
	private String gravatarId;

	@SerializedName("node_id")
	private String nodeId;

	@SerializedName("organizations_url")
	private String organizationsUrl;

	protected ItemsItem(Parcel in) {
		gistsUrl = in.readString();
		reposUrl = in.readString();
		followingUrl = in.readString();
		starredUrl = in.readString();
		login = in.readString();
		followersUrl = in.readString();
		type = in.readString();
		url = in.readString();
		subscriptionsUrl = in.readString();
		score = in.readInt();
		receivedEventsUrl = in.readString();
		avatarUrl = in.readString();
		eventsUrl = in.readString();
		htmlUrl = in.readString();
		siteAdmin = in.readByte() != 0;
		id = in.readInt();
		gravatarId = in.readString();
		nodeId = in.readString();
		organizationsUrl = in.readString();
	}

	public static final Creator<ItemsItem> CREATOR = new Creator<ItemsItem>() {
		@Override
		public ItemsItem createFromParcel(Parcel in) {
			return new ItemsItem(in);
		}

		@Override
		public ItemsItem[] newArray(int size) {
			return new ItemsItem[size];
		}
	};

	public String getGistsUrl(){
		return gistsUrl;
	}

	public String getReposUrl(){
		return reposUrl;
	}

	public String getFollowingUrl(){
		return followingUrl;
	}

	public String getStarredUrl(){
		return starredUrl;
	}

	public String getLogin(){
		return login;
	}

	public String getFollowersUrl(){
		return followersUrl;
	}

	public String getType(){
		return type;
	}

	public String getUrl(){
		return url;
	}

	public String getSubscriptionsUrl(){
		return subscriptionsUrl;
	}

	public int getScore(){
		return score;
	}

	public String getReceivedEventsUrl(){
		return receivedEventsUrl;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public String getEventsUrl(){
		return eventsUrl;
	}

	public String getHtmlUrl(){
		return htmlUrl;
	}

	public boolean isSiteAdmin(){
		return siteAdmin;
	}

	public int getId(){
		return id;
	}

	public String getGravatarId(){
		return gravatarId;
	}

	public String getNodeId(){
		return nodeId;
	}

	public String getOrganizationsUrl(){
		return organizationsUrl;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(gistsUrl);
		parcel.writeString(reposUrl);
		parcel.writeString(followingUrl);
		parcel.writeString(starredUrl);
		parcel.writeString(login);
		parcel.writeString(followersUrl);
		parcel.writeString(type);
		parcel.writeString(url);
		parcel.writeString(subscriptionsUrl);
		parcel.writeInt(score);
		parcel.writeString(receivedEventsUrl);
		parcel.writeString(avatarUrl);
		parcel.writeString(eventsUrl);
		parcel.writeString(htmlUrl);
		parcel.writeByte((byte) (siteAdmin ? 1 : 0));
		parcel.writeInt(id);
		parcel.writeString(gravatarId);
		parcel.writeString(nodeId);
		parcel.writeString(organizationsUrl);
	}
}