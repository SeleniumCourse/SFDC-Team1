package com.salesforce.dev.framework.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * This class will be used to access to the variable of Properties file
 * @author Carlos Gonzales.
 * @since 6/8/2015.
 */
public class Environment {

    private static final Logger LOGGER = Logger.getLogger(Environment.class.getSimpleName());

    private static final String PRIMARY_USER_NAME = "primaryUserName";

    private static final String PRIMARY_USER_PASS_SECURITY = "primaryUserPassword";

    private static final String BROWSER = "browser";

    private static final String GROUPS = "groups";

    private static final String DISPLAY_NAME = "displayName";

    private static final String MODE = "mode";

    private static final String USER_NAME = "remoteUserName";

    private static final String KEY = "remoteKey";

    private static final String PRIMARY_USE_SECURITY_TOKEN = "primaryUsePasswordToken";

    private static final String URL_API = "urlApi";

    private static final String BROWSER_REMOTE = "remoteBrowser";

    private static final String PLATFORM_REMOTE = "remotePlatform";

    private static final String VERSION_REMOTE = "remoteBrowserVersion";

    private static final String PROXY_HOST = "proxyHost";

    private static final String PROXY_PORT = "proxyPort";

    private static Environment environment;

    private Properties properties;

    private Environment() {
        readFile();
    }

    public static Environment getInstance() {
        if (environment == null) {
            environment = new Environment();
        }
        return environment;
    }

    public void readFile() {
        File file = new File("gradle.properties");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            properties = new Properties();
            properties.load(fileReader);
            fileReader.close();
        } catch (FileNotFoundException e) {
            LOGGER.warn("The properties file couldn't be found", e);
        } catch (IOException e) {
            LOGGER.warn("A problem of type", e);
        }
    }

    public String getEnv(String key) {
        String env = System.getProperty(key);
        if (env == null) {
            env = properties.getProperty(key);
        }
        return env;
    }

    public String getPrimaryUser() {
        return getEnv(PRIMARY_USER_NAME);
    }

    public String getPrimaryPassword() {
        return getEnv(PRIMARY_USER_PASS_SECURITY);
    }

    public String getBrowser() {
        return getEnv(BROWSER);
    }

    public String getGroups() {
        return getEnv(GROUPS);
    }

    public String getDisplayName() {
        return getEnv(DISPLAY_NAME);
    }

    public String getMode() {
        return getEnv(MODE);
    }

    public String getPrimaryUserPasswordToken() {
        return getEnv(PRIMARY_USE_SECURITY_TOKEN);
    }

    public String getUrlApi() {
        return getEnv(URL_API);
    }

    public String getRemoteUserName() {
        return getEnv(USER_NAME);
    }

    public String getRemotePlatform() {
        return getEnv(PLATFORM_REMOTE);
    }

    public String getRemoteBrowser() {
        return getEnv(BROWSER_REMOTE);
    }

    public String getRemoteKey() {
        return getEnv(KEY);
    }

    public String getRemoteBrowserVersion() {
        return getEnv(VERSION_REMOTE);
    }

    public String getProxyHost() {
        return !getEnv(PROXY_HOST).isEmpty()? getEnv(PROXY_HOST):null;
    }

    public String getProxyPort() {
        return !getEnv(PROXY_PORT).isEmpty()? getEnv(PROXY_PORT):null;
    }

}
