package edu.fa.business;


import org.apache.log4j.Logger;

import edu.fa.log.LogFactory;
import edu.fa.model.Page;
import edu.fa.model.User;

public class PageVisitor {
	private static final Logger logger = LogFactory.getLogger();

	public void visit(User user, Page page) {
		logger.info(user + " visited " + page);
	}

}

