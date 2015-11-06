package shoppingCart;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class decisionShopping
 */
@WebServlet("/decisionShopping")
public class decisionShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public decisionShopping() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("Add")){
		processAdd(request,response);}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	protected void processAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = shoppingCart.DBUtil.getEmFactory().createEntityManager();
		String strproductID = request.getParameter("productID");//long
		System.out.println(strproductID);
		Long productid = Long.parseLong(strproductID);
		String strproductName = request.getParameter("productName");
		System.out.println(strproductName);
		//String strproductPrice = request.getParameter("productPrice");//double
		Double productprice=Double.parseDouble(request.getParameter("productPrice"));
		String strproductDate = request.getParameter("productDate");
		String strproductDescription = request.getParameter("productDescription");
		//String strquantity = request.getParameter("quantity");//int
		int quantity =Integer.parseInt(request.getParameter("quantity"));
		
		LineitemJB lineitemJB= new LineitemJB();
		lineitemJB.setDate(strproductDate);
		lineitemJB.setProductId(productid);
		lineitemJB.setPrice(productprice);
		lineitemJB.setProductname(strproductName);
		lineitemJB.setUnitPrice(productprice);
		lineitemJB.setQuantity(quantity);
	
		ArrayList<LineitemJB> MyshoppingCart =new ArrayList<LineitemJB>();
		 MyshoppingCart.add(lineitemJB);
		 HttpSession session = request.getSession();
			session.setAttribute("MyshoppingCart",  MyshoppingCart);
			request.setAttribute("MyshoppingCart",  MyshoppingCart);
		
		 try {
				getServletContext().getRequestDispatcher("/shoppingCartList.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
