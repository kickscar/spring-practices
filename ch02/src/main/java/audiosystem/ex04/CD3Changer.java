package audiosystem.ex04;

import audiosystem.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

@Component
public class CD3Changer {
	private CompactDisc[] compactDiscs = new CompactDisc[3];

	@Autowired
	public void disc1(CompactDisc compactDisc){
		this.compactDiscs[0] = compactDisc;
	}

	@Autowired
	public void disc2(@Qualifier("greenDayInsomniac") CompactDisc compactDisc){
		this.compactDiscs[1] = compactDisc;
	}

	@Inject
	public void disc3(@Named("greenDayNimrod") CompactDisc compactDisc){
		this.compactDiscs[2] = compactDisc;
	}

	public void play(int number) {
		compactDiscs[number-1].play();
	}
}
