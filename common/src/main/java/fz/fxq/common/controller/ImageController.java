package fz.fxq.common.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("img")
public class ImageController {

    @GetMapping(value = "list", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] list() throws IOException {
        File file = new File("E:\\IMG_8416.JPG");
        FileInputStream fis = new FileInputStream(file);
        byte[] result = new byte[fis.available()];
        fis.read(result);
        fis.close();
        return result;
    }
}
