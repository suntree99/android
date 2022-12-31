package com.darma1budi.githubuser2;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class UserResponse{

	@SerializedName("items")
	private List<ItemsItem> items;

	public List<ItemsItem> getItems(){
		return items;
	}
}