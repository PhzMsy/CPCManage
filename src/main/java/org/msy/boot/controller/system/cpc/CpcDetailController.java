package org.msy.boot.controller.system.cpc;

import org.msy.boot.entity.CpcDetail;
import org.msy.boot.service.system.cpcdetail.CpcDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 11612
 * @date 2023/2/28
 */
@Controller
@RequestMapping("/CpcDetail")
public class CpcDetailController {

    @Autowired
    private CpcDetailService cpcDetailService;

    @GetMapping("/queryById")
    public String queryById(@RequestParam("cpcId") Integer id, Model model){
        System.out.println(id);
        CpcDetail list = cpcDetailService.queryById(id);
        System.out.println(list);
        model.addAttribute("query",list);
        return "/cpc/cpcDetail";
    }

}
