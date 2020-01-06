/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.tshimx.fnb.utils;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import za.co.tshimx.fnb.domain.Person;




public class HibernateDatabaseAccess {
final static Logger logger = Logger.getLogger(HibernateDatabaseAccess.class);
    public Person getPersonDetails() {
        HibernateUtil hibernateUtil = new  HibernateUtil();
        SessionFactory sessionFactory = hibernateUtil.getSessionJavaConfigFactory();
        Session session = sessionFactory.getCurrentSession();
        
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Person.class);
        criteria.add(Restrictions.eq("id", 1));

        Person person = (Person) criteria.uniqueResult();

        if (person != null) {
            logger.info("Person found:");
            
        }
        session.getTransaction().commit();
        //sessionFactory.close();
        return person;
    }

}