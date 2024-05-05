package com.txt.junit.test.junit4.externalResource;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({UserDaoTest.class, RoleDaoTest.class})
public class DaoIntegerationTest {
    // the class remains empty, used only as a holder for the above annotations
}
