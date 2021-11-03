/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

//    public List<Product> getAllProduct() {
//        List<Product> list = new ArrayList<>();
//        String query = "select * from Product";
//        try {
//            conn = new DBContext().getConnection();//mo ket noi voi sql
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getString(6)));
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }
    
  public List<Product> getViewProduct() {
  List<Product> list = new ArrayList<>();
  String query = "select * from ThongTinSanPham";
  try {
      conn = new DBContext().getConnection();//mo ket noi voi sql
      ps = conn.prepareStatement(query);
      rs = ps.executeQuery();
      while (rs.next()) {
          list.add(new Product(rs.getString(1),
                  rs.getString(2),
                  rs.getDouble(3),
                  rs.getString(4)
                  ));
      }
  } catch (Exception e) {
  }
  return list;
}
    
    
    
    
    
    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\n" +"Where cateID =?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    public List<Account> getAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account" ;
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5))
                       );
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Product getProduct(String txt) {
        String query = "select * from product where id = ?";
        List<Product> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, txt);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                1);
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Product getProductByID(String pid) {
      
        String query = "select * from Product\n" +"Where id =?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
              return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
       return null;
    }
    
    public Account getAccountByID(String uid) {
        
        String query = "select * from Account\n" +"Where uid =?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
              return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)
                        );
            }
        } catch (Exception e) {
        }
       return null;
    }
    
   
    

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
//            CallableStatement command = conn.prepareCall("{call sp_getAllCategory }");
//	         ResultSet rs = command.executeQuery();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getLast() {
        String query = "select top 1 * from Product\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
//             CallableStatement command = conn.prepareCall("{call sp_getLastProduct }");
//	         ResultSet rs = command.executeQuery();
            
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    
    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
       String query = "select * from Product\n" +"Where [name] like ?";
//        String query = " SELECT * from dbo.fn_SearchProductName(?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+ txtSearch+"%");
//            ps.setString(1, txtSearch);
            rs = ps.executeQuery();
                 

            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Account login(String user,String pass) {
    	 String query = "select * from Account\n" +"Where [user] = ?\n"+"and pass = ?";
    	 try {
             conn = new DBContext().getConnection();//mo ket noi voi sql
             ps = conn.prepareStatement(query);
             ps.setString(1,user);
             ps.setString(2,pass);
             rs = ps.executeQuery();
             while (rs.next()) {
                 return new Account(rs.getInt(1),
                         rs.getString(2),
                         rs.getString(3),
                         rs.getInt(4),
                         rs.getInt(5));
                     
             }
         } 
    	 catch (Exception e) {
         }
    	 return null;
        
    }
    public Account checkAccountExist(String user) {
    	String query = "select * from Account\n" +"Where [user] = ?";
    	try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,user);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
                    
            }
        } 
   	 catch (Exception e) {
        }
   	 return null;
    	
    }
    
    public List<Product> getTop3() {
        List<Product> list = new ArrayList<>();
        String query = "select top 3 * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    
    public List<Product> getNext3Product(int amount) {
        List<Product> list = new ArrayList<>();
        String query = "select top 3 * from product\n"
        		+ "ORDER BY id\n"
        		+ "OFFSET ? ROWS\n"
        		+ "FETCH NEXT 3 ROWS ONLY";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public int getTotalProduct () {
    	String query ="select count(*) from product";
    	try {
    		conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
            	return rs.getInt(1);
            }
    	}
    	catch (Exception e) {
    }
    	return 0;
   }
    
    public int getTotalAccount () {
    	String query ="select count(*) from account";
    	try {
    		conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
            	return rs.getInt(1);
            }
    	}
    	catch (Exception e) {
    }
    	return 0;
   }
    
   
    
   
    
    
    public List<Product> pagingProduct(int index) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
        		+"ORDER BY id\n"
        		+"OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
