package com.busyqa.testsuite;

import com.busyqa.controller.HTMLFormControllerIntegrationTest;
import com.busyqa.controller.HTMLFormControllerUnitTest;
import com.busyqa.repository.CityRepositoryIntegrationTest;
import com.busyqa.service.CityDataServiceIntegrationTest;
import com.busyqa.service.CityDataServiceUnitTest;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CityDataServiceUnitTest.class,
        CityDataServiceIntegrationTest.class,
        HTMLFormControllerUnitTest.class,
        HTMLFormControllerIntegrationTest.class,
        CityRepositoryIntegrationTest.class})
public class CityFeatureTestSuite {
    // intentionally empty - Test Suite Setup (annotations) is sufficient
}
