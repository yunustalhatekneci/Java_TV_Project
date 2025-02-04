package oop;

public class Channel {
    private String name;
    private int channelNumber;

    public Channel(String name, int channelNumber) {
        this.name = name;
        this.channelNumber = channelNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(int channelNumber) {
        this.channelNumber = channelNumber;
    }

    public String showChannelInfo() {
        return "Name: " + name + ", Channel Number: " + channelNumber;
    }
}