//            CallableStatement command = conn.prepareCall("{call sp_PagingProduct (?) }");
//            command.setInt(1, (index-1)*6);
//            ResultSet rs = command.executeQuery();
            ps = conn.prepareStatement(query);
            ps.setInt(1,(index-1)*6);
            rs = ps.executeQuery();
            while (rs.next()) {
            	
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
   
    
    public List<Account> pagingAccount(int index) {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account\n"
        		+"ORDER BY uid\n"
        		+"OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1,(index-1)*6);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)
                       ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
  
    
//    public List<Product> getNext6Product(int amount) {
//        List<Product> list = new ArrayList<>();
//        String query = "SELECT *\n"
//                + "  FROM product\n"
//                + " ORDER BY id\n"
//                + "OFFSET ? ROWS\n"
//                + " FETCH NEXT 6 ROWS ONLY";
//        try {
//            conn = new DBContext().getConnection();//mo ket noi voi sql
//            ps = conn.prepareStatement(query);
//            ps.setInt(1, amount);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new Product(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getDouble(4),
//                        rs.getString(5),
//                        rs.getString(6)));
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }
    
    public List<Product> getProductBySaleID(int id) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\n" +"Where sale_ID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
 public void deleteProduct(String pid) {
    	String query = "delete from product\n" +"where id = ?";
    	 try {
             conn = new DBContext().getConnection();//mo ket noi voi sql
             ps = conn.prepareStatement(query);
             ps.setString(1, pid);
             ps.executeUpdate();
            
             }
          catch (Exception e) {
         }
 }
 
 public void deleteAccount(String uid) {
 	String query = "delete from Account\n" +"where uid = ?";
 	 try {
          conn = new DBContext().getConnection();//mo ket noi voi sql
          ps = conn.prepareStatement(query);
          ps.setString(1, uid);
          ps.executeUpdate();
         
          }
       catch (Exception e) {
      }
}
    
    
    public void signup(String user, String pass) {
    	String query = "insert into Account\n"
    			
         + "values(?,?,0,0)";
    	
    	try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            ps.executeUpdate();

                   
        } 
   	 catch (Exception e) {
        }
   	 
    }
    
    public void insertProduct(String name, String image, String price,
            String title, String description, String category, int sid) {
//        String query = "INSERT [dbo].[Product] \n"
//                + "([name], [image], [price], [title], [description], [cateID], [sale_ID])\n"
//                + "VALUES(?,?,?,?,?,?,?)";
        try {
        
            conn = new DBContext().getConnection();//mo ket noi voi sql
//            ps = conn.prepareStatement(query);
        	CallableStatement command = conn.prepareCall("{call sp_InssertProduct(?,?,?,?,?,?,?) }");
  	        ResultSet rs = command.executeQuery();
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, sid);
            ps.executeUpdate();
            
              
        } catch (Exception e) {
        }
    }
    
    
    
    public void insertMyAccount( String name, String age,String email, String phone, String address,String user_name)
    			{
        String query = "INSERT [dbo].[Member] \n"
                + "([name], [age], [email], [phone], [address],[user_name])\n"
                + "VALUES(?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, age);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setString(6, user_name);
           
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void insertDetailOrder(String pid, String quantity)
            {
        String query = "INSERT [dbo].[DetailOrder] \n"
                + "([pid], [quantity])\n"
                + "VALUES(?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.setString(2, quantity);
           
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void insertContact(String name, String email, String message
           ) {
        String query = "INSERT [dbo].[Contact] \n"
                + "([name], [email], [message])\n"
                + "VALUES(?,?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, message);
           
           
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
   
    
   
    
    public void insertAccount(String user, String pass, String isSell,
           String isAdmin) {
        String query = "INSERT [dbo].[Account] \n"
                + "([user], [pass], [isSell], [isAdmin])\n"
                + "VALUES(?,?,?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, isSell);
            ps.setString(4, isAdmin);
          
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    

    public void editProduct(String name, String image, String price,
            String title, String description, String category, String pid) {
        String query = "update product\n"
                + "set [name] = ?,\n"
        		+"[image] = ?,\n"
                +"price = ?,\n"
        		+"title = ?,\n"
                +"description = ?,\n"
        		+"cateID = ?\n"
                +"where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void editPassWord(String pass , int uid) {
        String query = "update Account\n"
                + "set [pass] = ?\n"
        +"where uid = ?";
        		
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pass);
            ps.setInt(2, uid);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
//    public MyAccount getAccountByUser(String user_name) {
//        
//        String query = "select * from Member\n" +"Where user_name =?";
//        try {
//            conn = new DBContext().getConnection();//mo ket noi voi sql
//            ps = conn.prepareStatement(query);
//            ps.setString(1, user_name);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//              return new MyAccount(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getInt(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7));
//            }
//        } catch (Exception e) {
//        }
//       return null;
//    }
    
    
    public void editAccount( String user, String pass,
            String isSell, String isAdmin,String uid) {
        String query = "update Account\n"
                + "set [user] = ?,\n"
        		+"[pass] = ?,\n"
                +"isSell = ?,\n"
        		+"isAdmin = ?\n"
        		+"where uid = ?";
                
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, isSell);
            ps.setString(4, isAdmin);
            ps.setString(5, uid);
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
  
   	 
    
    
    
    
    
    

   public static void main(String[] args) {
          DAO dao = new DAO();
          
          List<Product> list = dao.getViewProduct();
//        List<Product> list1 = dao.getProductByCID("3");
//        List<Category> listC = dao.getAllCategory();
//        Product p = dao.getProductByID("1");
//        Account a = dao.login("sang", "sangit123");
//        List<Product> list2 = dao.searchByName("Converse");
	      
	      
//        
//        
     

   for (Product o : list) {
         System.out.println(o);
  
   

}
   
   }
}



