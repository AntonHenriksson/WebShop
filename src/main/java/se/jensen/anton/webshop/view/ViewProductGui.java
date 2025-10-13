package se.jensen.anton.webshop.view;

import se.jensen.anton.webshop.model.Product;

import javax.swing.*;
import java.util.List;

public class ViewProductGui implements ViewProduct {
    @Override
    public void showProducts(List<Product> products) {
        if (products == null || products.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There are no products to show.");
            return;
        }

        DefaultListModel<Product> modelingmodeling = new DefaultListModel<>();

        for (Product product : products) {
            modelingmodeling.addElement(product);
        }

        JList<Product> list = new JList<>(modelingmodeling);
        list.setVisibleRowCount(Math.min(products.size(), 10));
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new java.awt.Dimension(860, 640));

        JOptionPane.showMessageDialog(null, scrollPane, "Product List", JOptionPane.INFORMATION_MESSAGE);

    }

    @Override
    public void showProduct(Product product) {
        JOptionPane.showMessageDialog(null, product, "Product Details", JOptionPane.INFORMATION_MESSAGE);

    }

    @Override
    public void showPrompt(String prompt) {


    }
}
