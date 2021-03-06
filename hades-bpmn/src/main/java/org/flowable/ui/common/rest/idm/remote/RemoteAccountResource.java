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
 * Module Name: hades-bpmn
 * File Name: RemoteAccountResource.java
 * Author: gengwei.zheng
 * Date: 2020/6/19 下午6:39
 * LastModified: 2020/4/22 上午10:30
 */

package org.flowable.ui.common.rest.idm.remote;

import org.flowable.ui.common.model.UserRepresentation;
import org.flowable.ui.common.security.DefaultPrivileges;
import org.flowable.ui.common.service.exception.NotFoundException;
import org.flowable.ui.common.service.idm.RemoteIdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : gengwei.zheng
 * @description : TODO
 * @date : 2019/10/28 18:10
 */
@RestController
@RequestMapping("/app")
public class RemoteAccountResource {

    @Autowired
    private RemoteIdmService remoteIdmService;

    /**
     * GET /rest/account -> get the current user.
     */
    @RequestMapping(value = "/rest/account", method = RequestMethod.GET, produces = "application/json")
    public UserRepresentation getAccount() {
//        UserRepresentation userRepresentation = null;
//        String currentUserId = SecurityUtils.getCurrentUserId();
//        if (currentUserId != null) {
//            RemoteUser remoteUser = remoteIdmService.getUser(currentUserId);
//            if (remoteUser != null) {
//                userRepresentation = new UserRepresentation(remoteUser);
//
//                if (remoteUser.getGroups() != null && remoteUser.getGroups().size() > 0) {
//                    List<GroupRepresentation> groups = new ArrayList<>();
//                    for (RemoteGroup remoteGroup : remoteUser.getGroups()) {
//                        groups.add(new GroupRepresentation(remoteGroup));
//                    }
//                    userRepresentation.setGroups(groups);
//                }
//
//                if (remoteUser.getPrivileges() != null && remoteUser.getPrivileges().size() > 0) {
//                    userRepresentation.setPrivileges(remoteUser.getPrivileges());
//                }
//
//            }
//        }
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setFirstName("admin");
        userRepresentation.setLastName("admin");
        userRepresentation.setFullName("admin");
        userRepresentation.setId("admin");
        List<String> pris = new ArrayList<>();
        pris.add(DefaultPrivileges.ACCESS_MODELER);
        pris.add(DefaultPrivileges.ACCESS_IDM);
        pris.add(DefaultPrivileges.ACCESS_ADMIN);
        pris.add(DefaultPrivileges.ACCESS_TASK);
        pris.add(DefaultPrivileges.ACCESS_REST_API);
        userRepresentation.setPrivileges(pris);

        if (userRepresentation != null) {
            return userRepresentation;
        } else {
            throw new NotFoundException();
        }
    }
}
