/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.ass;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ASUS
 */
public class QuanLyNhanVien {

    ArrayList<NhanVien> dsNhanVien = new ArrayList<>();
    Scanner nhap = new Scanner(System.in);
    Scanner nhapChu = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);

    public QuanLyNhanVien() {
    }

    //Thêm nhân viên
    public void nhapNV() {
        System.out.print("Chon loai nhan vien [1.NVHC 2.NVTT 3.TP]:");
        int chon = nhap.nextInt();
        boolean thoat = true;
        while (thoat) {
            switch (chon) {
                case 1:
                    NhanVienHanhChinh nvhc = new NhanVienHanhChinh();
                    nvhc.nhapNV();
                    dsNhanVien.add(nvhc);
                    thoat = false;
                    break;

                case 2:
                    NhanVienTiepThi nvtt = new NhanVienTiepThi();
                    nvtt.nhapNV();
                    dsNhanVien.add(nvtt);
                    thoat = false;
                    break;

                case 3:
                    TruongPhong tp = new TruongPhong();
                    tp.nhapNV();
                    dsNhanVien.add(tp);
                    thoat = false;
                    break;

                default:
                    System.out.print("Chon sai!! Hay chon lai!!");
            }
        }
    }

    //Xuất danh sách
    public void xuatDs() {
        System.out.println("DANH SACH NHAN VIEN");
        System.out.format("%-10s", "Ma NV");
        System.out.format("%-20s", "Ten NV");
        System.out.format("%-15s", "Luong CB");
        System.out.format("%-15s", "Doanh so");
        System.out.format("%-15s", "Luong HH");
        System.out.format("%-20s", "Luong trach nhiem");
        System.out.format("%-15s", "Luong ");
        System.out.format("%-15s", "Thue ");
        for (NhanVien x : dsNhanVien) {
            System.out.print("\n");
            x.xuatNV();

        }
    }

    //Tìm và hiển thị theo mã NV
    public void timNV() {
        String tim;
        System.out.print("Nhap ma nhan vien can tim: ");
        sc.nextLine();
        tim = sc.nextLine();
        int a = 0;
        for (NhanVien x : dsNhanVien) {
            if (x.getMaNV().equalsIgnoreCase(tim)) {
                System.out.println("Ma NV: " + x.getMaNV());
                System.out.println("Ten NV: " + x.getTenNV());
                System.out.println("Luong NV: " + x.tinhLuong());
                a++;
            }
        }
        if (a == 0) {
            System.out.println("Khong tim thay!");
        }
    }

    //Xóa nhân viên theo mã
    public void xoaTheoMa() {
        String tim;
        System.out.print("Nhap ma nhan vien can xoa: ");
        sc.nextLine();
        tim = sc.nextLine();
        int b = 0;
        for (NhanVien x : dsNhanVien) {
            if (x.getMaNV().equalsIgnoreCase(tim)) {
                System.out.println("Ma NV: " + x.getMaNV());
                System.out.println("Ten NV: " + x.getTenNV());
                System.out.println("Luong NV: " + x.tinhLuong());
                System.out.print("Ban muon xoa nhan vien nay [Y/N]:");
                if (nhapChu.nextLine().equalsIgnoreCase("y")) {
                    dsNhanVien.remove(x);
                    System.out.println("Da xoa nhan vien");

                } else {
                    break;
                }
                b++;
            }
        }
        if (b == 0) {
            System.out.print("Khong tim thay !!");
        }

    }

    //Cap nhat thong tin nhan vien
    public void capNhat() {
        System.out.print("Nhap ma nhan vien : ");
        String maNV = sc.nextLine();
        boolean c = true;
        for (int i = 0; i < dsNhanVien.size(); i++) {
            if (dsNhanVien.get(i).getMaNV().equalsIgnoreCase(maNV)) {
                System.out.print("Ho ten NV: ");
                dsNhanVien.get(i).setTenNV(sc.nextLine());;
                System.out.print("Luong:");
                dsNhanVien.get(i).setLuongNV(sc.nextDouble());
                c = false;
            }
        }
        if (c == true) {
            System.out.print("Khong tim thay!!");
        } else {
            c = true;
        }
    }

    //Tim nhan vien theo luong
    public void timTheoLuong() {
        System.out.print("Moi nhap luong: ");
        sc.nextLine();
        double luong = sc.nextDouble();
        System.out.println("DANH SACH NHAN VIEN");
        System.out.format("%-10s", "Ma NV");
        System.out.format("%-20s", "Ten NV");
        System.out.format("%-15s", "Luong CB");
        System.out.format("%-15s", "Doanh so");
        System.out.format("%-15s", "Luong HH");
        System.out.format("%-20s", "Luong trach nhiem");
        System.out.format("%-15s", "Luong ");
        System.out.format("%-15s", "Thue ");
        System.out.print("\n");
        for (NhanVien x : dsNhanVien) {
            if (luong == x.tinhLuong()) {
                x.xuatNV();
                System.out.print("\n");
            }
        }
    }

    //Sap xep theo ten
    Comparator<NhanVien> compTen = new Comparator<NhanVien>() {
        @Override
        public int compare(NhanVien nv1, NhanVien nv2) {
            return nv1.getTenNV().substring(nv1.getTenNV().lastIndexOf(" ") + 1)
                    .compareToIgnoreCase(nv2.getTenNV().substring(nv2.getTenNV()
                            .lastIndexOf(" ") + 1));

        }
    };

    Comparator<NhanVien> compHo = new Comparator<NhanVien>() {
        @Override
        public int compare(NhanVien nv1, NhanVien nv2) {
            return nv1.getTenNV().compareToIgnoreCase(nv2.getTenNV());
        }
    };

    public void sapXepTen() {
        System.out.print("[1.Sap xep theo ho -- 2.Sap xep theo ten] : ");
        int chon = sc.nextInt();
        switch (chon) {
            case 1:
                Collections.sort(dsNhanVien, compHo);
                System.out.print("Da sap xep danh sach theo ho!");
                break;
            case 2:
                Collections.sort(dsNhanVien, compTen);
                System.out.print("Da sap xep danh sach theo ten!");
                break;
            default:
                System.out.print("Chon sai, moi chon lai");
                break;
        }

    }

    //Sap xep theo thu nhap
    Comparator<NhanVien> compThuNhap = new Comparator<NhanVien>() {
        @Override
        public int compare(NhanVien nv1, NhanVien nv2) {
            if (nv1.tinhLuong() < nv2.tinhLuong()) {
                return 1;
            }
            return -1;
        }
    };

    public void sapXepLuong() {
        Collections.sort(dsNhanVien, compThuNhap);
        System.out.println("Da sap xep danh sach theo thu nhap!");
    }

    //Xuat 5 nhan vien co thu nhap cao nhat
    public void xuat5NvThuNhapCao() {
        Collections.sort(dsNhanVien, compThuNhap);
        System.out.println("DANH SACH 5 NHAN VIEN CO THU NHAP CAO NHAT");
        System.out.format("%-10s", "Ma NV");
        System.out.format("%-20s", "Ten NV");
        System.out.format("%-15s", "Luong CB");
        System.out.format("%-15s", "Doanh so");
        System.out.format("%-15s", "Luong HH");
        System.out.format("%-20s", "Luong trach nhiem");
        System.out.format("%-15s", "Luong ");
        System.out.format("%-15s", "Thue ");
        System.out.print("\n");
        for (int i = 0; i < 5; i++) {
            dsNhanVien.get(i).xuatNV();
            System.out.print("\n");
        }
    }
    
    //Nhập mã hợp lệ
    

}
