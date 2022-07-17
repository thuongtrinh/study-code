package edu.fa.business;

import org.apache.log4j.Logger;

import edu.fa.log.LogFactory;
import edu.fa.model.Page;
import edu.fa.model.User;

public class Main {
	private static final Logger logger = LogFactory.getLogger();

	public static void main(String [] args) {
		Page page = new Page("Homepage", "http://fresher.academy");
		User [] users = new User[2017];
		for(int i = 0; i < users.length; i++) {
			users[i] = new User("User " + i);
			logger.error(users[i] + " signed in");
		}
		
		PageVisitor pageVisitor = new PageVisitor();
		int index = 0;
		int i = 0;
		while(true) {
			index = (int) Math.round((Math.random() * 2016));
			pageVisitor.visit(users[index], page);
		}
	}
}




