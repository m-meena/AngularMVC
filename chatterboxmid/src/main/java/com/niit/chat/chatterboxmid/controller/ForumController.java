package com.niit.chat.chatterboxmid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.chat.chatterboxback.dao.ForumDao;
import com.niit.chat.chatterboxback.model.Forum;

@RestController
public class ForumController {

	@Autowired
	ForumDao forumDao;
	
	@PostMapping(value = "/addForum")
	public ResponseEntity<String> addForum(@RequestBody Forum forum)
	{
		forum.setCreationDate(new java.util.Date());
		forum.setUserName("Meena");
		forum.setStatus("A");
		
		if(forumDao.addForum(forum))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/listForum")
	public ResponseEntity<List<Forum>> getListForum()
	{
		List<Forum> listForum = forumDao.forumList("Meena");
		if(listForum.size() > 0)
		{
			return new ResponseEntity<List<Forum>>(listForum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Forum>>(listForum,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/deleteForum/{forumId}")
	public ResponseEntity<String> deleteForum(@PathVariable("forumId") int forumId)
	{
		Forum forum = forumDao.getForum(forumId);
		if(forumDao.deleteForum(forum))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}
	
}
