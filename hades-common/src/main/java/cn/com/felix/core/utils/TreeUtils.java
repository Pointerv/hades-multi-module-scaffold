/*
 * Copyright 2019-2019 the original author or authors.
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
 * Project Name: hades-multi-module
 * Module Name: hades-common
 * File Name: TreeUtils.java
 * Author: gengwei.zheng
 * Date: 2019/11/11 下午8:02
 * LastModified: 2019/11/8 下午4:16
 */

package cn.com.felix.core.utils;

import cn.com.felix.common.basic.domain.TreeNode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形对象构造工具类
 *
 * @author gengwei.zheng
 */
public class TreeUtils {

    public final static String DEFAULT_ROOT_ID = "0";

    public static List<TreeNode> build(List<TreeNode> treeNodes) {
        return build(treeNodes, DEFAULT_ROOT_ID);
    }

    /**
     * 使用递归方法建树
     * @param treeNodes
     * @return
     */
    public static List<TreeNode> build(List<TreeNode> treeNodes, String root) {
        if (StringUtils.isEmpty(root)) {
            root = DEFAULT_ROOT_ID;
        }

        List<TreeNode> trees = new ArrayList<>();
        for (TreeNode treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {
                trees.add(findChildren(treeNode,treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     * @param treeNodes
     * @return
     */
    public static TreeNode findChildren(TreeNode parentTreeNode,List<TreeNode> treeNodes) {
        for (TreeNode treeNode : treeNodes) {
            if(parentTreeNode.getId().equals(treeNode.getParentId())) {
                if (parentTreeNode.getChildren() == null) {
                    parentTreeNode.setChildren(new ArrayList<>());
                }
                parentTreeNode.getChildren().add(findChildren(treeNode,treeNodes));
            }
        }
        return parentTreeNode;
    }
}
