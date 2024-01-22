package com.simplilearn.restbddtest.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {"com/simplilearn/restbddtest/stepdefinitions" })
public class TestRunner {
}
