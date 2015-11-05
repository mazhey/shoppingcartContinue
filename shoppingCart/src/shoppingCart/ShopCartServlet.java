package shoppingCart;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

/**
 * Servlet implementation class ShopCartServlet
 */
@WebServlet("/ShopCartServlet")
public class ShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processProductPool(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processProductPool(request,response);
	}
	
	public void processProductPool(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = shoppingCart.DBUtil.getEmFactory().createEntityManager();
		String qString = "select p from Product p ";
		TypedQuery<Product> q = em.createQuery(qString, Product.class);
	
		
		List<Product> productPool = null;
		
		String tableinfo  = "";
		try{
			productPool=q.getResultList();
//			model.Tweet tweet = em.find(model.Tweet.class, (long)2);
	//		Tweet mytweet = em.find(model.Tweet.class, 2L);
			
			for(int i=0;i<productPool.size();i++){
			
			/*
			 *  		<tr>
  		${tabledata }
  				<td>${twitter.getTweet()}</td>
  				<td>${twitter.getUser().getUsername()}</td>
  				<td>${twitter.getTweetDate()}</td>
  </tr>
			 */
		tableinfo += "<tr><td>" + productPool.get(i).getProductId()+"</td><td>" + productPool.get(i).getProductName() + "</td><td>" + productPool.get(i).getProductPrice()+ "</td><td><a href=\"http://localhost:8080/shoppingCart/TheShoppingCart?productId="+  productPool.get(i).getProductId() + "\">buy</a></td></tr>";
		
			
			}
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			finally{
				em.close();
				System.out.println("end of product pools");
			}
		request.setAttribute("tableinfo", tableinfo);
		
	     getServletContext()
	     	.getRequestDispatcher("/productPool.jsp")
	     		.forward(request, response);

		}

}
