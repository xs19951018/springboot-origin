package com.my.springbootorigin.attachment.controller.service.impl;

import com.my.springbootorigin.attachment.controller.service.AttachmentService;
import com.my.springbootorigin.utils.QiNiuUtil;
import com.my.springbootorigin.utils.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Override
    public ResultVO uploadAvatar(MultipartFile file, String key) {
        ResultVO resultVO = new ResultVO();

        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.indexOf("."));
        key += suffix;
        boolean b = QiNiuUtil.uploadMultipartFile(file, key, true);
        if (b) {
            String avatarUrl = QiNiuUtil.getFileUrl(key);
            // 刷新CDN缓存
            QiNiuUtil.refreshUrl(avatarUrl);

            resultVO.setData(avatarUrl);
        }

        return resultVO;
    }
}
