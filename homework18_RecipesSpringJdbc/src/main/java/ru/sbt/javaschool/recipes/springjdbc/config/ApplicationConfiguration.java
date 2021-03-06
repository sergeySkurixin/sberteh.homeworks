package ru.sbt.javaschool.recipes.springjdbc.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.sbt.javaschool.recipes.springjdbc.repository.IngredientRepository;
import ru.sbt.javaschool.recipes.springjdbc.service.impl.hibernate.IngredientServiceImpl;
import ru.sbt.javaschool.recipes.springjdbc.service.impl.hibernate.RecipeServiceImpl;
import ru.sbt.javaschool.recipes.springjdbc.service.impl.hibernate.RecipesToIngredientsServiceImpl;

import javax.sql.DataSource;

/**
 * Created by скурихин on 14.11.2016.
 */
@Configuration
@EnableTransactionManagement
//@ComponentScan("ru.sbt.javaschool.recipes.springjdbc")
@ComponentScan(basePackages = {"ru.sbt.javaschool.recipes.springjdbc"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = IngredientServiceImpl.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = RecipeServiceImpl.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = RecipesToIngredientsServiceImpl.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ApplicationConfigurationWithHibernate.class)})
@PropertySource("classpath:app.properties")
public class ApplicationConfiguration {

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource("jdbc:h2:./RecipesSpringJdbc/database/app");
    }

    @Bean
    public NamedParameterJdbcTemplate namedJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}