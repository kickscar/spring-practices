package audiosystem.ex03;

import audiosystem.CompactDisc;
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
