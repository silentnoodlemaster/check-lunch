package com.silentnoodlemaster.checklunch;

public class SodexoCourse {
    private String title_fi, title_en, category, price, properties, desc_fi, desc_en, desc_se;

    SodexoCourse(String title_fi, String title_en, String category, String price, String properties, String desc_fi, String desc_en, String desc_se) {
        this.title_fi = title_fi;
        this.title_en = title_en;
        this.category = category;
        this.price = price;
        this.properties = properties;
        this.desc_fi = desc_fi;
        this.desc_en = desc_en;
        this.desc_se = desc_se;
    }

    public String getTitle_fi() {
        return title_fi;
    }

    public String getTitle_en() {
        return title_en;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public String getProperties() {
        return properties;
    }

    public String getDesc_fi() {
        return desc_fi;
    }

    public String getDesc_en() {
        return desc_en;
    }

    public String getDesc_se() {
        return desc_se;
    }
    @Override
    public String toString() {

        String s = !category.isEmpty()? category + ": " : "";
        s += title_en + " " + price + "€";
        return s;
    }
}
