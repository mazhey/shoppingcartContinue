package shoppingCart;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Product;

public class ProductDB {
	public static void insert(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.persist(product);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e + "this is the insert exception");
		trans.rollback();
		} finally {
		em.close();
		}
		}
	public static void update(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.merge(product                                                                                                               );
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}
	public static void delete(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.remove(em.merge(product));
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		} 
		}
	public static Product selectProductID(Long productid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select p from Product p where p.product_id = :productid";
		TypedQuery<Product> q = em.createQuery(qString, Product.class);
		q.setParameter("productid", productid);
		Product product = null;
		try {
			product = q.getSingleResult();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return product;
	}

	
	
}

