package com.maveric.restapi;


import org.testng.annotations.Test;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;


public class CitrusTesting extends TestNGCitrusTestDesigner{
	
public static void main(String args[])
{
	CitrusTesting citrus=new CitrusTesting();
	citrus.loggingTest();
	
}

	  public void loggingTest() {
		echo("Before loggingService call");
		  
		  echo("After loggingService call");
	  }


}
