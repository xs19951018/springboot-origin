package com.my.springbootorigin.attachment.controller;

import com.my.springbootorigin.attachment.controller.service.AttachmentService;
import com.my.springbootorigin.utils.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @RequestMapping("/uploadAvatar")
    public ResultVO uploadAvatar(@RequestParam("file") MultipartFile file, String key) {
        return attachmentService.uploadAvatar(file, key);
    }

}
