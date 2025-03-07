package com.samsung.finalproject.controller;

import com.samsung.finalproject.models.entities.Product;
import com.samsung.finalproject.services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/products", "/"})
    public String showProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("search")
    public String search(@RequestParam(required = false, defaultValue = "") String keyword, Model model) {
        List<Product> products;
        if (keyword.isEmpty()) {
            products = productService.getAllProducts(); // Trả về tất cả sản phẩm nếu không có keyword
        } else {
            products = productService.searchProduct(keyword); // Tìm kiếm sản phẩm theo tên
        }
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword); // Dùng để hiển thị lại giá trị tìm kiếm trong ô input
        return "products";
    }

    @GetMapping("/getsession")
    public ResponseEntity getSession(HttpSession session) {
        List<Product> lstPerson = (List<Product>) session.getAttribute("personList");
        return ResponseEntity.ok(lstPerson);
    }

}
