package servlets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.management.OperatingSystemMXBean;

import exceptions.CpuOverloadException;

/**
 * Servlet implementation class CpuConsumerServlet
 */
@WebServlet("/CpuConsumerServlet")
public class CpuConsumerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CpuConsumerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	@SuppressWarnings("restriction")
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(cpuConsumes()==0){
			System.exit(0);
		}
	}
	
	public int cpuConsumes() throws IOException{
		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
	            OperatingSystemMXBean.class);
		double cpuUsage = 0.00;
		//LLPP714
   	 //File file = new File("/opt/apache-tomcat-8.0.27/logs/sampleLogs.log");
		File file = new File("/usr/local/tomcat/logs/sampleLogs.log");
		// if file doesnt exists, then create it
		

//  e.printStackTrace(pWriter);
   	PrintWriter pWriter = null;
		try{
			if (!file.exists()) {
				file.createNewFile();
			}
			Date curDate = new Date();
			   String DateToStr = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
						DateFormat.SHORT).format(curDate);
	  FileWriter fstream = new FileWriter(file, true);
	  BufferedWriter out = new BufferedWriter(fstream);
	  out.append(DateToStr+" ");
	  pWriter = new PrintWriter(out, true);
			int count = Runtime.getRuntime().availableProcessors();
	        for (int i = 0; i < count; i++) {
	            new Thread(new Runnable() {
	                public void run() {
	                    while (true);
	                }
	            }).start();
	        }
	        while(true){
	        	//cpuUsage = osBean.getProcessCpuLoad();
	        	cpuUsage = osBean.getSystemLoadAverage();
		    	if (cpuUsage >= 0.8){
		    		throw new CpuOverloadException("Error : System Load exceeds 80%");
		    	}
	        }
		        
		}
		catch (CpuOverloadException e){
			System.out.println(e.getMessage());
			e.printStackTrace(pWriter);
			return 0;
		}
	}

}
