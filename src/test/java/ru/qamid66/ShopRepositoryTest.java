package ru.qamid66;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 30_000);
        Product product2 = new Product(22,"Книга", 300);
        Product product3 = new Product(300, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(22);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testRemoveWhenProductExist2() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 30_000);
        Product product2 = new Product(22,"Книга", 300);
        Product product3 = new Product(300, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(300);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductId() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 30_000);
        Product product2 = new Product(22,"Книга", 300);
        Product product3 = new Product(300, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,() -> repo.remove(4444));
    }
    @Test
    public void testRemoveProductTitle() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 30_000);
        Product product2 = new Product(22,"Книга", 300);
        Product product3 = new Product(300, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,() -> repo.remove1("Машина"));
    }
    @Test
    public void testRemoveProductPrice() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 30_000);
        Product product2 = new Product(22,"Книга", 300);
        Product product3 = new Product(300, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,() -> repo.remove2(7_000_000));
    }
    @Test
    public void testRemoveProductTmp() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 30_000);
        Product product2 = new Product(22,"Книга", 300);
        Product product3 = new Product(300, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,() -> repo.remove2(7_000_000));
    }

}