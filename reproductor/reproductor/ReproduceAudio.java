package reproductor;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

class reproductor{
	protected reproductor(String ruta, boolean bool) {
		if (bool==false) {
			reproducir(ruta);
		}else {
			reproducirloop(ruta);
		}
    }
	
	private void reproducir(String ruta) {
		try {
            
        	AudioInputStream x = AudioSystem.getAudioInputStream(new File(ruta));
            Clip c = AudioSystem.getClip();            
            c.open(x);            
            /*
             *	System.out.println(c.getBufferSize());
             *	c.loop(Clip.LOOP_CONTINUOUSLY);
             * */
            c.start();

            Thread.sleep(c.getBufferSize());
            c.close();
                        
        } catch (Exception e) {
            System.out.println("" + e);
        }
	}
	
	
	private void reproducirloop(String ruta) {
		try {
            
	    	AudioInputStream x = AudioSystem.getAudioInputStream(new File(ruta));
	        Clip c = AudioSystem.getClip();            
	        c.open(x);            
	        /*System.out.println(c.getBufferSize());*/
	        c.loop(Clip.LOOP_CONTINUOUSLY);
            c.start();

            Thread.sleep(c.getBufferSize());
                        
        } catch (Exception e) {
            System.out.println("" + e);
        }
	}
	
	
	
}

