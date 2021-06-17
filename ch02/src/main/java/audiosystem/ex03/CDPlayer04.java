package audiosystem.ex03;

import audiosystem.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer04 {
	private CompactDisc compactDisc;

	@Autowired
	public void insertCD(CompactDisc compactDisc){
		this.compactDisc = compactDisc;
	}

	public void play() {
		compactDisc.play();
	}
}
