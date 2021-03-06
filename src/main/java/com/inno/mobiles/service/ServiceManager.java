package com.inno.mobiles.service;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServiceManager {
    private final Properties applicationProperties = new Properties();
    private BasicDataSource dataSource;
    private MobileService mobileService;
    private UserService userService;

    public MobileService getMobileService() {
        return mobileService;
    }

    private ServiceManager(ServletContext context) {
        loadApplicationProperties();
        dataSource = createDataSource();
        mobileService = new MobileServiceImpl(dataSource);
        userService = new UserServiceImpl(dataSource);
    }

    public static ServiceManager getInstance(ServletContext context) {
        ServiceManager instance = (ServiceManager) context.getAttribute("SERVICE_MANAGER");
        if (instance == null) {
            instance = new ServiceManager(context);
            context.setAttribute("SERVICE_MANAGER", instance);
        }
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    private BasicDataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDefaultAutoCommit(false);
        dataSource.setRollbackOnReturn(true);
        dataSource.setDriverClassName(getApplicationProperty("db.driver"));
        dataSource.setUrl(getApplicationProperty("db.url"));
        dataSource.setUsername(getApplicationProperty("db.username"));
        dataSource.setPassword(getApplicationProperty("db.password"));
        dataSource.setInitialSize(Integer.parseInt(getApplicationProperty("db.pool.initSize")));
        dataSource.setMaxTotal(Integer.parseInt(getApplicationProperty("db.pool.maxSize")));
        return dataSource;
    }
    private void loadApplicationProperties(){
        try(InputStream in = ServiceManager.class.getClassLoader().getResourceAsStream("application.properties")) {
            applicationProperties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getApplicationProperty(String key) {
        return applicationProperties.getProperty(key);
    }
}
