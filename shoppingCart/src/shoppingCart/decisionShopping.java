package shoppingCart;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Lineitem;

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
		int productID =Integer.parseInt(strproductID);
		System.out.println(strproductID);
		Long productid = Long.parseLong(strproductID);
		String strproductName = request.getParameter("productName");
		System.out.println(strproductName);
		//String strproductPrice = request.getParameter("productPrice");//double
		
		Double productprice=Double.parseDouble(request.getParameter("productPrice"));
		System.out.println(productprice);
		String strproductDate = request.getParameter("productDate");
		System.out.println(strproductDate);
		String strproductDescription = request.getParameter("productDescription");
		System.out.println(strproductDescription);
		//String strquantity = request.getParameter("quantity");//int
		int quantity =Integer.parseInt(request.getParameter("quantity"));
		double subtotal = quantity*productprice;
		System.out.println(quantity);
		Lineitem myLineitem = new Lineitem();
		myLineitem.setLineitemId(myLineitem.getLineitemId());
		myLineitem.setProductId(productID);
		myLineitem.setProductDate(strproductDate);
		myLineitem.setProductQuantity(quantity);
		myLineitem.setProductUnitprice(productprice);
		myLineitem.setProductDate(strproductDate);
		myLineitem.setProductPrice(subtotal);
		LineitemDB.insert(myLineitem);
		
		LineitemJB lineitemJB= new LineitemJB();
		lineitemJB.setDate(strproductDate);
		lineitemJB.setProductId(productid);
		lineitemJB.setPrice(subtotal);
		lineitemJB.setProductname(strproductName);
		lineitemJB.setUnitPrice(productprice);
		lineitemJB.setQuantity(quantity);
	
		ArrayList<LineitemJB> MyshoppingCart =new ArrayList<LineitemJB>();
		 HttpSession session = request.getSession();
		MyshoppingCart=(ArrayList<LineitemJB>) session.getAttribute("MyshoppingCart");
		 MyshoppingCart.add(lineitemJB);
		 double total=0;
		 for(int i=0;i< MyshoppingCart.size();i++){
			 total+=MyshoppingCart.get(i).getPrice();
		 }
		 
			session.setAttribute("MyshoppingCart",  MyshoppingCart);
			request.setAttribute("GrandTotal", total);
		
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
