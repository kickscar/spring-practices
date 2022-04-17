package videosystem;

public class DVDPlayer {
	private DigitalVideoDisc digitalVideoDisc;

	public DVDPlayer() {
	}

	public DVDPlayer(DigitalVideoDisc digitalVideoDisc) {
		this.digitalVideoDisc = digitalVideoDisc;
	}

	public DigitalVideoDisc getDigitalVideoDisc() {
		return digitalVideoDisc;
	}

	public void setDigitalVideoDisc(DigitalVideoDisc digitalVideoDisc) {
		this.digitalVideoDisc = digitalVideoDisc;
	}

	public void play() {
		digitalVideoDisc.play();
	}
}
