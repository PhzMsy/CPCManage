package org.msy.boot.controller.system.cpc;

import org.msy.boot.entity.*;
import org.msy.boot.service.system.company.CompanyService;
import org.msy.boot.service.system.cpc.CpcService;
import org.msy.boot.service.system.cpcdetail.CpcDetailService;
import org.msy.boot.service.system.edu.EduService;
import org.msy.boot.service.system.family.FamilyService;
import org.msy.boot.service.system.iof.IofService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private CpcService cpcService;
    @Autowired
    private EduService eduService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private IofService iofService;
    @Autowired
    private FamilyService familyService;

    /**
     * 根据id查询 做回显使用
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/queryById")
    public String queryById(@RequestParam("cpcId") Integer id, Model model) {
        System.out.println(id);
        CpcDetail list = cpcDetailService.queryById(id);
        System.out.println(list);
        model.addAttribute("query", list);
        return "/cpc/cpcDetail";
    }

    /**
     * 修改页面根据id查询做回显
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/updateById")
    public String updateById(@RequestParam("cpcId") Integer id, Model model) {
        System.out.println(id);
        CpcDetail list = cpcDetailService.queryById(id);
        System.out.println(list);
        model.addAttribute("query", list);
        return "/cpc/cpcUpdate";
    }

    /**
     * 修改提交来的数据
     * @param detail
     * @return
     */
    @PostMapping("/updateDetail")
    private String updateDetail(CpcDetail detail) {
        System.out.println(detail);
        Cpc cpc = detail.getCpc();
        Company cpcComid = detail.getCpcComid();
        Party cpcParid = detail.getCpcParid();
        Edu edu = detail.getEdu();
        Iof iof = detail.getIof();
        List<Family> familyList = detail.getFamilyList();
        cpcDetailService.updateAllData(detail);
        cpcService.updateAll(cpc);
        companyService.updateAllComp(cpcComid);
        Integer cpcId = detail.getCpcId();
        cpcDetailService.updateAllParty(cpcParid, cpcId); //更改detail表中的party字段
        eduService.updateAllEdu(edu);
        iofService.updateAllIof(iof);
        for (Family family : familyList) {
            familyService.updateAllFam(family);
        }
        return "redirect:/cpc/list.html";
    }

    /**
     * 流入流出管理 中的修改详情
     * @param detail
     * @return
     */
    @PostMapping("/iofUpdateDetail")
    private String iofUpdateDetail(CpcDetail detail) {
        System.out.println("流入流出数据:"+detail);
        Cpc cpc = detail.getCpc();
        Party cpcParid = detail.getCpcParid();
        Iof iof = detail.getIof();
        cpcDetailService.updateAllData(detail);
        cpcService.updateAll(cpc);
        Integer cpcId = detail.getCpcId();
        cpcDetailService.updateAllParty(cpcParid, cpcId); //更改detail表中的party字段
        iofService.updateAllIof(iof);
        return "redirect:/cpc/ioflist.html";
    }

    /**
     * 流入流出页面跳转
     * @return
     */
    @GetMapping("/cpcIofManage.html")
    private String goIof() {
        return "cpc/cpcIofManage";
    }
    @GetMapping("/insert.html")
    private String goInsert() {
        return "cpc/cpcInsert";
    }
    @PostMapping("/insert")
    private String insert(CpcDetail detail) {
        int i = cpcDetailService.insertAll(detail);
        return "redirect:/cpc/list.html";
    }
    @GetMapping("/iofUpdateById")
    public String iofUpdateById(@RequestParam("cpcId") Integer id, Model model) {
        CpcDetail list = cpcDetailService.queryById(id);
        model.addAttribute("query", list);
        return "/iof/iofDetil";
    }
}
