package soundsystem.ex03;

import soundsystem.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer02 {

	private CompactDisc compactDisc;

	@Autowired
	public CDPlayer02(CompactDisc compactDisc){
		this.compactDisc = compactDisc;
	}

	public void play() {
		compactDisc.play();
	}
}
