/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoPgSQL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Main {
        private static Connection cnn = null;
        private static PreparedStatement pr = null;
        private static ResultSet rs = null;
        public static Scanner sc = new Scanner(System.in);
        public static List<QLKhach> listkhach ;
        
        public static void Connec(){
            cnn = DatabaseConnection.getConnection();
            if(cnn!=null){
                System.out.println("Da ket noi SQL");
            }
            else{
                System.err.println("Loi ket noi ! Kiem tra lai");
            }
        }
        
        public static void Insert(int makh, String ten, String cancuoc, String phone, int ngay, int loai, int gia){
            try{
            String sql = "insert into khachhang values (?,?,?,?,?,?,?)";
            cnn = DatabaseConnection.getConnection();
            pr = cnn.prepareStatement(sql);
            pr.setInt(1,makh);
            pr.setString(2,ten);
            pr.setString(3,cancuoc);
            pr.setString(4,phone);
            pr.setInt(5,ngay);
            pr.setInt(6,loai);
            pr.setInt(7,gia);
            int s = pr.executeUpdate();
            if(s>0){
                System.out.println("\nThem du lieu thanh cong !");
            }
            else{
                System.err.println("Them du lieu that bai !");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(cnn != null){
                    cnn.close();
                }
                if(pr != null){
                    pr.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception ex){
               ex.printStackTrace();
            }
        }
     }
        
    public static void Select(){
        try{
            String sql = " select * from khachhang";
            cnn = DatabaseConnection.getConnection();
            pr = cnn.prepareStatement(sql);
            rs = pr.executeQuery();
            while(rs.next()){
                int makh = rs.getInt("makh");
                String ten = rs.getString("ten");
                String cancuoc = rs.getString("cancuoc");
                String phone = rs.getString("phone");
                int ngay = rs.getInt("ngay");
                int loai = rs.getInt("loai");
                int gia = rs.getInt("gia");
                QLKhach ds = new QLKhach(makh,ten,cancuoc,phone,ngay,loai,gia);
                listkhach.add(ds);
            }
        }catch(SQLException e){
            return;
        }finally{
            try{
                if(cnn != null){
                    cnn.close();
                }
                if(pr != null){
                    pr.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception ex){
               ex.printStackTrace();
            }
        }
    }
        
      public static boolean Search(int a){
        try{
            
            String sql = "select makh from khachhang where makh = ?";
            cnn = DatabaseConnection.getConnection();
            pr = cnn.prepareStatement(sql);
            pr.setInt(1,a);
            rs = pr.executeQuery();
            while(rs.next()){
                int makh = rs.getInt("makh");
                if(a==makh){
                    return true;
                }
                else{
                    return false;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(cnn != null){
                    cnn.close();
                }
                if(pr != null){
                    pr.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception ex){
               ex.printStackTrace();
            }
        }
        return false;
    }
      public static void Update(int a, String ten, String cancuoc, String phone, int ngay, int loai, int gia){
           try{
            String sql = "update khachhang set ten = ?,cancuoc = ?,phone"
                    + " = ?,ngay = ?, loai =?, gia = ? where makh = ?";
            cnn = DatabaseConnection.getConnection();
            pr = cnn.prepareStatement(sql);
            pr.setInt(7,a);
            pr.setString(1,ten);
            pr.setString(2,cancuoc);
            pr.setString(3,phone);
            pr.setInt(4,ngay);
            pr.setInt(5,loai);
            pr.setInt(6,gia);
            int s = pr.executeUpdate();
            if(s>0){
                System.out.println("Sua thanh cong ! ");
            }
            else{
                System.err.println("Sua that bai ! ");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(cnn != null){
                    cnn.close();
                }
                if(pr != null){
                    pr.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception ex){
               ex.printStackTrace();
            }
        }
      }
    
      
      
      public static void Delete(int b){
          try{
            String sql = "delete from khachhang where makh = ?";
            cnn = DatabaseConnection.getConnection();
            pr = cnn.prepareStatement(sql);
            pr.setInt(1,b);
            int s = pr.executeUpdate();
            if(s>0){
                System.out.println("Xoa thanh cong !");
            }
            else{
                System.out.println("Xoa that bai ! ");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(cnn != null){
                    cnn.close();
                }
                if(pr != null){
                    pr.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception ex){
               ex.printStackTrace();
            }
        }  
      }
      
      public static void SearchData(int c){
        try{
            
            String sql = "select * from khachhang where makh = ?";
            cnn = DatabaseConnection.getConnection();
            pr = cnn.prepareStatement(sql);
            pr.setInt(1,c);
            rs = pr.executeQuery();
            while(rs.next()){
                int makh = rs.getInt("makh");
                String ten = rs.getString("ten");
                String cancuoc = rs.getString("cancuoc");
                String phone = rs.getString("phone");
                int ngay = rs.getInt("ngay");
                int loai = rs.getInt("loai");
                int gia = rs.getInt("gia");
                QLKhach ds = new QLKhach(makh,ten,cancuoc,phone,ngay,loai,gia);
                listkhach.add(ds);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(cnn != null){
                    cnn.close();
                }
                if(pr != null){
                    pr.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception ex){
               ex.printStackTrace();
            }
        }
    }
      
      public static void SearchData2(String d){
        try{
            
            String sql = "select * from khachhang where ten = ?";
            cnn = DatabaseConnection.getConnection();
            pr = cnn.prepareStatement(sql);
            pr.setString(1,d);
            rs = pr.executeQuery();
            while(rs.next()){
                int makh = rs.getInt("makh");
                String ten = rs.getString("ten");
                String cancuoc = rs.getString("cancuoc");
                String phone = rs.getString("phone");
                int ngay = rs.getInt("ngay");
                int loai = rs.getInt("loai");
                int gia = rs.getInt("gia");
                QLKhach ds = new QLKhach(makh,ten,cancuoc,phone,ngay,loai,gia);
                listkhach.add(ds);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(cnn != null){
                    cnn.close();
                }
                if(pr != null){
                    pr.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception ex){
               ex.printStackTrace();
            }
        }
    }
      
      public static void SearchData3(String e){
        try{
            
            String sql = "select * from khachhang where cancuoc = ?";
            cnn = DatabaseConnection.getConnection();
            pr = cnn.prepareStatement(sql);
            pr.setString(1,e);
            rs = pr.executeQuery();
            while(rs.next()){
                int makh = rs.getInt("makh");
                String ten = rs.getString("ten");
                String cancuoc = rs.getString("cancuoc");
                String phone = rs.getString("phone");
                int ngay = rs.getInt("ngay");
                int loai = rs.getInt("loai");
                int gia = rs.getInt("gia");
                QLKhach ds = new QLKhach(makh,ten,cancuoc,phone,ngay,loai,gia);
                listkhach.add(ds);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(cnn != null){
                    cnn.close();
                }
                if(pr != null){
                    pr.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception ex){
               ex.printStackTrace();
            }
        }
    }
      
     public static void OrderBy(){
        try{
            String sql = "select * from khachhang order by ngay asc";
            cnn = DatabaseConnection.getConnection();
            pr = cnn.prepareStatement(sql);
            rs = pr.executeQuery();
            while(rs.next()){
                int makh = rs.getInt("makh");
                String ten = rs.getString("ten");
                String cancuoc = rs.getString("cancuoc");
                String phone = rs.getString("phone");
                int ngay = rs.getInt("ngay");
                int loai = rs.getInt("loai");
                int gia = rs.getInt("gia");
                QLKhach ds = new QLKhach(makh,ten,cancuoc,phone,ngay,loai,gia);
                listkhach.add(ds);
            }
        }catch(SQLException e){
            return;
        }finally{
            try{
                if(cnn != null){
                    cnn.close();
                }
                if(pr != null){
                    pr.close();
                }
                if(rs != null){
                    rs.close();
                }
            }catch(Exception ex){
               ex.printStackTrace();
            }
        }
    }
      
    public static void main(String[] args) {
        listkhach = new ArrayList<>();
        int chon,chon1,chon2,chon3;
        do{
            menu();
            chon = Integer.parseInt(sc.nextLine());
            switch(chon){
                case 1: 
                    Connec();
                    break;
                case 2:
                    do{
                            QLKhach kh = new QLKhach();
                            System.out.println("Nhap ma khach hang : ");
                            int makh = Integer.parseInt(sc.nextLine());
                            if(Search(makh)==false){
                            kh.setMakh(makh);
                            kh.input2();
                            String ten = kh.getTen();
                            String cancuoc = kh.getCancuoc();
                            String phone = kh.getPhone();
                            int ngay = kh.getNgay();
                            int loai = kh.getLoai();
                            int gia = kh.getGia();
                            Insert(makh, ten, cancuoc, phone, ngay, loai, gia);
                            }
                            else if(Search(makh)==true){
                                System.err.println("Ma khach hang da ton tai !");
                            }
                            System.out.println("  Ban co muon them du lieu co/khong (1/0) ");
                            System.out.println("  1. Yes");
                            System.out.println("  0. No");
                            chon1 = Integer.parseInt(sc.nextLine());
                    }while(chon1!=0);
                    break;
                case 3:
                    listkhach = new ArrayList<>();
                    Select();
                    System.out.println("Danh sach khach hang :");
                    for (int i = 0; i < listkhach.size(); i++) {
                        listkhach.get(i).output();
                    }
                    break;
                case 4:
                    listkhach = new ArrayList<>();
                    System.out.println("Nhap vao ma khach hang can sua thong tin : ");
                    int a = Integer.parseInt(sc.nextLine());
                    boolean ck = Search(a);
                    if(ck == true){
                        System.out.println("Da tim thay ma khach hang can sua !");
                        SearchData(a);
                        System.out.println("Thong tin khach hang :");
                        for (int i = 0; i < listkhach.size(); i++) {
                            listkhach.get(i).output();
                        }
                        System.out.println("");
                        QLKhach kh2 = new QLKhach();
                            kh2.input2();
                            String ten = kh2.getTen();
                            String cancuoc = kh2.getCancuoc();
                            String phone = kh2.getPhone();
                            int ngay = kh2.getNgay();
                            int loai = kh2.getLoai();
                            int gia = kh2.getGia();
                        Update(a, ten, cancuoc, phone, ngay, loai, gia);
                    }
                    else{
                         System.out.println("khong tim thay !");
                    }
                    break;
                case 5:
                    System.out.println("Nhap vao ma khach hang can xoa : ");
                    int b = Integer.parseInt(sc.nextLine());
                    boolean ck2 = Search(b);
                    if(ck2 == true){
                        Delete(b);
                    }
                        else{
                            System.out.println("Ko tim thay khach hang !");
                        }
                    break;
                case 6:
                    listkhach = new ArrayList<>();
                    do{
                       menu2();
                       chon2 = Integer.parseInt(sc.nextLine());
                       switch(chon2){
                           case 1:
                               System.out.println("Nhap vao ma khach hang can tim : ");
                                int c = Integer.parseInt(sc.nextLine());
                                SearchData(c);
                                System.out.println("Thong tin khach hang :");
                                for (int i = 0; i < listkhach.size(); i++) {
                                    listkhach.get(i).output();
                                }
                                break;
                           case 2:
                               System.out.println("Nhap vao ten khach hang can tim : ");
                                String d = sc.nextLine();
                                SearchData2(d.trim());
                                System.out.println("Thong tin khach hang :");
                                for (int i = 0; i < listkhach.size(); i++) {
                                    listkhach.get(i).output();
                                }
                                break;
                           case 3:
                               System.out.println("Nhap vao can cuoc khach hang can tim : ");
                                String e = sc.nextLine();
                                SearchData3(e.trim());
                                System.out.println("Thong tin khach hang :");
                                for (int i = 0; i < listkhach.size(); i++) {
                                    listkhach.get(i).output();
                                }
                                break;
                           case 4:
                               break;
                           default:
                               break;
                       }
                    }while(chon2!=4);
                    break;
                case 7:
                    listkhach = new ArrayList<>();
                    OrderBy();
                    System.out.println("Danh sach khach hang :");
                    for (int i = 0; i < listkhach.size(); i++) {
                        listkhach.get(i).output();
                    }
                    break;
                case 8:
                    break;
                default:
                    break;
            }
            
        }while(chon!=8);
    }
    
    public static void menu(){
        System.out.println("");
        System.out.println("     1. Kiem tra ket noi SQL");
        System.out.println("     2. Them du lieu");
        System.out.println("     3. Hien thi du lieu");
        System.out.println("     4. Sua du lieu");
        System.out.println("     5. Xoa du lieu");
        System.out.println("     6. Tim kiem du lieu");
        System.out.println("     7. Sap xep theo ngay");
        System.out.println("     8. Thoat.");
        System.out.println("   Choose: ");
    }
    
    public static void menu2(){
            System.out.println("   1. Tim kiem theo ma khach hang");
            System.out.println("   2. Tim kiem theo ten khach hang");
            System.out.println("   3. Tim kiem theo can cuoc");
            System.out.println("   4. Thoat.");
            System.out.println("  Choose : ");
    }
    
}
