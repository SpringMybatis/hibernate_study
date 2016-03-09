package zw.zj.hibernate.extend.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateSessionUtil {

	private static SessionFactory sessionFactory = null;
	
	static{
		try {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

	public static void colseSession(Session session) {
		if (session != null) {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
	
	public static void TransactionRollback(Transaction transaction) {
		if (transaction != null) {
			transaction.rollback();
		}
	}

	public static void TransactionBegin(Transaction transaction) {
		if (transaction != null) {
			transaction.begin();
		}
	}

	public static void TransactionCommit(Transaction transaction) {
		if (transaction != null) {
			transaction.commit();
		}
	}

}
