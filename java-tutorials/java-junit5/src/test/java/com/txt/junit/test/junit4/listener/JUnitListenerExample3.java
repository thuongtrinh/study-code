package com.txt.junit.test.junit4.listener;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(CustomSuite.class)
@Suite.SuiteClasses({AssertTest.class, IgnoreTest.class})
public class JUnitListenerExample3 {

}

