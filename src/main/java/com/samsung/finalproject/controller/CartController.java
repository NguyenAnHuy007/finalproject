//package com.samsung.finalproject.controller;
//
//import org.springframework.ui.Model;
//import com.samsung.finalproject.models.entities.Cart;
//import com.samsung.finalproject.models.entities.Product;
//import com.samsung.finalproject.models.entities.User;
//import com.samsung.finalproject.services.CartService;
//import com.samsung.finalproject.services.ProductService;
//import com.samsung.finalproject.services.UserService;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/cart")
//public class CartController {
//    private final CartService cartService;
//    private final ProductService productService;
//    private final UserService userService;
//
//    public CartController(CartService cartService, ProductService productService, UserService userService) {
//        this.cartService = cartService;
//        this.productService = productService;
//        this.userService = userService;
//    }
//
//    @PostMapping("/add")
//    public String addToCart(@RequestParam Long productId, @RequestParam int quantity, HttpSession session) {
//        // Kiểm tra xem user đã đăng nhập chưa
//        User user = (User) session.getAttribute("loggedInUser");
////        if (user == null) {
////            return "redirect:/login"; // Chuyển đến trang đăng nhập nếu chưa đăng nhập
////        }
//
//        // Tìm sản phẩm và thêm vào giỏ
//        Product product = productService.findById(productId);
//        cartService.addItemToCart(user, product, quantity);
//
//        return "redirect:/products"; // Quay lại trang sản phẩm sau khi thêm
//    }
//
//    @GetMapping
//    public String viewCart(HttpSession session, Model model) {
//        // Kiểm tra xem user đã đăng nhập chưa
//        User user = (User) session.getAttribute("loggedInUser");
//        if (user == null) {
//            return "redirect:/login";
//        }
//        List<Cart> cartItems = cartService.getCartItems(user);
//        model.addAttribute("cartItems", cartItems);
//
//        return "cart";
//    }
//
//    @PostMapping("/remove")
//    public String removeFromCart(@RequestParam Long cartItemId, HttpSession session) {
//        // Xóa mục trong giỏ
//        cartService.removeItemFromCart(cartItemId);
//        return "redirect:/cart";
//    }
//
//}
