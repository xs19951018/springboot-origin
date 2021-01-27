package com.my.springbootorigin.component.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.nio.charset.Charset;

public class ParamterRequestWrapper extends HttpServletRequestWrapper {

    private Logger logger = LoggerFactory.getLogger(ParamterRequestWrapper.class);

    public ParamterRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        // 非json类型，直接返回
        if(!super.getHeader(HttpHeaders.CONTENT_TYPE).equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)){
            return super.getInputStream();
        }
        // 为空，直接返回
        String json = inputSteamToString(super.getInputStream());
        if (!StringUtils.hasLength(json)) {
            return super.getInputStream();
        }
        JSONObject jsonObject = JSON.parseObject(json);

        // TODO
        logger.info("------------ 对request请求的参数做点什么 ---------------");

        ByteArrayInputStream bis = new ByteArrayInputStream(jsonObject.toJSONString().getBytes("utf-8"));
        return new MyServletInputStream(bis);
    }

    /**
     * request输入流转json字符串
     * @param is
     * @return
     */
    private String inputSteamToString(InputStream is) {
        StringBuffer sb = new StringBuffer();

        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("utf-8")));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            sb.setLength(0);
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

    class MyServletInputStream extends ServletInputStream {

        private ByteArrayInputStream bis;

        public MyServletInputStream(ByteArrayInputStream bis) {
            this.bis = bis;
        }


        @Override
        public boolean isFinished() {
            return true;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener readListener) {

        }

        @Override
        public int read() throws IOException {
            return bis.read();
        }
    }
}
