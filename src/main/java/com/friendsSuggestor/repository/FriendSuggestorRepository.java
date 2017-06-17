package com.friendsSuggestor.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.friendsSuggestor.model.FriendSuggestor;




public interface FriendSuggestorRepository extends CrudRepository <FriendSuggestor,BigInteger>  {

	public FriendSuggestor findFriendSuggestorByNameAndIdentification(String name, String identification);
	public FriendSuggestor findFriendSuggestorByFaceId(String faceId);
}
