package oop;

public class MusicChannel extends Channel {
    private String musicGenre;

    public MusicChannel(String name, int channelNumber, String musicGenre) {
        super(name, channelNumber);
        this.musicGenre = musicGenre;
    }

    public String getMusicGenre() {
        return musicGenre;
    }
}
