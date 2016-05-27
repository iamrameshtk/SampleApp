package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import servlets.CpuConsumerServlet;

public class CpuConsumerServletTest {
	CpuConsumerServlet cpuConsumer = new CpuConsumerServlet();
	
	@Test
	public void testCpuConsumerServlet() {
		
		// assert statements
	    try {
			assertEquals("cpuConsumes function should return 0", 0, cpuConsumer.cpuConsumes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
