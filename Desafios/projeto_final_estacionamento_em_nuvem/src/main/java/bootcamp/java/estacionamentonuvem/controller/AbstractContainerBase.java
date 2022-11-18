package bootcamp.java.estacionamentonuvem.controller;

import org.testcontainers.containers.PostgreSQLContainer;

public abstract class AbstractContainerBase {

    static PostgreSQLContainer POSTGRE_SQL_CONTAINER = null;

    static {
        POSTGRE_SQL_CONTAINER = new PostgreSQLContainer("postgres:10-alpíne");
        POSTGRE_SQL_CONTAINER.start();
        System.setProperty("spring.datasource.url",POSTGRE_SQL_CONTAINER.getJdbcUrl());
        System.setProperty("spring.datasource.url",POSTGRE_SQL_CONTAINER.getUsername());
        System.setProperty("spring.datasource.url",POSTGRE_SQL_CONTAINER.getPassword());
    }

}
