package com.txt.java.pattern.factory;

public class OfflineCourseFactory extends AbstractCourseFactory {

    @Override
    protected AbstractCourse getCourse(CourseType courseType) {
        switch (courseType) {
            case JAVA_OFFLINE:
                return new JavaOnlineCourse();
            case ANGULAR_OFFLINE:
                return new AngularOnlineCourse();
            default:
                throw new IllegalArgumentException("This online course type is unsupported");
        }
    }

}
