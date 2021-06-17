package audiosystem.ex02;

import audiosystem.CompactDisc;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component("CDPlayerEx02")
public class CDPlayer {
    private CompactDisc cd;

    @Inject
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
