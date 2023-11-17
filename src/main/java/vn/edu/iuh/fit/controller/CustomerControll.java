package vn.edu.iuh.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.dao.CustomerDao;
import vn.edu.iuh.fit.dao.OrderDao;
import vn.edu.iuh.fit.entity.OrderDetail;
import vn.edu.iuh.fit.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerControll {
    private final CustomerDao customerDao;
    @Autowired
    public CustomerControll(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        long cusID=Long.parseLong(username);
        // Thực hiện kiểm tra đăng nhập ở đây, ví dụ:
        if (customerDao.logIn(cusID, password)) {
            model.addAttribute("cusID", cusID);
            return "redirect:/" + cusID;
        } else {
            // Đăng nhập thất bại, gửi thông báo lỗi
            model.addAttribute("error", "Thông tin đăng nhập không đúng");
            return "login";
        }
    }

}
