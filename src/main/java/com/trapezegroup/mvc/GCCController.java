package com.trapezegroup.mvc;

import com.trapezegroup.GCCConsumer;
import com.trapezegroup.GCCResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GCCController {

    @Autowired
    private GCCConsumer gccConsumer;

    @RequestMapping("/stopCode/{stopCode}")
    public String stopData(@PathVariable("stopCode") String stopCode, HttpServletRequest request, Model model) {
        GCCResult gccResult = gccConsumer.getGCCResult(stopCode);
        model.addAttribute("time", gccResult.getTime());
        model.addAttribute("naptan", gccResult.getNaptan());
        model.addAttribute("stopEvents", gccResult.getEvents());
        return "stop_data";
    }
}
