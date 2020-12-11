package com.udemy.controller;

import com.udemy.constant.ViewConstant;
import com.udemy.model.ContactoModel;
import com.udemy.service.ContactoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contacts")
public class ContactoController {

    private static final Log LOG = LogFactory.getLog(ContactoController.class);

    @Autowired
    @Qualifier("contactoService")

    private ContactoService contactoService;

    @GetMapping("/cancel")
    public String cancel(Model model) {
        return "redirect:/contacts/showcontacts";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/contactform")
    public String contactForm(@RequestParam(name = "id", required = false) int id, Model model) {
        LOG.info("METHOD: contactForm()");
        ContactoModel contactoModel = new ContactoModel();
        if (id != 0){
            contactoModel = contactoService.findContactByIdModel(id);
        }
        model.addAttribute("contactoModel", contactoModel);
        return ViewConstant.CONTACT_FORM;
    }

    @GetMapping("/showcontacts")
    public ModelAndView showContacts() {
        LOG.info("METHOD: showContacts()");
        ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username",user.getUsername());
        mav.addObject("contactos", contactoService.ListaContacto());
        return mav;
    }

    @GetMapping("/removecontact")
    public ModelAndView removeContacts(@RequestParam(name = "id", required = true) int id) {
        LOG.info("METHOD: removeContacts()");
        contactoService.removeContact(id);
        return showContacts();
    }

    @PostMapping("/addcontact")
    public String addContacts(@ModelAttribute("contacto") ContactoModel contactoModel, Model model) {
        LOG.info("METHOD: addContacts()");
        if (contactoService.addContact(contactoModel) != null) {
            model.addAttribute("resultado", 1);
        } else
            model.addAttribute("resultado", 0);

        return "redirect:/contacts/showcontacts";
    }
}
