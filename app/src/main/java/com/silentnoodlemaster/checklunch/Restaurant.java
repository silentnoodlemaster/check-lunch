package com.silentnoodlemaster.checklunch;

public class Restaurant {
    String ref_title;
    Course[] courses;

    public Restaurant(String ref_title, Course[] courses) {
        this.ref_title = ref_title;
        this.courses = courses;
    }

    public String getRef_title() {
        return ref_title;
    }

    public Course[] getCourses() {
        return courses;
    }
}
