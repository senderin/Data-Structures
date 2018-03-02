import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Test {
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException
	{
		Audio audio=new Audio();
		byte[] input=audio.readAudio();
		Heap heap=new Heap(input.length);
		heap.construct(input);
		heap.sort();
		audio.mergeAudios(heap.sortedArray);
		audio.saveAudio();
	}
	
}
