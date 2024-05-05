package com.txt.java.pattern.factory;

public class OfflineCourseControl extends AbstractCourseControl {

    @Override
    protected AbstractCourseFactory getCourseFactory() {
        return new OfflineCourseFactory();
    }

}
