package com.txt.java.pattern.factory;

public abstract class AbstractCourseFactory {

    public AbstractCourse createCourse(CourseType type) {
        AbstractCourse course = getCourse(type);

        if (course != null) {
            // Code common for the course before returning it to caller
        }

        return course;
    }

    protected abstract AbstractCourse getCourse(CourseType type);
}
