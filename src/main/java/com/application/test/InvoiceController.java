package com.application.test;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/invoice-add")
    public String addInvoiceForm(Invoice invoice){
        return "invoice-add";
    }

    @PostMapping("/invoice-add")
    public String persistInvoice(@Valid Invoice invoice, BindingResult result, Model model){
        if(result.hasErrors()){
            return "invoice-add";
        }
        try{
            invoiceDB.addInvoice(invoice);
        } catch (InvoiceExistsException e){
            model.addAttribute("invoiceExists", "Faktura o podanym numerze dla danego dostawcy już istnieje.");
            return "invoice-add";
        }
        model.addAttribute("sessionObject", sessionObject);
        model.addAttribute("invoiceList", invoiceDB.getInvoiceList());
        return "invoices";
    }
}
