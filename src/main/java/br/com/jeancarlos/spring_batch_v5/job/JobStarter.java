package br.com.jeancarlos.spring_batch_v5.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobStarter {

	@Bean
	public Job jdbcStarterJob(Step jdbcCursorReaderStep, JobRepository jobRepository) {
		return new JobBuilder("jdbcStarterJob", jobRepository)
				.start(jdbcCursorReaderStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
