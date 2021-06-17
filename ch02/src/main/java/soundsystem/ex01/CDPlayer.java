package soundsystem.ex01;

import soundsystem.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("CDPlayerEx01")
public class CDPlayer {

    @Autowired
    private CompactDisc cd;

    public void play() {
        cd.play();
    }
}
