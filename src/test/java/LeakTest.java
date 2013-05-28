import com.aspose.words.Document;
import com.aspose.words.PdfSaveOptions;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: rebizant
 * Date: 28.05.13
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */

public class LeakTest {

	@Test
	public void generateLeak() throws Exception {

		for (int i = 0; i < 2000; i++) {
			convert(i);
		}
	}

	private void convert(int i) throws Exception {
		InputStream doc = getStreamFromResource("/example.doc");
		ByteArrayOutputStream docAsPdf = new ByteArrayOutputStream();
		new Document(doc).save(docAsPdf, new PdfSaveOptions());
		System.out.println("converted iteration " + i);
	}

	private InputStream getStreamFromResource(String resource) {

		return this.getClass().getResourceAsStream(resource);
	}
}
