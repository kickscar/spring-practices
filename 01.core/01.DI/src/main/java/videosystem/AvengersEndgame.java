package videosystem;

public class AvengersEndgame implements DigitalVideoDisc {
	private String title = "Avengers Endgame";
	private String studio = "MARVEL";

	@Override
	public void play() {
		System.out.println("Playing Movie " + studio + "'s " + title);
	}
}
