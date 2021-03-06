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
 * File Name: Hierarchy.java
 * Author: gengwei.zheng
 * Date: 2020/6/19 下午6:39
 * LastModified: 2020/4/22 上午10:30
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
public enum Hierarchy {

    SENIOR(0, "高层"),
    MIDDLE(1, "中层"),
    GRASS_ROOTS(2, "基层");

    private int index;
    private String name;

    private static Map<Integer, Hierarchy> map = new HashMap<>();

    static {
        for (Hierarchy hierarchy : Hierarchy.values()) {
            map.put(hierarchy.index, hierarchy);
        }
    }

    Hierarchy(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public static Hierarchy getHierarchy(int index) {
        return map.get(index);
    }
}
