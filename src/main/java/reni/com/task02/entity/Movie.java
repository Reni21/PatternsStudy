package reni.com.task02.entity;

public class Movie {
    private String name;
    private Subtitle subtitle;
    private Sound sound;

    public Movie(String name, Subtitle subtitle, Sound sound) {
        this.name = name;
        this.subtitle = subtitle;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subtitle getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Subtitle subtitle) {
        this.subtitle = subtitle;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }
}
