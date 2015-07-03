package zw.zj.hiberbate.extend.test;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;

import zw.zj.hibernate.extend.util.HibernateSessionUtil;
import zw.zj.hibernate.model.Course;
import zw.zj.hibernate.model.Student;

public class TestExtends extends TestCase {

	public void testInsert() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionUtil.getSession();
			transaction = session.getTransaction();
			transaction.begin();

			Set<Student> students1 = new HashSet<Student>();
			Set<Student> students2 = new HashSet<Student>();
			Set<Course> courses1 = new HashSet<Course>();
			Set<Course> courses2 = new HashSet<Course>();
			
			Student s1 = new Student();
			//s1.setId(1);
			s1.setName("zj");
			
			Student s2 = new Student();
			//s2.setId(2);
			s2.setName("lj");
			
			students1.add(s1);
			students1.add(s2);
			
			students2.add(s1);
			students2.add(s2);
			
			
			Course c1 = new Course();
			//c1.setId(1);
			c1.setName("Math");
			
			Course c2 = new Course();
			//c2.setId(2);
			c2.setName("English");
			
			Course c3 = new Course();
			//c3.setId(3);
			c3.setName("Sience");
			
			courses1.add(c1);
			courses1.add(c2);
			courses1.add(c3);
			
			courses2.add(c1);
			courses2.add(c2);
			courses2.add(c3);
			
			s1.setCourse(courses1);
			s2.setCourse(courses2);

			//c1.setStudent(students);
			//c2.setStudent(students);
			//c3.setStudent(students);
			
			
			session.save(s1);
			session.save(s2);
			

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

			
			
			

			transaction.commit();
		} catch (Exception e) {
			HibernateSessionUtil.TransactionRollback(transaction);
		} finally {
			HibernateSessionUtil.colseSession(session);
		}
	}

}
