package audiosystem;

import org.springframework.stereotype.Component;

@Component
public class GreenDayNimrod implements CompactDisc {
    private String title = "Jinx";
    private String artist = "Green Day";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
