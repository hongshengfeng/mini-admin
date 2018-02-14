package cn.scene.controller;

import cn.scene.model.Message;
import cn.scene.model.Scene;
import cn.scene.model.User;
import cn.scene.service.AboutService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户相关
 */
@Controller
@RequestMapping("/about")
public class AboutController {

    @Autowired
    private AboutService aboutService;

    //通知信息
    @RequestMapping("/message")
    public @ResponseBody List<Message> message(HttpServletRequest request){
        String index = request.getParameter("userId");
        String regx = "^[0-9]+$";
        List<Message> list = new ArrayList<>();
        if(StringUtils.isNotBlank(index) && index.matches(regx)){
            int userId = Integer.parseInt(index);
            list = aboutService.selectInfo(userId);
        }
        return list;
    }

    //我的模板
    @RequestMapping("/scene/make")
    public @ResponseBody List<Scene> makeSecne(HttpServletRequest request){
        String index = request.getParameter("userId");
        //0-原创,1-非原创
        String temp = request.getParameter("temp");
        String regx = "^[0-9]+$";
        List<Scene> list = new ArrayList<>();
        if(StringUtils.isNotBlank(index) && index.matches(regx) && temp.matches(regx)){
            int userId = Integer.parseInt(index);
            int fromId = Integer.parseInt(temp);
            list = aboutService.selectScene(userId,fromId);
        }
        return list;
    }

}