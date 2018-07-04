package org.agoncal.application.cdbookstore.model;

import java.util.logging.Logger;

import javax.persistence.Persistence;

public class JPASchemaGen {
	
	private static final Logger logger = Logger.getLogger(JPASchemaGen.class.getName());
	private static String PERSISTENCE_UNIT_NAME = "cdbookstorePU";
	
	public static void main(String[] args) {

        Persistence.generateSchema(PERSISTENCE_UNIT_NAME, null);
        logger.info("DDL have been generated");
    }
}
