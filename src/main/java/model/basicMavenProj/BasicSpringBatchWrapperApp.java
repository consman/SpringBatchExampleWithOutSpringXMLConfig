package model.basicMavenProj;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobInterruptedException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.SimpleJob;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;


public class BasicSpringBatchWrapperApp {
	
	static Logger logger = Logger.getLogger(BasicSpringBatchWrapperApp.class);
	
    public String getResult(String inParam){
    	
    	SimpleJob sJob = new SimpleJob();
    	
    	Step step = new BobsStep();    	    	
    	
    	sJob.addStep(step);
    	
    	JobRepository jr = new JobRepositoryImpl();
    	
    	sJob.setJobRepository(jr);
    	
    	JobParameters jp = new JobParameters();
    	
    	JobExecution je = new JobExecution(new JobInstance(1l, jp, "OurJobName"));
    	    	    	
    	sJob.execute(je);
    	
    	logger.info("Done with the execute method at " + new Date());
    	
    	return je.getStatus().toString();
    	
    	
    }
    
    
    class JobRepositoryImpl implements JobRepository{

		public boolean isJobInstanceExists(String jobName,
				JobParameters jobParameters) {
			 
			
			return false;
		}

		public JobExecution createJobExecution(String jobName,
				JobParameters jobParameters)
				throws JobExecutionAlreadyRunningException,
				JobRestartException, JobInstanceAlreadyCompleteException {
			 
			
			return null;
		}

		public void update(JobExecution jobExecution) {
			
			
		}

		public void add(StepExecution stepExecution) {
			
			
		}

		public void update(StepExecution stepExecution) {
			
			
		}

		public void updateExecutionContext(StepExecution stepExecution) {
			
			
		}

		public void updateExecutionContext(JobExecution jobExecution) {
			
			
		}

		public StepExecution getLastStepExecution(JobInstance jobInstance,
				String stepName) {
			
			return null;
		}

		public int getStepExecutionCount(JobInstance jobInstance,
				String stepName) {
			
			return 2;
		}

		public JobExecution getLastJobExecution(String jobName,
				JobParameters jobParameters) {
			 
			return null;
		}
    	
    	
    }
    
    class BobsStep implements Step{

		public String getName() {
			 
			return "BobsStep";
		}

		public boolean isAllowStartIfComplete() {
			 
			return false;
		}

		public int getStartLimit() {
			 
			return 5;
		}

		public void execute(StepExecution stepExecution)
				throws JobInterruptedException {
			
			logger.info("Doing work in the execute method here now at: " + new Date());
			
			
		}
    	
    	
    }

}
