package net.yorksolutions.optumfsjavadukesofyork2.services;

import net.yorksolutions.optumfsjavadukesofyork2.models.Cart;

import net.yorksolutions.optumfsjavadukesofyork2.repositories.CartRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;


    public CartService(CartRepository repository) {
        this.cartRepository  = repository;
    }

    // logics to fns

    public Iterable<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getACart(Long userId) throws Exception {
        if (cartRepository.findById(userId).isEmpty())
            throw new Exception();
        final var userCart = cartRepository.findById(userId).orElseThrow();
        return userCart;
    }

    public Cart addNewCart(Cart cart) throws Exception {
        if (cartRepository.findById(cart.userId).isPresent())
            throw new Exception();

        return cartRepository.save(cart);
    }

    public Cart updateCart(Long userId, Cart cart) throws Exception {
        if (cartRepository.findById(userId).isEmpty())
            throw new Exception();
        final var updatedCart = cartRepository.findById(userId).orElseThrow();
        updatedCart.userId = cart.userId;
        updatedCart.products = cart.products;

        return cartRepository.save(updatedCart);
    }

    public void deleteCart(Long userId) throws Exception {
        Optional <Cart> cartToDelete = this.cartRepository.findById(userId);
        if (cartToDelete.isEmpty()) {
            throw new Exception();
        }

        cartRepository.deleteById(userId);
    }

}
