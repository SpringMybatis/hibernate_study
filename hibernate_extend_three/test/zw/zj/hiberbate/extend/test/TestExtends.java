package zw.zj.hiberbate.extend.test;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;

import zw.zj.hibernate.extend.model.Dog;
import zw.zj.hibernate.extend.model.Pig;
import zw.zj.hibernate.extend.util.HibernateSessionUtil;

public class TestExtends extends TestCase{

	
	public void testInsert(){
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionUtil.getSession();
			transaction = session.getTransaction();
			transaction.begin();
			
			Dog d = new Dog();
			d.setName("狗狗");
			d.setSex(true);
			d.setHeight(500);
			
			session.save(d);
			
			Pig p =  new Pig();
			p.setName("猪猪");
			p.setSex(false);
			p.setWeight(800);
			
			session.save(p);
			
			transaction.commit();
		} catch (Exception e) {
			HibernateSessionUtil.TransactionRollback(transaction);
		} finally {
			HibernateSessionUtil.colseSession(session);
		}
	}
	
	
	public void testLoad(){
		
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionUtil.getSession();
			transaction = session.getTransaction();
			transaction.begin();
			
			Dog d = (Dog) session.load(Dog.class, 1);
			
			System.out.println(d.getHeight());
			
			transaction.commit();
		} catch (Exception e) {
			HibernateSessionUtil.TransactionRollback(transaction);
		} finally {
			HibernateSessionUtil.colseSession(session);
		}
	}

}
