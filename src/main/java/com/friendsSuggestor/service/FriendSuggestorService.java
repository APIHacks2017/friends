package com.friendsSuggestor.service;

import java.util.List;
import java.util.Map;

import com.friendsSuggestor.model.FriendSuggestor;

public interface FriendSuggestorService {

	public FriendSuggestor save(FriendSuggestor friendSuggestor);
	public FriendSuggestor read(String name, String identification);
	public void individualClear();
	public Map<Integer,String> readall();
	public List<FriendSuggestor> readallDBEntries();
	public void groupClear();
	public FriendSuggestor findFriendSuggestorByFaceId(String faceId);
}

