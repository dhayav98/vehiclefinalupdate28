package Vehicle_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dispupdate
 */
@WebServlet("/Dispupdate")
public class Dispupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dispupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ArrayList<Vehicle> list=new ArrayList<Vehicle>();
		Vehicle p=new Vehicle();
		list=VehicleDAO.SearchVehicleDetails();
		out.print("<html>");
		out.println("<head>");
		out.print("<link rel='stylesheet' href='loginstyle.css'>");
		out.print("<link rel='stylesheet' href='menubar.css'>");
		out.println("<style>");
		out.println("body{");
		out.println("background-color:#2c3335");
		out.println("}");
		out.println("h1{");
		out.println("color:#f5f5f5");
		out.println("}");
		out.println("table,td,th{");        
	    out.println("border: 1px solid #f5f5f5 ;");
	 	out.println(" padding: 3px;");
	
		  out.println("}");
		  out.println("table {");
		  out.println("border-spacing: 15px;");
		  out.println("}");
		  out.println("</style>");
		  out.println("</head>");
		  out.println("<body class='bodystyle'>");
		  out.println("<br>");
		  out.println("<ul>");
		  out.println("<li><a class='active' href='#about'>logout</a><li>");
		  out.println("<li ><a class='active' href='Searchvehicle.jsp'>search</a></li>");
		  out.println("<li><a lass='active' href='Home.jsp'>Home</a><li>");
		  out.println("</ul>");
		  out.print("<center>");
		  out.print("<h1>Update vehicle details</h1>");
		  out.print("</center>");
		out.print("<table width='100%'");
		out.print("<tr><th>Vehicle No</th><th>Branch</th><th>Vehicle Type</th><th>Insurance Expiry Date</th><th>Last Serviced Date</th><th>Service Due Date</th><th>Update</th></tr>");
		for(Vehicle vv:list)
		{
			out.print("<tr><td>"+vv.getVehicleno()+"</td><td>"+vv.getBranch()+"</td><td>"+vv.getVehicletype()+"</td><td>"+vv.getInsurance_expiry()+"</td><td>"+vv.getLast_serviced_date()+"</td><td>"+vv.getService_due_date()+"</td><td><button class='updatebutton'><a href='Updatevehicle.jsp?vno="+vv.getVehicleno()+"'>Update</a></button></td></tr>");
		}
		out.print("</table>");
		out.print("<br>");
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
