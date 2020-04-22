/*
 * Copyright (c) 2019. All Rights Reserved
 * ProjectName: hades-multi-module
 * FileName: Identity
 * Author: hades
 * Date: 19-2-15 下午2:12
 * LastModified: 19-2-15 下午2:12
 */

package cn.com.felix.core.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @author hades
 * @date 2019/2/15
 */
public enum Identity {
    LEADERSHIP(0, "领导"),
    STAFF(1, "员工");

    private int index;
    private String name;

    private static Map<Integer, Identity> map = new HashMap<>();

    static {
        for (Identity identity : Identity.values()) {
            map.put(identity.index, identity);
        }
    }

    Identity(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public static Identity getIdentity(int index) {
        return map.get(index);
    }
}
