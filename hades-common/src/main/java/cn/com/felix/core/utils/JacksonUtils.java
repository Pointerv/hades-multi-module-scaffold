/*
 * Copyright (c) 2019-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 * Project Name: hades-platform
 * Module Name: hades-common
 * File Name: JacksonUtils.java
 * Author: gengwei.zheng
 * Date: 2020/6/19 下午6:39
 * LastModified: 2020/4/22 上午10:30
 */

package cn.com.felix.core.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by hades on 2016/8/9.
 */
public class JacksonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JacksonUtils.class);

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        //去掉默认的时间戳格式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //设置为中国上海时区
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        //空值不序列化
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //反序列化时，属性不存在的兼容处理
        objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //序列化时，日期的统一格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //单引号处理
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        try {
            return getObjectMapper().readValue(json, clazz);
        } catch (JsonParseException e) {
            logger.error("[JacksonUtils] |- toObject parse json error! {}", e.getMessage());
        } catch (JsonMappingException e) {
            logger.error("[JacksonUtils] |- toObject mapping to object error! {}", e.getMessage());
        } catch (IOException e) {
            logger.error("[JacksonUtils] |- toObject read content error! {}", e.getMessage());
        }

        return null;
    }

    public static <T> String toJson(T entity) {
        try {
            return getObjectMapper().writeValueAsString(entity);
        } catch (JsonParseException e) {
            logger.error("[JacksonUtils] |- toCollection parse json error! {}", e.getMessage());
        } catch (JsonMappingException e) {
            logger.error("[JacksonUtils] |- toCollection mapping to object error! {}", e.getMessage());
        } catch (IOException e) {
            logger.error("[JacksonUtils] |- toCollection read content error! {}", e.getMessage());
        }

        return null;
    }

    public static <T> List<T> toList(String json, Class<T> clazz){
        JavaType javaType =getObjectMapper().getTypeFactory().constructParametricType(ArrayList.class, clazz);
        try {
            return (List<T>) getObjectMapper().readValue(json, javaType);
        } catch (JsonParseException e) {
            logger.error("[JacksonUtils] |- toCollection parse json error! {}", e.getMessage());
        } catch (JsonMappingException e) {
            logger.error("[JacksonUtils] |- toCollection mapping to object error! {}", e.getMessage());
        } catch (IOException e) {
            logger.error("[JacksonUtils] |- toCollection read content error! {}", e.getMessage());
        }

        return null;
    }

    public static <T> T toCollection(String json, TypeReference<T> typeReference) {
        try {
            return getObjectMapper().readValue(json, typeReference);
        } catch (JsonParseException e) {
            logger.error("-| [JacksonUtils]: toCollection parse json error! {}", e.getMessage());
        } catch (JsonMappingException e) {
            logger.error("-| [JacksonUtils]: toCollection mapping to object error! {}", e.getMessage());
        } catch (IOException e) {
            logger.error("-| [JacksonUtils]: toCollection read content error! {}", e.getMessage());
        }

        return null;
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
