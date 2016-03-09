package zw.zj.hiberbate.extend.test;

import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import zw.zj.hibernate.extend.util.HibernateSessionUtil;
import zw.zj.hibernate.model.Member;
import zw.zj.hibernate.model.Order;

public class TestExtends extends TestCase {

	public void testInsert() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionUtil.getSession();
			transaction = session.getTransaction();
			transaction.begin();

			Member m = new Member();   
	        m.setAge(24);   
	        m.setName("Louis");  
	  
	        Order order = new Order();  
	        order.setName("order 1");  
	        order.setNum("order num 1");  
	        order.setMember(m);  
	        
	        Order order2 = new Order();  
	        order2.setName("order 2");  
	        order2.setNum("order num 2");  
	        order2.setMember(m);  
	        
	        m.getOrders().add(order); 
	        m.getOrders().add(order2); 

			session.save(m);
			session.save(order);
			session.save(order2);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			HibernateSessionUtil.TransactionRollback(transaction);
		} finally {
			HibernateSessionUtil.colseSession(session);
		}
	}

	public void testLoadMember() {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionUtil.getSession();
			transaction = session.getTransaction();
			transaction.begin();

			// 必须load当前对象的值,否则出错
			Member m = (Member) session.get(Member.class, "2c908486535a101a01535a101b260000");

			System.out.println(m.getName());
			System.out.println(m.getOrders().size());

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			HibernateSessionUtil.TransactionRollback(transaction);
		} finally {
			HibernateSessionUtil.colseSession(session);
		}
	}
	
	public void testLoadOrder() {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionUtil.getSession();
			transaction = session.getTransaction();
			transaction.begin();

			// 必须load当前对象的值,否则出错
			Order o = (Order) session.get(Order.class, 1);

			System.out.println(o.getName());
			System.out.println(o.getMember().getName());

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			HibernateSessionUtil.TransactionRollback(transaction);
		} finally {
			HibernateSessionUtil.colseSession(session);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public void testHqlQuery() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionUtil.getSession();
			transaction = session.getTransaction();
			transaction.begin();
			// 
			String hql = "from Member as m";
			Query query = session.createQuery(hql);
			List<Member> memberList = query.list();
			for(Member m:memberList){
				System.out.println(m.getName());
				System.out.println(m.getOrders().size());
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			HibernateSessionUtil.TransactionRollback(transaction);
		} finally {
			HibernateSessionUtil.colseSession(session);
		}
	}

}
