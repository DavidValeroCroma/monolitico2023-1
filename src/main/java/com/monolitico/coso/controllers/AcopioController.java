package com.monolitico.coso.controllers;

import com.monolitico.coso.entities.AcopioEntity;
import com.monolitico.coso.services.AcopioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/acopio")
public class AcopioController {
    @Autowired
    private AcopioService acopioService;

    @GetMapping("/fileUpload")
    public String main() {
        return "AcopioView";
    }

    @PostMapping("/fileUpload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        acopioService.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        acopioService.leerCsv("Acopio.csv");
        return "redirect:/acopio/fileUpload";
    }

    @GetMapping("/fileInformation")
    public String listar(Model model) {
        ArrayList<AcopioEntity> datas = acopioService.obtenerAcopios();
        model.addAttribute("datas", datas);
        return "fileInformation";
    }
}
