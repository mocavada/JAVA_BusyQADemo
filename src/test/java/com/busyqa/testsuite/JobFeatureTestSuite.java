package com.busyqa.testsuite;

import com.busyqa.jobbank.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        JobServiceUnitTest.class,
        JobServiceIntegrationTest.class,
        JobControllerUnitTest.class,
        JobControllerIntegrationTest.class,
        JobRepositoryIntegrationTest.class})
public class JobFeatureTestSuite {
    // intentionally empty - Test Suite Setup (annotations) is sufficient
}
