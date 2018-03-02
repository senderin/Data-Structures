
public class AudioCDInfo {
	
	private String title;
	private String artist;
	private String genre;
	private String releaseDate;
	private String totalTime;
	
	public AudioCDInfo(String[] split) {
		
		setTitle(split[0]);
		setArtist(split[1]);
		setGenre(split[2]);
		setReleaseDate(split[3]);
		setTotalTime(split[4]);
		
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}	
}
