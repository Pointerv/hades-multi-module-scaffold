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
 * File Name: SysWeappDefaultRoleRepository.java
 * Author: gengwei.zheng
 * Date: 2020/6/19 下午6:39
 * LastModified: 2020/4/22 上午10:30
 */

package cn.com.felix.system.repository;

import cn.com.felix.system.domain.SysWeappDefaultRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Description: </p>
 *
 * @author hades
 * @date 2019/3/11
 */
public interface SysWeappDefaultRoleRepository extends JpaRepository<SysWeappDefaultRole, String> {

    SysWeappDefaultRole findByAppidAndOrgnizationid(String appid, String orgnizationid);
}
