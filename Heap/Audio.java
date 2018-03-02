import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioFileFormat.Type;

public class Audio {

	byte[] cutAudio;
	byte[] audio;
	
	AudioInputStream audioInputStream;
	
	public byte[] readAudio() throws UnsupportedAudioFileException, IOException
	{
		File audioFile=new File("input.wav");
		audioInputStream=AudioSystem.getAudioInputStream(audioFile);
		audio=new byte[(int) audioFile.length()];
		audioInputStream.read(audio);
		System.out.println("Original audio was read...");
		cutAudio=new byte[(int) audio.length-46];
		for(int i=46; i<audio.length; i++)
			cutAudio[i-46]=audio[i];
		System.out.println("First 46 bytes was cut...");
		return cutAudio;
	}

	public void saveAudio() throws IOException
	{
		InputStream inputStream=new ByteArrayInputStream(audio);
		AudioFormat format=audioInputStream.getFormat();
		AudioInputStream stream=new AudioInputStream(inputStream, format, audio.length);
		File newAudioFile=new File("output.wav");
		AudioSystem.write(stream, Type.WAVE, newAudioFile);	
		System.out.println("Ouput.wav was saved...");
	}
	
	public void mergeAudios(byte[] newAudio)
	{
		for(int i=46; i<audio.length; i++)
		{
			audio[i]=newAudio[i-46];
		}
		System.out.println("First 46 bytes-unsorted and"+ " after 46 bytes-sorted parts was merged...");
	}
}
