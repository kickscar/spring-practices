package videosystem;

import java.util.List;

public class BlankDigitalVideoDisc implements DigitalVideoDisc {
    private String title;
    private String studio;
    private List<String> actors;

    public BlankDigitalVideoDisc() {
    }

    public BlankDigitalVideoDisc(String title, String studio) {
        this.title = title;
        this.studio = studio;
    }

    public BlankDigitalVideoDisc(String title, String studio, List<String> actors) {
        this.title = title;
        this.studio = studio;
        this.actors = actors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    @Override
    public void play() {
        System.out.println("Playing Movie " + studio + "'s " + title);
    }

    @Override
    public String toString() {
        return "BlankDigitalVideoDisc{" +
                "title='" + title + '\'' +
                ", studio='" + studio + '\'' +
                ", actors=" + actors +
                '}';
    }
}
