package org.agoncal.application.cdbookstore.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BookRepository {

    @PersistenceContext(unitName = "cdbookstorePU")
    private EntityManager em;
}
