package com.stepdefinition;

import com.base.baseclass;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class hooks extends baseclass

{
	@After

    public void afterScenario(Scenario scenario) {

        scenario.attach(cucumberScreenShot(), "images/png", "Every Scenario");

    }
}
