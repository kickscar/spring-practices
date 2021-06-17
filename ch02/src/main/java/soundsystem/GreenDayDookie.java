package soundsystem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class GreenDayDookie implements CompactDisc {
    private String title = "She";
    private String artist = "Green Day";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
