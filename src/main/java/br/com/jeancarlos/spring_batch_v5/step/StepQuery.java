package br.com.jeancarlos.spring_batch_v5.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StepQuery {
 @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager, @Qualifier("jdbcTemplate") JdbcTemplate joJdbcTemplate) {
        return new StepBuilder("step", jobRepository)
        .tasklet((StepContribution contribution, ChunkContext chunkContext) -> {
        
            
            joJdbcTemplate.batchUpdate("INSERT into clientebackup(nome, email, idade, sobrenome)\n" + //
                                "SELECT nome, email, idade, sobrenome from cliente\n" + //
                                "where cliente.id = 1");
            return RepeatStatus.FINISHED;
        }, platformTransactionManager)
        .build();
    }
}
