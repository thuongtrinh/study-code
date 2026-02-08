package com.txt.restfull;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.txt.model.Message;

@RestController
public class PageRestController {

    @RequestMapping(value = {"/wel"}, method = RequestMethod.GET)
    public String welcome() {
        return "Welcome you to with RestTemplate";
    }

    @RequestMapping(value = "welcome/{player}", method = RequestMethod.GET)
    public Message message(@PathVariable String player) {
        Message message = new Message();
        message.setName("Ducky");
        message.setText("Hello " + player);
        return message;
    }

}
