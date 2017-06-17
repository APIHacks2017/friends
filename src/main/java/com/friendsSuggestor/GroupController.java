package com.friendsSuggestor;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.friendsSuggestor.model.FriendSuggestor;
import com.friendsSuggestor.service.FriendSuggestorService;


public class GroupController {
	@Autowired
	FriendSuggestorService suggestorService;
	String praveen="praveen";
	String vinoth="vinoth";
	String senthil="senthil";		
			
	@RequestMapping("/readimage")
	public FriendSuggestor readimage(String name) {
		FriendSuggestor friendSuggestor = suggestorService.read(name);
		return friendSuggestor;
	}
	
	@RequestMapping("/readallname")
	public String readallName(Map<String, Object> model){
		Map<Integer,String> mapValue = suggestorService.readall();
		model.put("firstName", mapValue.get(0));
		model.put("secondName", mapValue.get(1));
		return  "suggestFriend";
	}
	

}

