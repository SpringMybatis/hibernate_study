package zw.zj.hiberbate.extend.test;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

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

			Set<Order> setOrders = new HashSet<Order>();
			setOrders.add(order);
			m.setOrders(setOrders);

			session.save(m);

			transaction.commit();
		} catch (Exception e) {
			HibernateSessionUtil.TransactionRollback(transaction);
		} finally {
			HibernateSessionUtil.colseSession(session);
		}
	}

	public void testLoad() {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionUtil.getSession();
			transaction = session.getTransaction();
			transaction.begin();

			// 必须load当前对象的值,否则出错
			Member m = (Member) session.get(Member.class, 1);

			System.out.println(m.getName());

			transaction.commit();
		} catch (Exception e) {
			HibernateSessionUtil.TransactionRollback(transaction);
		} finally {
			HibernateSessionUtil.colseSession(session);
		}
	}

}
