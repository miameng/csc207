package background;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import client.Item;
import merchandise.Category;
import merchandise.Product;
import user.Administrator;
import user.Shopper;
import user.User;

class FileIO {
    
    private static List<String> parseCSV(String line) {
        List<String> result = new LinkedList<String>();
        StringBuilder current = null;
        boolean quoted = false;
        
        for (int i = 0; i < line.length(); ++i) {
            char c = line.charAt(i);
            if (c == '\"')
                if (quoted)
                    if (i == line.length() - 1)
                        quoted = false;
                    else if (line.charAt(i + 1) != '\"')
                        quoted = false;
                    else {
                        if (current == null)
                            current = new StringBuilder();
                        current.append('\"');
                        ++i;
                    }
                else
                    quoted = true;
            else if (c == ',' && !quoted)
                if (current != null) {
                    result.add(current.toString());
                    current = null;
                } else;
            else {
                if (current == null)
                    current = new StringBuilder();
                current.append(c);
            }
        }
        if (current != null)
            result.add(current.toString());
        
        return result;
    }
    
    static void scanProducts(List<Item> products, List<Item> categories) {
        try {
            Scanner s = new Scanner(new File("products.txt"));
            
            Map<String, String> forCate = new HashMap<String, String>();
            List<List<String>> forProd = new LinkedList<List<String>>();

            for (int index = 1; s.hasNextLine(); ) {
                List<String> l = parseCSV(s.nextLine());
                int id = Integer.parseInt(l.get(0));
                if (id == index) {
                    forProd.add(l);
                    index++;
                } else
                    forProd.set(id, l);
                
                for (int i = 5; i < l.size(); ++i) {
                    String tag = l.get(i);
                    int j = tag.indexOf(" ");
                    forCate.put(tag.substring(0, j), tag.substring(j));
                }
            }
            
            for (int i = 1; forCate.containsKey(String.format("%d", i)); ++i)
                categories.add(new Category(forCate.get(String.format("%d", i))));
            
            for (List<String> l: forProd) {
                Product product = new Product(
                        l.get(1), l.get(2),
                        Double.parseDouble(l.get(3)),
                        Integer.parseInt(l.get(4)));
                products.add(product);
                for (int i = 5; i < l.size(); ++i) {
                    String tag = l.get(i);
                    product.addCategory((Category) categories.get(
                            Integer.parseInt(tag.substring(0, tag.indexOf(" ")))));
                }
            }
            
            s.close();
        } catch (FileNotFoundException e) {
            
        }
    }
    
    static void scanUsers(List<User> users, List<Item> products) {
        try {
            Scanner s = new Scanner(new File("users.txt"));
            Map<String, String> forPass = new HashMap<String, String>();
            Map<String, String> forCart = new HashMap<String, String>();
            Map<String, List<String>> forPurc = new HashMap<String, List<String>>();
            
            for (; s.hasNextLine(); ) {
                List<String> l = parseCSV(s.nextLine());
                forPass.put(l.get(1), l.get(2));
                if (l.get(0).equals("Shopper")) {
                    forCart.put(l.get(1), l.get(3));
                    forPurc.put(l.get(1), l.subList(4, l.size()));
                }
            }
            for (Map.Entry<String, String> e: forPass.entrySet()) {
                String id = e.getKey();
                if (!forPass.containsKey(id))
                    users.add(new Administrator(id, e.getValue()));
                else {
                    List<Item> cart = new LinkedList<Item>();
                    List<List<Item>> purchases = new LinkedList<List<Item>>();
                    for (String i: parseCSV(forCart.get(id)))
                        cart.add(products.get(Integer.parseInt(i)));
                    for (String j: forPurc.get(id)) {
                        List<Item> invoice = new LinkedList<Item>();
                        for (String i: parseCSV(j))
                            invoice.add(products.get(Integer.parseInt(i)));
                        purchases.add(invoice);
                    }
                    users.add(new Shopper(id, e.getValue(), cart, purchases));
                }
            }

            s.close();
        } catch (FileNotFoundException e) {
            
        }
    }
    
    static private void printProduct(Product product, BufferedWriter p) throws IOException {
        p.newLine();
        p.write(product.ID + "," + product.getDescription() + "," + 
                product.getPrice() + "," + product.getQuantity());
        for (Item i: product.getCategories())
            p.write("," + ((Category) i).CODE + " " + ((Category) i).description());
    }
    
    static void printProduct(Product product) throws IOException {
        printProduct(product, new BufferedWriter(new FileWriter(new File("products.txt"), true)));
    }
    
    static private void printUser(User user, BufferedWriter p) throws IOException {
        p.newLine();
        p.write((user instanceof Administrator ? "Administrator" : "Shopper")
            + "," + user.ID + "," + user.getPassword());
        if (user instanceof Shopper)
            for (List<Item> invoice: ((Shopper) user).showPurchases()) {
                p.write(",\"");
                for (Item i: invoice)
                    p.write(((Product) i).ID + ",");
                p.write("\"");
            }
    }

    static void printUser(User user) throws IOException {
        printUser(user, new BufferedWriter(new FileWriter(new File("users.txt"), true)));
    }
    
    static void reprint(List<Item> products, List<User> users) throws IOException {
        BufferedWriter p = new BufferedWriter(new FileWriter(new File("products.txt")));
        
        for (Item i: products) {
            printProduct((Product) i, p);
            p.newLine();
        }
        
        p.close();
        p = new BufferedWriter(new FileWriter(new File("users.txt")));
        
        for (User u: users) {
            printUser((User) u, p);
            p.newLine();
        }
        
        p.close();
    }
}
