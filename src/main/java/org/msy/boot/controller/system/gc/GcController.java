package org.msy.boot.controller.system.gc;

import org.msy.boot.entity.Gc;
import org.msy.boot.service.system.gc.GcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author 11612
 * @date 2023/3/6
 * url: /gc
 */
@Controller
@RequestMapping("/gc")
public class GcController {
    @Autowired
    private GcService gcServiceImpl;

    @RequestMapping("/list.html")
    public String list(Model model) {
        List<Map<String, Object>> gcList = gcServiceImpl.getGc();
        model.addAttribute("gcList", gcList);
        return "system/gc/gcList";
    }

    @RequestMapping("/recover")
    public String recover(@RequestParam("uid") Integer uid, @RequestParam("ft") String ft, @RequestParam("pk") String pk) {
// 封装参数： Gc: uid, from_table
        Gc gc = new Gc();
        gc.setUid(uid);
        gc.setFrom_table(ft);
        gc.setPrimary_key(pk);
        gcServiceImpl.recoverData(gc);
        return "redirect:/gc/list.html";
    }

    @RequestMapping("deleteData")
    public String deleteData(@RequestParam("uid") Integer uid,
                             @RequestParam("ft") String ft,
                             @RequestParam("pk") String pk) {
// 封装参数： Gc: uid, from_table
        Gc gc = new Gc();
        gc.setUid(uid);
        gc.setFrom_table(ft);
        gc.setPrimary_key(pk);
        gcServiceImpl.finalDelete(gc);
        return "redirect:/gc/list.html";
    }

}
