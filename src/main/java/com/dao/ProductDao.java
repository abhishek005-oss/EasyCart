package com.dao;

import com.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProductDao {
    private SessionFactory factory;

    public ProductDao(SessionFactory factory) {

        this.factory=factory;
    }
    public boolean saveProduct(Product product)
    { boolean f=false;
        try{
            Session session=this. factory.openSession();
            Transaction tx= session.beginTransaction();
            session.save(product);
            tx.commit();
            session.close();
            f=true;
        }
        catch (Exception e) {
            e.printStackTrace();

            f = false;
        }
        return f;
    }
    public List<Product> getAllProducts()
    {
        Session s= this. factory.openSession();
        Query query=s.createQuery("from Product");
        List list=query.list();
        return list;
    }
    public String extractFileName(Part part) {
        // Get the content disposition from the Part
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");

        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                // Extract the file name from the 'filename' parameter
                return item.substring(item.indexOf('=') + 2, item.length() - 1);
            }
        }

        // If the file name is not found in the content disposition
        return "default_filename"; // You might set a default file name here
    }

 public List<Product> getAllProductsById(int cid)
 {
    Session s= this. factory.openSession();
    Query query=s.createQuery("from Product as p where p.category.categoryid=: id");
    query.setParameter("id", cid);
    List list=query.list();
    return list;
 }

}
