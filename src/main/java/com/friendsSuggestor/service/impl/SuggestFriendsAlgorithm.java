package com.friendsSuggestor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.friendsSuggestor.api.CompareFaceService;
import com.friendsSuggestor.api.SearchFaceByFaceId;
import com.friendsSuggestor.model.FriendSuggestor;

public class SuggestFriendsAlgorithm {
	
	@Autowired
	CompareFaceService compareFaceService;
	
	@Autowired
	SearchFaceByFaceId searchFaceByFaceId;
	
	@Autowired
	FriendSuggestorServiceImpl friendSuggestorServiceImpl;
	
	public List<String> suggestFriends(String faceId,String groupPhoto1,String groupPhoto2){
		List<String> listFaceid=new ArrayList<String>();
		List<FriendSuggestor> listFriendSuggestor=friendSuggestorServiceImpl.readallDBEntries();
		//check with the loggedinuser faceId is available in groupPhoto1 and groupPhoto2
		if(searchFaceByFaceId.searchFaceByFaceId(faceId, groupPhoto1) && searchFaceByFaceId.searchFaceByFaceId(faceId, groupPhoto2)){
			for(FriendSuggestor friendSuggestor:listFriendSuggestor){
				if(friendSuggestor.getFaceId()==faceId){
					//don't compare the logged in user faceid itself
					continue;
				}else{
					if(searchFaceByFaceId.searchFaceByFaceId(friendSuggestor.getFaceId(), groupPhoto1)||searchFaceByFaceId.searchFaceByFaceId(friendSuggestor.getFaceId(), groupPhoto2)){
						listFaceid.add(friendSuggestor.getFaceId());
					}
				}
				
			}
		}
		return listFaceid;
	}

}
