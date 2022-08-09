package com.example.study_year_design;

import com.example.study_year_design.dao.ProjectDao;
import com.example.study_year_design.pojo.Project;
import com.mysql.cj.jdbc.ConnectionImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

@SpringBootTest
class StudyYearDesignApplicationTests {

	@Autowired
	DataSource dataSource;
	@Autowired
	ProjectDao projectDao;

	@Test
	void printprojects() throws Exception{
		Collection<Project> projects=projectDao.getAllProjects();
		System.out.println(projects);

	}

	@Test
	void contextLoads() throws SQLException {
		System.out.println(dataSource.getClass());

		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}

}
