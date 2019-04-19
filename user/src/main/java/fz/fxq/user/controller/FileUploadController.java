package fz.fxq.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("file")
public class FileUploadController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("upload.html")
    public String upload() {
        return "upload/fileUpload";
    }

    @GetMapping("fileUploadResult.html")
    public String fileUploadResult() {
        return "upload/fileUploadResult";
    }

    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:fileUploadResult";
        }

        try {
            redirectAttributes.addFlashAttribute("message", "OriginalFilename[" + file.getOriginalFilename() + "]length[" + file.getBytes().length + "]");
        } catch (Exception e) {
            logger.error("文件上传，系统异常：", e);
        }

        return "redirect:fileUploadResult.html";
    }

}
