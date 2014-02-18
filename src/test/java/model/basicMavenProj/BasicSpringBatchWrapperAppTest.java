package model.basicMavenProj;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BasicSpringBatchWrapperAppTest extends TestCase {
	
	
    public BasicSpringBatchWrapperAppTest( String testName )    {
        super( testName );
    }

	
	
    public static Test suite()    {
        return new TestSuite( BasicSpringBatchWrapperAppTest.class );
    }

	
	
    public void testBasicSpringBatchWrapperApp()    {
        
        BasicSpringBatchWrapperApp basicSpringBatchWrapperApp = new BasicSpringBatchWrapperApp();
        
        assertEquals ("STARTED" ,basicSpringBatchWrapperApp.getResult("Some basic input String."));
        
        assertEquals(basicSpringBatchWrapperApp.getJobExecutionEntrySet().size(), 0);
        
    }
}
