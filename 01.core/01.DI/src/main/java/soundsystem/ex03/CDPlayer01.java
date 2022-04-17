package soundsystem.ex03;

import soundsystem.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer01 {

	@Autowired
	private CompactDisc compactDisc;

	public void play() {
		compactDisc.play();
	}
}
