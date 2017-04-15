package com.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.repo.Item;
import com.repo.ItemRepository;
import com.repo.User;
import com.repo.UserRepository;

/**
 * Rest Controller entry point for the application
 * 
 * @author s.tsourdos
 */
@RestController
public class Controller {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository users;

    @Autowired
    private ItemRepository items;

    @RequestMapping("test")
    public String test() {
        log.info("Test");
        return "OK";
    }

    @RequestMapping("user")
    public User getUser(@RequestParam("id") long id) {
        log.info("Get user");
        return users.getUser(id);
    }

    @RequestMapping("item")
    public Item getItem(@RequestParam("id") long id) {
        log.info("Get item");
        return items.getItem(id);
    }
}
