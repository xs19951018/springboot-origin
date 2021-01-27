package com.my.springbootorigin.utils;

import com.google.gson.Gson;
import com.my.springbootorigin.utils.config.QiNiuConfigProperties;
import com.qiniu.cdn.CdnManager;
import com.qiniu.cdn.CdnResult;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * 七牛上传下载工具类
 * @author simon
 * @create 2018-08-15 11:21
 **/
@Component
public class QiNiuUtil {

    private Logger logger = LoggerFactory.getLogger(QiNiuUtil.class);

    private static String accessKey;
    private static String secretKey;
    private static String bucket;
    private static String domain;
    private static long expire;
    @Autowired
    private QiNiuConfigProperties qiNiuConfigProperties;

    @PostConstruct
    public void init() {
        accessKey = qiNiuConfigProperties.getAccessKey();
        secretKey = qiNiuConfigProperties.getSecretKey();
        bucket = qiNiuConfigProperties.getBucket();
        domain = qiNiuConfigProperties.getDomain();
        expire = qiNiuConfigProperties.getExpire();
    }

    /**
     * 上传本地文件
     * @param localFilePath 本地文件完整路径
     * @param key 文件云端存储的名称
     * @param override 是否覆盖同名同位置文件
     * @return
     */
    public static boolean upload(String localFilePath, String key, boolean override){
        // 构造一个带指定Region对象的配置类
        Configuration cfg = new Configuration(Region.region2());
        UploadManager uploadManager = new UploadManager(cfg);
        //.生成上传凭证，然后准备上传
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken;
        if(override){
            // 覆盖上传凭证
            upToken = auth.uploadToken(bucket, key);
        }else{
            upToken = auth.uploadToken(bucket);
        }
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.hash);
            System.out.println(putRet.key);
            return true;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
                return false;
            }
            return false;
        }
    }

    /**
     * 上传MultipartFile
     * @param file
     * @param key
     * @param override
     * @return
     * @throws IOException
     */
    public static boolean uploadMultipartFile(MultipartFile file, String key, boolean override) {
        // 构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Region.region2());
        UploadManager uploadManager = new UploadManager(cfg);

        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            is = file.getInputStream();
            bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = is.read(b)) != -1){
                bos.write(b, 0, len);
            }
            byte[] uploadBytes= bos.toByteArray();

            Auth auth = Auth.create(accessKey, secretKey);
            String upToken;
            if(override){
                upToken = auth.uploadToken(bucket, key,3600, new StringMap().put("insertOnly", 0));//覆盖上传凭证
            }else{
                upToken = auth.uploadToken(bucket);
            }

            // 进行上传操作，传入文件的字节数组，文件名，上传空间，得到回复对象
            Response response = uploadManager.put(uploadBytes, key, upToken);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

//            System.out.println(putRet.key);
//            System.out.println(putRet.hash);
        } catch (QiniuException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
                if (bos != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 刷新cdn缓存
     * @param url
     */
    public static void refreshUrl(String url) {
        String[] urls = {url};

        try {
            Auth auth = Auth.create(accessKey, secretKey);
            CdnManager cdnManager = new CdnManager(auth);
            CdnResult.RefreshResult refreshResult = cdnManager.refreshUrls(urls);
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取文件访问地址
     * @param fileName 文件云端存储的名称
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getFileUrl(String fileName) {
        try {
            String encodedFileName = URLEncoder.encode(fileName, "utf-8");
            String publicUrl = String.format("%s/%s", domain, encodedFileName);
            return publicUrl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
