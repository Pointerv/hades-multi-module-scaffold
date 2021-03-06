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
 * File Name: SysRoleRepository.java
 * Author: gengwei.zheng
 * Date: 2020/6/19 下午6:39
 * LastModified: 2020/3/16 下午5:24
 */

package cn.com.felix.system.repository;

import cn.com.felix.core.enums.StateEnum;
import cn.com.felix.hr.domain.Employee;
import cn.com.felix.system.domain.SysRole;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SysRoleRepository extends JpaRepository<SysRole, String> {

    @EntityGraph(value = "SysRoleWithAndAuthority", type = EntityGraph.EntityGraphType.FETCH)
    SysRole findByRid(String id);


    @Modifying
    @Transactional
    @Query("delete from SysRole sr where sr.rid = ?1")
    void deleteByRid(String id);

    List<SysRole> findByAppidAndState(String appid, StateEnum stateEnum);

    List<SysRole> findByAppid(String appid);

    List<SysRole> findByAppidAndRoleName(String appid, String roleName);

    @Query(value = "SELECT se.full_name,se.pkid,se.phone_number FROM sys_user_role ur LEFT JOIN sys_role r on ur.rid=r.rid " +
            "LEFT JOIN sys_user su on ur.uid = su.uid " +
            "LEFT JOIN sys_employee se on su.employeeid =se.pkid " +
            "WHERE r.role_name=:roleName AND se.departmentid=:deptId", nativeQuery = true)
    List<Object[]> findUserAllNative(@Param("roleName") String roleName, @Param("deptId") String deptId);


    @Query(value = "SELECT se.full_name,se.pkid,se.phone_number FROM sys_user_role ur LEFT JOIN sys_role r on ur.rid=r.rid " +
            "LEFT JOIN sys_user su on ur.uid = su.uid " +
            "LEFT JOIN sys_employee se on su.employeeid =se.pkid " +
            "WHERE r.role_name=:roleName ", nativeQuery = true)
    List<Object[]> findUserAllNative(@Param("roleName") String roleName);
}