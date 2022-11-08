package spring.transaction.传播属性;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Config implements ApplicationContextAware {

    DataSource dataSource;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.dataSource = (DataSource) applicationContext.getBean("dataSource");
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
}
