package com.samsung.finalproject.services;

import com.samsung.finalproject.models.entities.Cart;
import com.samsung.finalproject.models.entities.Product;
import com.samsung.finalproject.models.entities.User;
import com.samsung.finalproject.models.repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addItemToCart(User user, Product product, int quantity) {
        // Kiểm tra nếu sản phẩm đã có trong giỏ hàng
        Cart existingCartItem = cartRepository.findByUser(user).stream()
                .filter(cart -> cart.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElse(null);

        if (existingCartItem != null) {
            // Nếu sản phẩm đã tồn tại, chỉ cần tăng số lượng
            existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
            cartRepository.save(existingCartItem);
        } else {
            // Nếu là sản phẩm mới, tạo mới mục giỏ hàng
            Cart cartItem = new Cart();
            cartItem.setUser(user);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartRepository.save(cartItem);
        }
    }

    public List<Cart> getCartItems(User user) {
        return cartRepository.findByUser(user);
    }

    public void removeItemFromCart(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }

}
