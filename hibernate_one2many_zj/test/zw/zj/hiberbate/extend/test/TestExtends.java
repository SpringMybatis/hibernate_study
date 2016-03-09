package zw.zj.hiberbate.extend.test;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;

import zw.zj.hibernate.extend.util.HibernateSessionUtil;
import zw.zj.hibernate.model.Member;

public class TestExtends extends TestCase {

	public void testInsert() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionUtil.getSession();
			transaction = session.getTransaction();
			transaction.begin();

			Member rootMem = new Member();
			rootMem.setName("parent");
			rootMem.setAge(48);
			
			
			Member childMem = new Member();
			childMem.setName("child");
			childMem.setAge(24);
			
			rootMem.getChildMembers().add(childMem);
			childMem.setParentMember(rootMem);
			
			// 先父节点
			session.save(rootMem);
			// 再子节点
			session.save(childMem);

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
			
			Member m = (Member) session.get(Member.class, "2c908486535a36fa01535a36fbab0000");
			
			System.out.println(m.getName());
			System.out.println(m.getChildMembers().size());
			

			transaction.commit();
		} catch (Exception e) {
			HibernateSessionUtil.TransactionRollback(transaction);
		} finally {
			HibernateSessionUtil.colseSession(session);
		}
	}
	

}
