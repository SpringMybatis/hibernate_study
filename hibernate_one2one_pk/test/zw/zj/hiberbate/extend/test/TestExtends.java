package zw.zj.hiberbate.extend.test;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;

import zw.zj.hibernate.extend.util.HibernateSessionUtil;
import zw.zj.hibernate.model.IdCard;
import zw.zj.hibernate.model.Member;

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

			IdCard card = new IdCard();
			card.setNum("123456789");
			card.setMember(m);// 设置Member和IdCard关系，以便IdCard可以从Member取得主键值

			m.setCard(card);// 设置Member和IdCard关系

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

			Member m = (Member) session.load(Member.class, 1);
			
			System.out.println(m.getName());

			transaction.commit();
		} catch (Exception e) {
			HibernateSessionUtil.TransactionRollback(transaction);
		} finally {
			HibernateSessionUtil.colseSession(session);
		}
	}

}
