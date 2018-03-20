package com.niit.chat.chatterboxback.dao;

import java.util.List;

import com.niit.chat.chatterboxback.model.Forum;

public interface ForumDao {
	public boolean addForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public boolean approveForum(Forum forum);
	public boolean rejectForum(Forum forum);
	public Forum getForum(int forumId);
	public List<Forum> forumList(String userName);
}
