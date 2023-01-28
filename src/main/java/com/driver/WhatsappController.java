package com.driver;

import java.util.*;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("whatsapp")
public class WhatsappController {


    WhatsappService whatsappService = new WhatsappService();

    @PostMapping("/add-user")
    public String createUser(String name, String mobile) throws Exception {


        if(!whatsappService.isNewUser(mobile)) {
            throw new Exception("User already exists");
        }

        return whatsappService.createUser(name, mobile);
    }

    @PostMapping("/add-group")
    public Group createGroup(List<User> users){


        return whatsappService.createGroup(users);
    }

    @PostMapping("/add-message")
    public int createMessage(String content){


        return whatsappService.createMessage(content);
    }

    @PutMapping("/send-message")
    public int sendMessage(Message message, User sender, Group group) throws Exception{


        return whatsappService.sendMessage(message, sender, group);
    }
    @PutMapping("/change-admin")
    public String changeAdmin(User approver, User user, Group group) throws Exception{


        return whatsappService.changeAdmin(approver, user, group);
    }


}