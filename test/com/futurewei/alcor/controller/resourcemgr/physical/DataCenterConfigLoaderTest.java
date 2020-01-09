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

package com.futurewei.alcor.controller.resourcemgr.physical;

import com.futurewei.alcor.controller.model.HostInfo;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DataCenterConfigLoaderTest {

    @Test
    public void machineConfigFileLoadTest() {
        List<HostInfo> hostNodeList = DataCenterConfigLoader.loadAndGetHostNodeList(".\\test\\com\\futurewei\\alcor\\controller\\resourcemgr\\physical\\machine.json");

        Assert.assertEquals("incorrect number of nodes", 200, hostNodeList.size());

        // Check the first node
        Assert.assertEquals("incorrect host id", "ephost_0", hostNodeList.get(0).getId());
        Assert.assertEquals("incorrect host ip", "172.17.0.2", hostNodeList.get(0).getHostIpAddress());
        Assert.assertEquals("incorrect host mac", "02:42:ac:11:00:02", hostNodeList.get(0).getHostMacAddress());

        // Check the last node
        Assert.assertEquals("incorrect host id", "ephost_199", hostNodeList.get(199).getId());
        Assert.assertEquals("incorrect host ip", "172.17.0.201", hostNodeList.get(199).getHostIpAddress());
        Assert.assertEquals("incorrect host mac", "02:42:ac:11:00:c9", hostNodeList.get(199).getHostMacAddress());
    }
}