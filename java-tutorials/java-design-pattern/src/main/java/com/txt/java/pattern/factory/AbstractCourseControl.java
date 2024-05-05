package com.txt.java.pattern.factory;

public abstract class AbstractCourseControl {

    public void displayCourse(CourseType type) {
        AbstractCourseFactory factory = getCourseFactory();
        AbstractCourse course = factory.createCourse(type);

        if (course != null) {
            course.display();
        } else {
            System.out.println("Nothing is displayed");
        }
    }

    protected abstract AbstractCourseFactory getCourseFactory();
}
