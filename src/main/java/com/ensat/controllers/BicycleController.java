package com.ensat.controllers;

import com.ensat.entities.Bicycle;
import com.ensat.services.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 */
@Controller
public class BicycleController {

    private BicycleService bicycleService;

    @Autowired
    public void setBicycleService(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    /**
     * List all bicycle.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("bicycles", bicycleService.listAllBicycle());
        System.out.println("Returning bicycle:");
        return "bicycles";
    }

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("bicycle/{id}")
    public String showBicycle(@PathVariable Integer id, Model model) {
        model.addAttribute("bicycle", bicycleService.getBicycleById(id));
        return "bicycleshow";
    }

    @RequestMapping("bicycle/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("bicycle", bicycleService.getBicycleById(id));
        return "bicycleform";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("bicycle/new")
    public String newBicycle(Model model) {
        model.addAttribute("bicycle", new Bicycle());
        return "bicycleform";
    }

    /**
     *
     * @param bicycle
     * @return
     */
    @RequestMapping(value = "bicycle", method = RequestMethod.POST)
    public String saveBicycle(Bicycle bicycle) {
        bicycleService.saveBicycle(bicycle);
        return "redirect:/bicycle/" + bicycle.getId();
    }

    /**
     *
     * @param id
     * @return
     */


    // @RequestMapping("bicycle/delete/{id}")
    @RequestMapping(value = "bicycle/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id) {
        bicycleService.deleteBicycle(id);
        return "redirect:/";
    }

}
