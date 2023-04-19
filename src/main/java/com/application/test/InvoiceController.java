package com.application.test;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceController {
    @Resource
    SessionObject sessionObject;

    InvoiceDB invoiceDB = new InvoiceDB();

    @GetMapping("/invoices")
    public String invoiceList(Model model){
        model.addAttribute("sessionObject", sessionObject);
        model.addAttribute("invoiceList", invoiceDB.getInvoiceList());
        return "invoices";
    }
}
