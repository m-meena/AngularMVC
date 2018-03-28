package com.niit.chat.chatterboxback.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chat.chatterboxback.dao.ForumDao;
import com.niit.chat.chatterboxback.model.Forum;

public class ForumTest {

	static Forum forum;
	static ForumDao forumDao;
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.chat.chatterboxback");
		context.refresh();
		forumDao = (ForumDao) context.getBean("forumDao");
	}
	
	@Test
	public void addForumTest()
	{
		forum = new Forum();
		forum.setForumName("chatter");
		forum.setForumContent("welcome");
		forum.setCreationDate(new Date());
		forum.setStatus("enable");
		forum.setUserName("aathi");
		assertEquals("Added", true, forumDao.addForum(forum));
	}
	
	@Test
	public void updateForumTest()
	{
		forum = forumDao.getForum(1);
		forum.setForumName("communication");		
		assertEquals("Updated", true, forumDao.updateForum(forum));
	}
	
	@Test
	public void deleteForumTest()
	{
		forum = forumDao.getForum(1);
		assertEquals("Deleted", true, forumDao.deleteForum(forum));
	}
	
	@Test
	public void listForumTest()
	{
		assertEquals("Display list", 1, forumDao.forumList("aathi").size());
	}
}
