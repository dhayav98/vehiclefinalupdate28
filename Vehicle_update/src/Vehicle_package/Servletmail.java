package Vehicle_package;
import java.io.IOException;
import java.text.*;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.*;
/**
 * Servlet implementation class Servletmail
 */
@WebServlet("/Servletmail")
public class Servletmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			ServletContext sc=request.getServletContext();
			//System.out.println(sc.getAttribute("empid").toString());
			User u=VehicleDAO.GetUserDetails();
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			
			ArrayList<Vehicle> list=VehicleDAO.SearchVehicleDetails();
			for(Vehicle v:list)
			{
				String d1=v.getInsurance_expiry();
				Date d=df.parse(d1);
				//Calendar c=Calendar.getInstance();
				//c.add(Calendar.DATE,0);
				//Date dd=c.getTime();
			    Date dd=new Date();
				//System.out.println("display details : date2="+dd);
				//System.out.println("difference : "+(dd.getDate()-d.getDate()));
			   long duration=d.getTime()-dd.getTime();
			   long nod=TimeUnit.MILLISECONDS.toDays(duration);
			   System.out.println("Total number of days : "+nod);
			   
			   
			   
				if((nod==15) || (nod==10) || (nod==5))
				{
					String host ="smtp.gmail.com" ;
		            String user = "vrsystem2019@gmail.com";
		            String pass = "vehicle2019";
		            String to = u.getEmailid();
		            String from = "vrsystem2019@gmail.com";
		            String subject = "Test mail";
		            String messageText = "Vehicle details: \nVehicle Number: "+v.getVehicleno()+" \nVehicle Type: "+v.getVehicletype()+"\nVehicle Branch: "+v.getBranch()+" \nVehicle Service Due Date: "+v.getService_due_date()+"\nPlease Service Your Vehicle";
		            boolean sessionDebug = false;

		            Properties props = System.getProperties();

		            props.put("mail.smtp.starttls.enable", "true");
		            props.put("mail.smtp.host", host);
		            props.put("mail.smtp.port", "587");
		            props.put("mail.smtp.auth", "true");
		            props.put("mail.smtp.starttls.required", "true");

		            //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		            Session mailSession = Session.getDefaultInstance(props, null);
		            mailSession.setDebug(sessionDebug);
		            Message msg = new MimeMessage(mailSession);
		            msg.setFrom(new InternetAddress(from));
		            InternetAddress[] address = {new InternetAddress(to)};
		            msg.setRecipients(Message.RecipientType.TO, address);
		            msg.setSubject(subject); msg.setSentDate(new Date());
		            msg.setText(messageText);

		           Transport transport=mailSession.getTransport("smtp");
		           transport.connect(host, user, pass);
		           transport.sendMessage(msg, msg.getAllRecipients());
		           transport.close();
		           System.out.println("message send successfully");
				}
				else
				{
					System.out.println("message not send");
				}
			
			}
			
			
			

        }
		catch(Exception ex)
        {
            System.out.println(ex);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
