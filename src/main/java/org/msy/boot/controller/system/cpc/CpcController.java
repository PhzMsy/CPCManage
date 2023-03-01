package org.msy.boot.controller.system.cpc;

import org.msy.boot.entity.Cpc;
import org.msy.boot.entity.CpcDetail;
import org.msy.boot.service.system.cpc.CpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 11612
 * @date 2023/2/28
 */
@Controller
@RequestMapping("/cpc")
public class CpcController {

    @Autowired
    private CpcService cpcService;

    @RequestMapping("/list.html")
    public String queryCpc(Model model){
        List<CpcDetail> cpcList = cpcService.queryCpcList();
        // 详情表中 数据查询出来
        model.addAttribute("cpcList",cpcList);
        return "cpc/cpcList";
    }



}
