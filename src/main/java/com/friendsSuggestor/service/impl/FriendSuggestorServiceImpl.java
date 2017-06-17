package com.friendsSuggestor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendsSuggestor.model.FriendSuggestor;
import com.friendsSuggestor.repository.FriendSuggestorRepository;
import com.friendsSuggestor.service.FriendSuggestorService;



@Service
public class FriendSuggestorServiceImpl implements FriendSuggestorService {

	@Autowired	FriendSuggestorRepository friendSuggestorRepository;
	
	public FriendSuggestor save(FriendSuggestor friendSuggestor){
		FriendSuggestor frndSuggt = new FriendSuggestor();
		frndSuggt = friendSuggestorRepository.save(friendSuggestor);
		return frndSuggt;
	}

	@Override
	public FriendSuggestor read(String name, String identification) {
		FriendSuggestor friendSuggestor=friendSuggestorRepository.findFriendSuggestorByNameAndIdentification(name,identification);
		return friendSuggestor;
	}
	
	
	public void individualClear(){
		List<FriendSuggestor> indListFriendSuggestor = (List<FriendSuggestor>) friendSuggestorRepository.findAll();
		for(FriendSuggestor f : indListFriendSuggestor){
			if(f.getIdentification().equals("I")){
				friendSuggestorRepository.delete(f);
			}
		}
	}
	
	public void groupClear(){
		List<FriendSuggestor> indListFriendSuggestor = (List<FriendSuggestor>) friendSuggestorRepository.findAll();
		for(FriendSuggestor f : indListFriendSuggestor){
			if(f.getIdentification().equals("G")){
				friendSuggestorRepository.delete(f);
			}
		}
	}
	
	public Map<Integer,String> readall(){
		List<FriendSuggestor> friendSuggestor=(List<FriendSuggestor>) friendSuggestorRepository.findAll();
		System.out.println("Friendsuggestor"+friendSuggestor);
		int senthilCount = 0;
		int praveenCount = 0;
		int vinothCount = 0;
		int mapId = 1;
		Map<Integer,String> mapValue = new HashMap<Integer,String>();
		for(FriendSuggestor friendobj : friendSuggestor){
			System.out.println("friendobj = = >"+friendobj);
			System.out.println("friendobj = = >"+friendobj.getId());
			System.out.println("friendobj = = >"+friendobj.getIdentification());
			if(friendobj.getIdentification().equalsIgnoreCase("G")){
				String[] splitvalue = friendobj.getName().toString().split("_");
				for(int i=0;i<splitvalue.length;i++){
				if("senthil".equalsIgnoreCase(splitvalue[i])){
					senthilCount++;
				}
				if("praveen".equalsIgnoreCase(splitvalue[i])){
									praveenCount++;
								}
				if("vinoth".equalsIgnoreCase(splitvalue[i])){
					vinothCount++;
				}
				}
				
			}
		}
		System.out.println(senthilCount);
		System.out.println(praveenCount);
		System.out.println(vinothCount);
		if(senthilCount==1){
			mapValue.put(mapId, "Senthil");
			mapId++;
		}
		if(praveenCount==1){
			mapValue.put(mapId, "Praveen");
			mapId++;
		}
		if(vinothCount==1){
			mapValue.put(mapId, "Vinoth");
		}
		
		return mapValue;
	}

	@Override
	public List<FriendSuggestor> readallDBEntries() {
		return (List<FriendSuggestor>) friendSuggestorRepository.findAll();
	}

	@Override
	public FriendSuggestor findFriendSuggestorByFaceId(String faceId) {
		return friendSuggestorRepository.findFriendSuggestorByFaceId(faceId);
	}
}
