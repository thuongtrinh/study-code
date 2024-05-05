package com.txt.java.pattern.factory;

public class OnlineCourseFactory extends AbstractCourseFactory {

    @Override
    protected AbstractCourse getCourse(CourseType courseType) {
        switch (courseType) {
            case JAVA_ONLINE:
                return new JavaOfflineCourse();
            case ANGULAR_ONLINE:
                return new AngularOfflineCourse();
            default:
                throw new IllegalArgumentException("This offline course type is unsupported");
        }
    }

}
