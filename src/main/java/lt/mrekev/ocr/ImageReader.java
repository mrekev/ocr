package lt.mrekev.ocr;

import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;

public class ImageReader {

    private TesseractApi tesseractApi;

    public ImageReader(TesseractApi tesseractApi) {
        this.tesseractApi = tesseractApi;
    }

    public String scanImage(String imagePath) {
        PIX image = pixRead(imagePath);
        TessBaseAPI api = tesseractApi.getApi();
        api.SetImage(image);
        BytePointer outText = api.GetUTF8Text();
        String recognition = outText.getString();
        return recognition;
    }
}
