package com.example.test_listview;

public class MusicListArray {
    private int imageId;
    private String name;
    private String info;
    private boolean check = false;

    public MusicListArray(int imageId, String name, String info) {
        this.imageId = imageId;
        this.name = name;
        this.info = info;
    }

    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIfo() {
        return info;
    }
    public void setIfo(String info) {
        this.info = info;
    }
    public boolean isCheck() { return check; }
    public void setCheck(boolean check) { this.check = check; }
}
