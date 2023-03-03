package org.msy.boot.controller.fuzzyqueries;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 11612
 * @date 2023/3/3
 */
@Controller
@RequestMapping("/fuzzy")
public class FuzzyController {

    @RequestMapping("/fuzzyQuery")
    public String query() {

        return "";
    }
}
