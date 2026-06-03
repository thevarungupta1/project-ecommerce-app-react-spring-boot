package com.thevarungupta.grocery_app_api.config;

import com.thevarungupta.grocery_app_api.entity.AppUser;
import com.thevarungupta.grocery_app_api.entity.Category;
import com.thevarungupta.grocery_app_api.entity.Product;
import com.thevarungupta.grocery_app_api.entity.SubCategory;
import com.thevarungupta.grocery_app_api.repository.AppUserRepository;
import com.thevarungupta.grocery_app_api.repository.CategoryRepository;
import com.thevarungupta.grocery_app_api.repository.ProductRepository;
import com.thevarungupta.grocery_app_api.repository.SubCategoryRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(
            CategoryRepository categoryRepository,
            SubCategoryRepository subCategoryRepository,
            ProductRepository productRepository,
            AppUserRepository appUserRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            if (categoryRepository.count() > 0) {
                return;
            }

            Category fruits = categoryRepository.save(Category.builder()
                    .catName("Fruits & Vegetables")
                    .catImage("https://images.unsplash.com/photo-1610832958506-aa56368176cf?auto=format&fit=crop&w=800&q=80")
                    .build());

            Category dairy = categoryRepository.save(Category.builder()
                    .catName("Dairy & Bakery")
                    .catImage("https://images.unsplash.com/photo-1488477181946-6428a0291777?auto=format&fit=crop&w=800&q=80")
                    .build());

            Category beverages = categoryRepository.save(Category.builder()
                    .catName("Beverages")
                    .catImage("https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=800&q=80")
                    .build());

            Category snacks = categoryRepository.save(Category.builder()
                    .catName("Snacks & Packaged Foods")
                    .catImage("https://images.unsplash.com/photo-1599490659213-e2b9527bd087?auto=format&fit=crop&w=800&q=80")
                    .build());

            subCategoryRepository.saveAll(List.of(
                    SubCategory.builder().subName("Fresh Fruits").category(fruits).build(),
                    SubCategory.builder().subName("Fresh Vegetables").category(fruits).build(),
                    SubCategory.builder().subName("Milk").category(dairy).build(),
                    SubCategory.builder().subName("Bread").category(dairy).build(),
                    SubCategory.builder().subName("Yogurt & Curd").category(dairy).build(),
                    SubCategory.builder().subName("Soft Drinks").category(beverages).build(),
                    SubCategory.builder().subName("Juices").category(beverages).build(),
                    SubCategory.builder().subName("Tea & Coffee").category(beverages).build(),
                    SubCategory.builder().subName("Chips & Namkeen").category(snacks).build(),
                    SubCategory.builder().subName("Biscuits & Cookies").category(snacks).build(),
                    SubCategory.builder().subName("Instant Foods").category(snacks).build()
            ));

            productRepository.saveAll(List.of(
                    Product.builder()
                            .productName("Apple")
                            .image("https://images.unsplash.com/photo-1567306226416-28f0efdc88ce?auto=format&fit=crop&w=800&q=80")
                            .description("Fresh and crispy apples")
                            .unit("1 kg")
                            .mrp(new BigDecimal("220"))
                            .price(new BigDecimal("180"))
                            .category(fruits)
                            .build(),
                    Product.builder()
                            .productName("Banana")
                            .image("https://images.unsplash.com/photo-1571771894821-ce9b6c11b08e?auto=format&fit=crop&w=800&q=80")
                            .description("Farm fresh bananas")
                            .unit("1 dozen")
                            .mrp(new BigDecimal("80"))
                            .price(new BigDecimal("60"))
                            .category(fruits)
                            .build(),
                    Product.builder()
                            .productName("Tomato")
                            .image("https://images.unsplash.com/photo-1546094096-0df4bcaaa337?auto=format&fit=crop&w=800&q=80")
                            .description("Red ripe tomatoes for daily cooking")
                            .unit("1 kg")
                            .mrp(new BigDecimal("70"))
                            .price(new BigDecimal("52"))
                            .category(fruits)
                            .build(),
                    Product.builder()
                            .productName("Potato")
                            .image("https://images.unsplash.com/photo-1518977676601-b53f82aba655?auto=format&fit=crop&w=800&q=80")
                            .description("Premium potatoes")
                            .unit("1 kg")
                            .mrp(new BigDecimal("45"))
                            .price(new BigDecimal("34"))
                            .category(fruits)
                            .build(),
                    Product.builder()
                            .productName("Milk")
                            .image("https://images.unsplash.com/photo-1550583724-b2692b85b150?auto=format&fit=crop&w=800&q=80")
                            .description("Pasteurized full cream milk")
                            .unit("1 litre")
                            .mrp(new BigDecimal("65"))
                            .price(new BigDecimal("58"))
                            .category(dairy)
                            .build(),
                    Product.builder()
                            .productName("Brown Bread")
                            .image("https://images.unsplash.com/photo-1509440159596-0249088772ff?auto=format&fit=crop&w=800&q=80")
                            .description("Healthy whole wheat brown bread")
                            .unit("400 g")
                            .mrp(new BigDecimal("55"))
                            .price(new BigDecimal("45"))
                            .category(dairy)
                            .build(),
                    Product.builder()
                            .productName("Greek Yogurt")
                            .image("https://images.unsplash.com/photo-1571212515416-fca88c7899d5?auto=format&fit=crop&w=800&q=80")
                            .description("Protein-rich greek yogurt")
                            .unit("400 g")
                            .mrp(new BigDecimal("120"))
                            .price(new BigDecimal("99"))
                            .category(dairy)
                            .build(),
                    Product.builder()
                            .productName("Orange Juice")
                            .image("https://images.unsplash.com/photo-1613478223719-2ab802602423?auto=format&fit=crop&w=800&q=80")
                            .description("100% fruit orange juice")
                            .unit("1 litre")
                            .mrp(new BigDecimal("140"))
                            .price(new BigDecimal("118"))
                            .category(beverages)
                            .build(),
                    Product.builder()
                            .productName("Cola Drink")
                            .image("https://images.unsplash.com/photo-1629203851122-3726ecdf080e?auto=format&fit=crop&w=800&q=80")
                            .description("Chilled fizzy soft drink")
                            .unit("750 ml")
                            .mrp(new BigDecimal("50"))
                            .price(new BigDecimal("42"))
                            .category(beverages)
                            .build(),
                    Product.builder()
                            .productName("Instant Coffee")
                            .image("https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?auto=format&fit=crop&w=800&q=80")
                            .description("Rich aroma instant coffee")
                            .unit("100 g")
                            .mrp(new BigDecimal("320"))
                            .price(new BigDecimal("279"))
                            .category(beverages)
                            .build(),
                    Product.builder()
                            .productName("Masala Chips")
                            .image("https://images.unsplash.com/photo-1566478989037-eec170784d0b?auto=format&fit=crop&w=800&q=80")
                            .description("Crispy spicy potato chips")
                            .unit("150 g")
                            .mrp(new BigDecimal("40"))
                            .price(new BigDecimal("32"))
                            .category(snacks)
                            .build(),
                    Product.builder()
                            .productName("Chocolate Cookies")
                            .image("https://images.unsplash.com/photo-1499636136210-6f4ee915583e?auto=format&fit=crop&w=800&q=80")
                            .description("Crunchy cookies with chocolate chips")
                            .unit("200 g")
                            .mrp(new BigDecimal("85"))
                            .price(new BigDecimal("72"))
                            .category(snacks)
                            .build(),
                    Product.builder()
                            .productName("Instant Noodles")
                            .image("https://images.unsplash.com/photo-1612927601601-6638404737ce?auto=format&fit=crop&w=800&q=80")
                            .description("Quick cook masala noodles")
                            .unit("4 pack")
                            .mrp(new BigDecimal("72"))
                            .price(new BigDecimal("62"))
                            .category(snacks)
                            .build()
            ));

            if (appUserRepository.count() == 0) {
                appUserRepository.saveAll(List.of(
                        AppUser.builder()
                                .firstName("Demo User One")
                                .email("demo1@groceryapp.local")
                                .mobile("9000000001")
                                .password(passwordEncoder.encode("Password@123"))
                                .build(),
                        AppUser.builder()
                                .firstName("Demo User Two")
                                .email("demo2@groceryapp.local")
                                .mobile("9000000002")
                                .password(passwordEncoder.encode("Password@123"))
                                .build(),
                        AppUser.builder()
                                .firstName("Demo User Three")
                                .email("demo3@groceryapp.local")
                                .mobile("9000000003")
                                .password(passwordEncoder.encode("Password@123"))
                                .build()
                ));
            }
        };
    }
}
