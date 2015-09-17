package com.trapezegroup.mvc;

import com.trapezegroup.NovusRTConsumer;
import com.trapezegroup.NovusRTResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NovusRTController {

    @Autowired
    private NovusRTConsumer novusRTConsumer;

    @RequestMapping("/stopCode/{stopCode}")
    public String stopData(@PathVariable("stopCode") String stopCode, HttpServletRequest request, Model model) {
        NovusRTResult novusRTResult = novusRTConsumer.getNovusRTResult(stopCode);
        model.addAttribute("time", novusRTResult.getTime());
        model.addAttribute("atcoCode", novusRTResult.getAtcoCode());
        model.addAttribute("stopEvents", novusRTResult.getEvents());
        model.addAttribute("notices", novusRTResult.getNotices());
        return "stop_data";
    }
}
