package com.silentnoodlemaster.checklunch;

public class Sodexo {
    private String ref_title;
    SodexoCourse[] courses;

    Sodexo(String ref_title, SodexoCourse[] courses) {
        this.ref_title = ref_title;
        this.courses = courses;
    }

    String getRef_title() {
        return ref_title;
    }

    public SodexoCourse[] getCourses() {
        return courses;
    }
}
