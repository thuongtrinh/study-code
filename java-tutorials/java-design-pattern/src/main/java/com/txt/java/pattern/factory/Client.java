package com.txt.java.pattern.factory;

public class Client {

    public static void main(String[] args) {
        AbstractCourseControl onlineController = new OnlineCourseControl();
        onlineController.displayCourse(CourseType.JAVA_ONLINE);
        onlineController.displayCourse(CourseType.ANGULAR_ONLINE);

        AbstractCourseControl offlineController = new OfflineCourseControl();
        offlineController.displayCourse(CourseType.JAVA_OFFLINE);
        offlineController.displayCourse(CourseType.ANGULAR_OFFLINE);
    }

}
