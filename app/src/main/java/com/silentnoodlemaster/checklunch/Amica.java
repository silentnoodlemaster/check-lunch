package com.silentnoodlemaster.checklunch;

public class Amica {

    String restaurantName;
    AmicaCourse[] courses;

    Amica(String restaurantName, AmicaCourse[] courses) {
        this.restaurantName = restaurantName;
        this.courses = courses;
    }

    String getRestaurantName() {
        return restaurantName;
    }

    public AmicaCourse[] getCourses() {
        return courses;
    }
}
