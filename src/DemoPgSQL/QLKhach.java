/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoPgSQL;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class QLKhach {
    private int makh;
    private String ten;
    private String cancuoc;
    private String phone;
    private int ngay;
    private int loai;
    private int gia;
    private float t;
    public float thanhtien(int gia,int ngay){
        return t = gia*ngay;
    }
    public float getThanhTien(){
        return t;
    }
    public QLKhach() {
    }

    public QLKhach(int makh, String ten, String cancuoc, String phone, int ngay, int loai, int gia) {
        this.makh = makh;
        this.ten = ten;
        this.cancuoc = cancuoc;
        this.phone = phone;
        this.ngay = ngay;
        this.loai = loai;
        this.gia = gia;
        thanhtien(gia,ngay);
    }

    public int getMakh() {
        return makh;
    }

    public boolean setMakh(int makh) {
        if(makh>0){
           this.makh = makh; 
           return true;
        }else{
            System.err.println("Nhap sai !");
            return false;
        }
        
    }

    public String getTen() {
        return ten;
    }

    public boolean setTen(String ten) {
        if(ten != null){
            this.ten = ten;
            return true;
        }else{
            System.err.println("Nhap sai !");
            return false;
        }
        
    }

    public String getCancuoc() {
        return cancuoc;
    }

    public boolean setCancuoc(String cancuoc) {
        if(cancuoc != null){
            this.cancuoc = cancuoc;
            return true;
        }else{
             System.err.println("Nhap sai !");
            return false;
        }
        
    }

    public String getPhone() {
        return phone;
    }

    public boolean setPhone(String phone) {
        if(phone != null && phone.length()==10 && phone.startsWith("0")){
            this.phone = phone;
            return true;
        }else{
             System.err.println("Nhap sai !");
            return false;
        }
        
    }

    public int getNgay() {
        return ngay;
    }

    public boolean setNgay(int ngay) {
        if(ngay>0 && ngay<=31){
           this.ngay = ngay;
           return true;
        }else{
             System.err.println("Nhap sai !");
            return false;
        } 
    }

    public int getLoai() {
        return loai;
    }

    public boolean setLoai(int loai) {
        if(loai>=1 && loai<=4){
            this.loai = loai;
            return true;
        }
        else{
             System.err.println("Nhap sai !");
            return false;
        }
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Nhap vao ma khach hang : ");
            int ip1 = Integer.parseInt(sc.nextLine());
            boolean ck1 = setMakh(ip1);
            if(ck1==true){
                break;
            } 
        }
        while(true){
            System.out.println("Nhap vao ten khach hang : ");
            String ip2 = sc.nextLine();
            boolean ck2 = setTen(ip2);
            if(ck2==true){
                break;
            } 
        }
        
        while(true){
            System.out.println("Nhap vao can cuoc :");
            String ip3 = sc.nextLine();
            boolean ck3 = setCancuoc(ip3);
            if(ck3==true){
                break;
            } 
        }
        
        while(true){
            System.out.println("Nhap vao so dien thoai : ");
            String ip4 = sc.nextLine();
            boolean ck4 = setPhone(ip4);
            if(ck4==true){
                break;
            } 
        }
        
        while(true){
            System.out.println("Nhap vao ngay thue :");
            int ip5 = Integer.parseInt(sc.nextLine());
            boolean ck5 = setNgay(ip5);
            if(ck5==true){
                break;
            } 
        }
        while(true){
            System.out.println("   1. 50,000");
            System.out.println("   2. 100,000");
            System.out.println("   3. 150,000");
            System.out.println("   4. 200,000");
            System.out.println("Nhap vao loai phong :");
            int ip6 = Integer.parseInt(sc.nextLine());
            boolean ck6 = setLoai(ip6);
            if(ck6==true){
                if(ip6==1){
                    gia = 50000;
                }
                if(ip6==2){
                    gia = 100000;
                }
                if(ip6==3){
                    gia = 150000;
                }
                if(ip6==4){
                    gia = 200000;
                }
                break;
            } 
        }
    }
    
    public void input2(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Nhap vao ten khach hang : ");
            String ip2 = sc.nextLine();
            boolean ck2 = setTen(ip2);
            if(ck2==true){
                break;
            } 
        }
        
        while(true){
            System.out.println("Nhap vao can cuoc :");
            String ip3 = sc.nextLine();
            boolean ck3 = setCancuoc(ip3);
            if(ck3==true){
                break;
            } 
        }
        
        while(true){
            System.out.println("Nhap vao so dien thoai : ");
            String ip4 = sc.nextLine();
            boolean ck4 = setPhone(ip4);
            if(ck4==true){
                break;
            } 
        }
        
        while(true){
            System.out.println("Nhap vao ngay thue :");
            int ip5 = Integer.parseInt(sc.nextLine());
            boolean ck5 = setNgay(ip5);
            if(ck5==true){
                break;
            } 
        }
        while(true){
            System.out.println("   1. 50,000");
            System.out.println("   2. 100,000");
            System.out.println("   3. 150,000");
            System.out.println("   4. 200,000");
            System.out.println("Nhap vao loai phong :");
            int ip6 = Integer.parseInt(sc.nextLine());
            boolean ck6 = setLoai(ip6);
            if(ck6==true){
                if(ip6==1){
                    gia = 50000;
                }
                if(ip6==2){
                    gia = 100000;
                }
                if(ip6==3){
                    gia = 150000;
                }
                if(ip6==4){
                    gia = 200000;
                }
                break;
            } 
        }
    }
    @Override
    public String toString() {
        return "QLKhach : " + "makh=" + makh + ", ten=" + ten + ", cancuoc=" + cancuoc + ", phone=" + phone + ", "
                + "\nNgay=" + ngay + ", loai=" + loai + ", gia=" + gia + " ";
    }
    
    public void output(){
        System.out.println(toString());
        System.out.println("Thanh tien : "+t);
    }
}
