package com.txt.junit.test.junit4.rule;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RuleChainTest {

    /*	@Rule
        public TestRule chain = RuleChain
                // Returns a RuleChain with a single TestRule. This method is the
                // usual starting point of a RuleChain.
                .outerRule(new LoggingRule("outer rule"))
                // Create a new RuleChain, which encloses the nextRule with the
                // rules of the current RuleChain.
                .around(new LoggingRule("middle rule")).around(new LoggingRule("inner rule"));
    */
    @Test
    public void test() {
        assertTrue(true);
    }
}