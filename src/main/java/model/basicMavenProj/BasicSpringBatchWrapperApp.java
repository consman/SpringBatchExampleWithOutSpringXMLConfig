package model.basicMavenProj;

import java.util.Date;
import java.util.Map.Entry;
import java.util.Set;

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
	
	private Set<Entry <String, Object>> jobExecutionEntrySet;
	private int cCommitCount = 1;

	
    public String getResult(String inParam){
    	
    	SimpleJob sJob = new SimpleJob();
    	
    	Step step = new SprBatUsrsStep();    	    	
    	
    	sJob.addStep(step);
    	
    	JobRepository jr = new JobRepositoryImpl();
    	
    	sJob.setJobRepository(jr);
    	
    	JobParameters jp = new JobParameters();
    	
    	JobExecution je = new JobExecution(new JobInstance(1l, jp, "OurJobName"));
    	    	    	
    	sJob.execute(je);
    	
    	logger.info("Done with the execute method at " + new Date());
    	
        logger.info("The JobExecution Id is: " + je.getId());
    	
    	Set<Entry <String, Object>> set = je.getExecutionContext().entrySet();
    	
    	setJobExecutionEntrySet(set);
    	
    	for (Entry <String, Object> entry: set){
    		logger.info("The String is: " +entry.getKey() + " and the Object is: "+ entry.getValue());
    	}
    	
    	
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
    
    class SprBatUsrsStep implements Step{

		public String getName() {
			 
			return "SprBatUsrsStep";
		}

		public boolean isAllowStartIfComplete() {
			 
			return false;
		}

		public int getStartLimit() {
			 
			return 5;
		}

		public void execute(StepExecution stepExecution)
				throws JobInterruptedException {
			
			logger.info("Doing work in the execute method here now at: " + new Date() );
			logger.info("And the commit count is: "+ stepExecution.getCommitCount());
			setcCommitCount(stepExecution.getCommitCount());
		}
    	
    	
    }

	public int getcCommitCount() {
		return cCommitCount;
	}

	public void setcCommitCount(int cCommitCount) {
		this.cCommitCount = cCommitCount;
	}

	public Set<Entry<String, Object>> getJobExecutionEntrySet() {
		return jobExecutionEntrySet;
	}

	public void setJobExecutionEntrySet(
			Set<Entry<String, Object>> jobExecutionEntrySet) {
		this.jobExecutionEntrySet = jobExecutionEntrySet;
	}

}
