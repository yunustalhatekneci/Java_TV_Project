package oop;

import java.util.ArrayList;

public class Television {
    private ArrayList<Channel> channels;
    private boolean isOn;
    private int volume;
    private int activeChannelIndex;
    private boolean isSetupDone;

    public Television() {
        channels = new ArrayList<>();
        volume = 10;
        activeChannelIndex = 0;
        isOn = false;
        isSetupDone = false;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("TV is now ON. Please complete the setup.");
        } else {
            System.out.println("TV is already ON.");
        }
    }

    public void setupTv() {
        if (!isSetupDone) {
            createChannels();
            isSetupDone = true;
            System.out.println("TV setup is complete. Channels have been configured according to the satellite.");
        } else {
            System.out.println("TV setup is already completed.");
        }
    }

    private void createChannels() {
        channels.add(new NewsChannel("CNN", 1, "General News"));
        channels.add(new Channel("Show TV", 2));
        channels.add(new MusicChannel("Dream Türk", 3, "Local Music"));
        channels.add(new MusicChannel("Number One", 4, "International Music"));
        channels.add(new NewsChannel("GS TV", 5, "Sports News"));
        channels.add(new NewsChannel("Bein Sports 1", 6, "Sports News"));
        channels.add(new NewsChannel("Bein Sports 2", 7, "Sports News"));
        channels.add(new NewsChannel("Bein Sports 3", 8, "Sports News"));
        channels.add(new NewsChannel("Bein Sports Haber", 9, "Sports News"));
        channels.add(new Channel("Kanal D", 10));
    }

    public boolean isSetupCompleted() {
        return isSetupDone;
    }

    public void increaseVolume() {
        if (!isSetupDone) {
            System.out.println("Please complete TV setup first.");
            return;
        }
        if (isOn && volume < 20) {
            volume++;
            System.out.println("Volume Level: " + volume);
        } else {
            System.out.println("Volume is already at maximum!");
        }
    }

    public void decreaseVolume() {
        if (!isSetupDone) {
            System.out.println("Please complete TV setup first.");
            return;
        }
        if (isOn && volume > 0) {
            volume--;
            System.out.println("Volume Level: " + volume);
        } else {
            System.out.println("Volume is already at minimum!");
        }
    }

    public void turnOff() {
        if (!isSetupDone) {
            System.out.println("Turning off TV...");
            isOn = false;
            return;
        }
        if (isOn) {
            isOn = false;
            System.out.println("TV is now OFF. Exiting system...");
        } else {
            System.out.println("TV is already OFF.");
        }
        System.exit(0);
    }

    public void changeChannel(int newChannel) {
        if (!isSetupDone) {
            System.out.println("Please complete TV setup first.");
            return;
        }
        if (isOn) {
            if (newChannel > 0 && newChannel <= channels.size()) {
                activeChannelIndex = newChannel - 1;
                System.out.println("Switched to Channel: " + channels.get(activeChannelIndex).showChannelInfo());
            } else {
                System.out.println("Invalid channel number.");
            }
        } else {
            System.out.println("Please turn on the TV first.");
        }
    }

    public void showActiveChannel() {
        if (!isSetupDone) {
            System.out.println("Please complete TV setup first.");
            return;
        }
        if (isOn) {
            System.out.println("Active Channel: " + channels.get(activeChannelIndex).showChannelInfo());
        } else {
            System.out.println("Please turn on the TV first.");
        }
    }
}
