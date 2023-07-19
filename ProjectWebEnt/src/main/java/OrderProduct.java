

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderProduct
 */
@WebServlet("/OrderProduct")
public class OrderProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String value1 = request.getParameter("Product_1");
		String value2 = request.getParameter("Product_2");
		String value3 = request.getParameter("Product_3");
		String value4 = request.getParameter("Product_4");
		String value5 = request.getParameter("Product_5");
		String value6 = request.getParameter("Product_6");
		String value7 = request.getParameter("Product_7");
		String value8 = request.getParameter("Selangor_1");
		String value9 = request.getParameter("UITM_1");
		String value10 = request.getParameter("UITM_2");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action = \"shop.html\" method = \"get\">");
		
		if(value1 == null)
			value1 = "no";
		
		if(value1.equals("yes"))
		{
			out.println("<img src=\"picture/Product_1.png\" width=\"100%\" id=\"MainImg\" alt=\"\">");
			out.println("<br>");
			out.println("Home/T-Shirt");
			out.println("<br>");
			out.println("Jersey");
			out.println("<br>");
			out.println("RM 50.00");
			out.println("<br>");
			out.println("Size:<select id=Product_1Size>");
			out.println("<option>XS</option>");
			out.println("<option>S></option>");
			out.println("<option>M</option>");
			out.println("<option>L</option>");
			out.println("<option>XL</option></select>");
			out.println("<br>");
			out.println("Quantity:<select id=Product_1Quantity>");
			out.println("option>2></option>");
			out.println("<option>3</option>");
			out.println("<option>4</option>");
			out.println("<option>5</option>");
			out.println("</select>");
			out.println("<br>");
			
			out.println("");
			out.println("");
			out.println("");
			out.println("");
			out.println("");
			out.println("");
			out.println("");
			out.println("");
			out.println("");
			out.println("");
			out.println("");
			out.println("");
			out.println("");
			out.println("");
      
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
