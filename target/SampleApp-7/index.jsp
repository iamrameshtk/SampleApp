<!DOCTYPE html>
<!-- LLPP714 -->
<%@ page import="java.io.*,java.util.*, java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="exceptions.CpuOverloadException" %>
<%@ page import="java.lang.management.ManagementFactory" %>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags@Kola.balaji@infosys.com -->
<title>FirstData</title>
<%!
	/* 
	public void consumesCpu() {
		@SuppressWarnings("restriction")
		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
	            OperatingSystemMXBean.class);
		double cpuUsage = 0.00;
		try{
			int count = Runtime.getRuntime().availableProcessors();
	        for (int i = 0; i < count; i++) {
	            new Thread(new Runnable() {
	                public void run() {
	                    while (true);
	                }
	            }).start();
	        }
	        while(true){
	        	cpuUsage = osBean.getProcessCpuLoad();
		    	if (cpuUsage >= 0.8){
		    		throw new CpuOverloadException("CPU Load exceeds 80%");
		    	}
	        }
		        
		}
		catch (CpuOverloadException e){
			System.out.println(e.getMessage());
			System.exit(01);
		}
    } */
%>

</head>
<body bgcolor="#FF6600" style="text-align: center;">
	<!--Header S 
	<div class="container-fluid">
		<div class="page-header">
			<h1></h1>
		</div>
	</div>-->
	<!--Header E  -->
	
		
				

	<form action="./jsp/login.jsp" method="post">

		<h1>Login  Page</h1>
		<font color="green"><label for="name">Name: </label><input type="text" name="name">
			<br> <br></font> 
		<font color="green"><label for="pwd">Password: </label><input type="password" name="pwd"><br> <br></font>
		<font color="green"><label for="empid">Emp Name: </label><input type="text" name="empid"> <br>
				<br></font> 
			<input type="submit" value="Submit">
	</form>
	<!-- footer start-->
	<footer class="footer">
		 <a href="./CpuServlet">Register</a> 
		<div class="container-fluid"></div>
	</footer>
</body>
</html>