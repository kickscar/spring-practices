package videosystem;

import java.util.List;

public class DVDPack {
    private String title;
    private List<DigitalVideoDisc> dvds;

    public DVDPack() {
    }

    public DVDPack(String title, List<DigitalVideoDisc> dvds) {
        this.title = title;
        this.dvds = dvds;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDvds(List<DigitalVideoDisc> dvds) {
        this.dvds = dvds;
    }

    public List<DigitalVideoDisc> getDvds() {
        return dvds;
    }

    @Override
    public String toString() {
        return "DVDPack [title=" + title + ", dvds=" + dvds + "]";
    }
}
