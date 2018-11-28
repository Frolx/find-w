package com.spring.boot;

import com.spring.test.Util;
import com.spring.test.frlx.SiteLink;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RestControllerMap {

    private SiteLink<String> tree;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) throws IOException {
        tree = new SiteLink<String>(name);
        Util.parseLink(tree, 0);
        return tree.toString();
    }

}
