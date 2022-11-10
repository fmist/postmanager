package com.rustcohle.postmanager.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

public class GlobalHooks {

    @Before
    public void init() {
        Configuration.baseUrl = "https://192.168.0.110:8083";
    }

    @After
    public void stop() {
        Selenide.closeWebDriver();
    }
}
