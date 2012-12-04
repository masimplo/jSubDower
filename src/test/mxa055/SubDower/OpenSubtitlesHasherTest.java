package test.mxa055.SubDower;

import java.io.File;
import java.io.IOException;
import junit.framework.Assert;
import mxa055.SubDower.OpenSubtitlesHasher;
import org.junit.Test;

public class OpenSubtitlesHasherTest {

	@Test
	public void testComputeHashFile() {
		try {
			File movieFile = new File("D:\\Media\\breakdance.avi");
			String expected = "8e245d9679d31e12";
			String actual = OpenSubtitlesHasher.computeHash(movieFile);
			Assert.assertEquals(expected, actual);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
