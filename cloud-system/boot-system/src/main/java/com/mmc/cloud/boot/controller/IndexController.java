package com.mmc.cloud.boot.controller;

import com.mmc.cloud.boot.common.RandomType;
import com.mmc.cloud.boot.config.AutoDefineConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @packageName：com.mmc.cloud.boot.controller
 * @desrciption: 主要访问入口Controller
 * @author: GW
 * @date： 2020-07-27 14:08
 * @history: (version) author date desc
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private AutoDefineConfig autoDefineConfig;

    @GetMapping("/page")
    public String index() {
        return "index page";
    }


    @GetMapping("/auto")
    public String auto() {
        return "auto param name=" + autoDefineConfig.getName() + ", project=" + autoDefineConfig.getProject();
    }

    @GetMapping("/random/{type}")
    public String random(@PathVariable("type") int type) {
        StringBuffer sb = null;
        if (type == RandomType.TYPE0.getType()) {
            sb = new StringBuffer();
            sb.append(RandomType.TYPE1);
            sb.append("\n");
            sb.append(autoDefineConfig.getRandomValue());
            sb.append("\n");
            sb.append(RandomType.TYPE2);
            sb.append("\n");
            sb.append(autoDefineConfig.getRandomInt());
            sb.append("\n");
            sb.append(RandomType.TYPE3);
            sb.append("\n");
            sb.append(autoDefineConfig.getRandomLong());
            sb.append("\n");
            sb.append(RandomType.TYPE4);
            sb.append("\n");
            sb.append(autoDefineConfig.getRandomRangeInt());
            sb.append("\n");
            sb.append(RandomType.TYPE5);
            sb.append("\n");
            sb.append(autoDefineConfig.getRandomRangeLong());
            sb.append("\n");
            return sb.toString();
        } else if (type == RandomType.TYPE1.getType()) {
            sb = new StringBuffer();
            sb.append(RandomType.TYPE1);
            sb.append("\n");
            sb.append(autoDefineConfig.getRandomValue());
            return sb.toString();
        } else if (type == RandomType.TYPE2.getType()) {
            sb = new StringBuffer();
            sb.append(RandomType.TYPE2);
            sb.append("\n");
            sb.append(autoDefineConfig.getRandomInt());
            return sb.toString();
        } else if (type == RandomType.TYPE3.getType()) {
            sb = new StringBuffer();
            sb.append(RandomType.TYPE3);
            sb.append("\n");
            sb.append(autoDefineConfig.getRandomLong());
            return sb.toString();
        } else if (type == RandomType.TYPE4.getType()) {
            sb = new StringBuffer();
            sb.append(RandomType.TYPE4);
            sb.append("\n");
            sb.append(autoDefineConfig.getRandomRangeInt());
            return sb.toString();
        } else if (type == RandomType.TYPE5.getType()) {
            sb = new StringBuffer();
            sb.append(RandomType.TYPE5);
            sb.append("\n");
            sb.append(autoDefineConfig.getRandomRangeLong());
            return sb.toString();
        }
        return "type not exits";
    }
}
