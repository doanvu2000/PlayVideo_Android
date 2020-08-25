package com.example.videocategory;

public class ImageBanner {
    int ID;
    String name;
    String link;

    public ImageBanner() {
    }

    public ImageBanner(int ID, String name, String link) {
        this.ID = ID;
        this.name = name;
        this.link = link;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
