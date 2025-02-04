package oop;

public class NewsChannel extends Channel {
    private String newsType;

    public NewsChannel(String name, int channelNumber, String newsType) {
        super(name, channelNumber);
        this.newsType = newsType;
    }

    public String getNewsType() {
        return newsType;
    }
}
