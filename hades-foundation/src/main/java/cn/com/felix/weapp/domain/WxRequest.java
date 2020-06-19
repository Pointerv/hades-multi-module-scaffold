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
 * Module Name: hades-foundation
 * File Name: WxRequest.java
 * Author: gengwei.zheng
 * Date: 2020/6/19 下午6:39
 * LastModified: 2020/3/16 下午5:24
 */

package cn.com.felix.weapp.domain;

import cn.com.felix.common.basic.domain.AbstractDomain;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class WxRequest extends AbstractDomain {

    /**
     * 临时登录凭证：必传，通过code来换取后台的sessionKey和openId
     */
    private String code;
    /**
     * 用户非敏感信息
     */
    private String rawData;
    /**
     * 签名
     */
    private String signature;
    /**
     * 用户敏感信息
     */
    private String encryptedData;
    /**
     * 解密算法的向量
     */
    private String iv;

    private String appId;

    private String openId;
    private String sessionKey;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("code", code)
                .append("rawData", rawData)
                .append("signature", signature)
                .append("encryptedData", encryptedData)
                .append("iv", iv)
                .append("appId", appId)
                .append("openId", openId)
                .append("sessionKey", sessionKey)
                .toString();
    }
}
