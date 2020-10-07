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

package com.futurewei.alcor.web.entity.ip;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class IpAddrRequestBulk {
    @JsonProperty("ip_requests")
    private List<IpAddrRequest> ipRequests;

    public IpAddrRequestBulk() {
    }

    public IpAddrRequestBulk(List<IpAddrRequest> ipRequests) {
        this.ipRequests = ipRequests;
    }

    public List<IpAddrRequest> getIpRequests() {
        return ipRequests;
    }

    public void setIpRequests(List<IpAddrRequest> ipRequests) {
        this.ipRequests = ipRequests;
    }

    @Override
    public String toString() {
        return "IpAddrRequestBulk{" +
                "ipRequests=" + ipRequests +
                '}';
    }
}
