package com.my.springbootorigin.attachment.controller.service;

import com.my.springbootorigin.utils.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {

    ResultVO uploadAvatar(MultipartFile file, String key);
}
