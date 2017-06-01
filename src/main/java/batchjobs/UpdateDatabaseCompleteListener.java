package main.java.batchjobs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UpdateDatabaseCompleteListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(UpdateDatabaseCompleteListener.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public UpdateDatabaseCompleteListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

			List<String> results = jdbcTemplate.query("SELECT first_name, last_name FROM people", new RowMapper<String>() {
				@Override
				public String mapRow(ResultSet rs, int row) throws SQLException {
					return new String(rs.getString(1));//rs.getString(1), rs.getString(2));
				}
			});

			for (String person : results) {
				log.info("Found <" + person + "> in the database.");
			}

		}
	}
}