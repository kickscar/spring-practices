package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class GreenDayInsomniac implements CompactDisc {
    private String title = "Jaded";
    private String artist = "Green Day";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
