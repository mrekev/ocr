package lt.mrekev.ocr;

import org.bytedeco.javacpp.tesseract.TessBaseAPI;

public class TesseractApi {

	private TessBaseAPI tesseractApi;

	public TesseractApi() {
		tesseractApi = new TessBaseAPI();
		 // Initialize tesseract-ocr with English, without specifying tessdata path
		if (tesseractApi.Init(".", "ENG") != 0) {
			throw new RuntimeException("Could not initialize tesseract.");
		}
	}
	
	public TessBaseAPI getApi() {
		return tesseractApi;
	}
	
	public void destroy() {
		tesseractApi.End();
	}
}
