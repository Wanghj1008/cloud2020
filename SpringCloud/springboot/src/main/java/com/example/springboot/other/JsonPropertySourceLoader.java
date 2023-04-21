package com.example.springboot.other;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonPropertySourceLoader implements PropertySourceLoader {

    @Override
    public String[] getFileExtensions() {
        //这个方法表明这个类支持解析以json结尾的配置文件
        return new String[]{"json"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {

        ReadableByteChannel readableByteChannel = resource.readableChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) resource.contentLength());

        //将文件内容读到 ByteBuffer 中
        readableByteChannel.read(byteBuffer);
        //将读出来的字节转换成字符串
        String content = new String(byteBuffer.array());
        // 将字符串转换成 JSONObject
        JSONObject jsonObject =JSONUtil.parseObj(content);

        Map<String, Object> map = new HashMap<>(jsonObject.size());
        //将 json 的键值对读出来，放入到 map 中
        for (String key : jsonObject.keySet()) {
            map.put(key, jsonObject.get(key));
        }

        return Collections.singletonList(new MapPropertySource("jsonPropertySource", map));
    }

}