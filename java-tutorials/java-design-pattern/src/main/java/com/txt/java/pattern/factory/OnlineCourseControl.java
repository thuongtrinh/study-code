package com.txt.java.pattern.factory;

public class OnlineCourseControl extends AbstractCourseControl {

    @Override
    protected AbstractCourseFactory getCourseFactory() {
        return new OnlineCourseFactory();
    }

}
