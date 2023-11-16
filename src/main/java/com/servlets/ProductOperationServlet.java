package com.servlets;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.ekart.FactoryProvider;
import com.entities.Category;
import com.entities.Product;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

public class ProductOperationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;");
        try
                (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("operation");
            if (op.trim().equals("addCategory")) {

                //fetching category data
                String title = request.getParameter("catTitle");
                String description = request.getParameter("catDescp");

                //Saving the data in one object
                Category category = new Category();
                category.setCTitle(title);
                category.setCdescription(description);

                //category to save in database:
                CategoryDao categoryDao = new CategoryDao(FactoryProvider.getFactory());
                int catId = categoryDao.saveCategory(category);
                //out.println("Category Saved!!!");
                HttpSession httpSession = request.getSession();

                httpSession.setAttribute("message", "Category saved!!");
                response.sendRedirect("admin.jsp");

            } else if (op.trim().equals("addProduct")) {
                //fetch product data
                String pName = request.getParameter("pName");
                String pDesc = request.getParameter("pDesc");
                int pPrice = Integer.parseInt(request.getParameter("pPrice"));
                int pDiscount = Integer.parseInt(request.getParameter("pDiscount"));
                int pQuantity = Integer.parseInt(request.getParameter("pQuantity"));
                int catId = Integer.parseInt(request.getParameter("catId"));
                Part part = request.getPart("pPhoto");
                // String imagename=part.getName();

                ProductDao pdao = new ProductDao(FactoryProvider.getFactory());


                //Saving data in one object

                Product p = new Product();
                p.setPname(pName);
                p.setPdesc(pDesc);
                p.setpPrice(pPrice);
                p.setpPrice(pPrice);
                p.setpDiscount(pDiscount);
                p.setpQuantity(pQuantity);
                p.setpPhoto(pdao.extractFileName(part));


                CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
                Category category = cdao.getCategoryById(catId);
                p.setCategory(category);

                //Saving Product

                pdao.saveProduct(p);
                //out.println("product saved successfully");

                // pic upload
                String path = request.getRealPath("img") + File.separator + "products" + File.separator + pdao.extractFileName(part);
                System.out.println(path);
                try {
                    FileOutputStream fos = new FileOutputStream(path);
                    InputStream is = part.getInputStream();

                    //reading data
                    byte[] data = new byte[is.available()];
                    is.read(data);

                    //Writing the data
                    fos.write(data);
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }


                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("message", "Product Saved!!");
                response.sendRedirect("admin.jsp");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}