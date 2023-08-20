package ru.qamid66;

public class ShopRepository {
    private Product[] products = new Product[0];
    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    public void add(Product product) {
        products = addToArray(products, product);
    }

    public Product[] findAll() {
        return products;
    }

    public void remove(int id) {
        Product foundProduct = findById(id);
        if (foundProduct == null) {
            throw new NotFoundException(id);

        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
    public void remove1(String title) {
        Product foundProduct = findByTitle(title);
        if (foundProduct == null) {
            throw new NotFoundException(title);

        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getTitle() != title) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
    public void remove2(int price) {
        Product foundProduct = getPrice(price);
        if (foundProduct == null) {
            throw new NotFoundException(price);

        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getPrice() != price) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    private Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }
    private Product findByTitle(String title) {
        for (Product product : products) {
            if (product.getTitle() == title) {
                return product;
            }
        }

        return null;
    }
    private Product getPrice (int price) {
        for (Product product : products) {
            if (product.getPrice() == price) {
                return product;
            }
        }

        return null;
    }
}