package com.rean.configuration;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@ComponentScan(basePackages="com")
@EnableWebMvc
public class ServletConfiguration extends WebMvcConfigurerAdapter{
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resovler = new InternalResourceViewResolver();
		resovler.setPrefix("/WEB-INF/views/");
		resovler.setSuffix(".jsp");
		return resovler;
	}

	@Bean 
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setUrl("jdbc:postgresql://localhost:5432/My_Server");
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		
		return dataSource;
	}
	
	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void extendMessageConverters(final List<HttpMessageConverter<?>> httpMes){
		final Optional<HttpMessageConverter<?>> jsonConvert = httpMes.stream().filter(c-> c instanceof MappingJackson2HttpMessageConverter).findFirst();
		if(jsonConvert.isPresent()){
			final AbstractJackson2HttpMessageConverter cv = (AbstractJackson2HttpMessageConverter) jsonConvert.get();
			cv.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
			cv.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		}
	}
}
