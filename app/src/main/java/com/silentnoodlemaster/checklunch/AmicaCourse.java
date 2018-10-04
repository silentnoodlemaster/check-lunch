package com.silentnoodlemaster.checklunch;

public class AmicaCourse {
    private String components;

    AmicaCourse(String components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return components;
    }
}
