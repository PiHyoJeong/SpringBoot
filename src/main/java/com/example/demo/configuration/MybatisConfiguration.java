package com.example.demo.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * mybatis 설정
 * @author dong
*/
@Configuration
@MapperScan(basePackages = "com.example.demo.mvc.repository") //BoardRepository를 스캔하기 위해 basePackages 설정
public class MybatisConfiguration {
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(@Autowired DataSource datasource,ApplicationContext applicationContext) throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(datasource);
		factoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/sql/*.xml")); //내가 만든 mybatis/sql에 있는 모든 xml 을 불러온다
		SqlSessionFactory factory =factoryBean.getObject();
		factory.getConfiguration().setMapUnderscoreToCamelCase(true);
		return factoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(@Autowired SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
