/*
Copyright 2019 The Alcor Authors.

Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package com.futurewei.alcor.web.entity.securitygroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SecurityGroupsJson {

    @JsonProperty("security_groups")
    private ArrayList<SecurityGroup> securityGroups;

    public SecurityGroupsJson() {

    }

    public SecurityGroupsJson(List<SecurityGroup> securityGroups) {
        this.securityGroups = new ArrayList<>(securityGroups);
    }

    public ArrayList<SecurityGroup> getSecurityGroups() {
        return securityGroups;
    }

    public void setSecurityGroups(ArrayList<SecurityGroup> securityGroups) {
        this.securityGroups = securityGroups;
    }
}