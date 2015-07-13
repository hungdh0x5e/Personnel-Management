
CREATE DATABASE AT9B
use AT9B

CREATE TABLE tblThongTinCongTy (
	TenCtyVN nvarchar(100),
	TenCtyEN varchar(100),
	TenVietTat varchar(100),
	TenGiamDoc nvarchar(100),
	SoDienThoai varchar(20),
	SoFax varchar(12),
	SoTaiKhoan varchar(20),
	DiaChiVN nvarchar(100),
	DiaChiEN nvarchar(100),
	MaSoThue varchar(20),
	NgayDangKy date,
	Logo image
)

CREATE TABLE tblNhanVien(
	-- Các thông tin chính
	MaNV varchar(6) primary key,
	HoDem nvarchar(30),
	Ten nvarchar(20),
	Nickname nvarchar(20),
	MaTrangThai smallint, 
	MaLoaiNV smallint,	  
	MaLoaiHopDong smallint,	
	MaChucVu smallint,
	MaPhongBan smallint,
	NgayVao date,
	NgayBatDau date,
	GioiTinh bit,		 
	SDT varchar(11),
	EmailCty varchar(40),
	NgayKTthuViec date,  
	HinhAnh image,
	-- Thông tin thêm
	NgaySinh date,
	NguyenQuan nvarchar(50),
	ThuongTru nvarchar(50),
	MaDanToc smallint,
	MaTonGiao smallint,
	MaQuocGia smallint,
	EmailRieng varchar(40),
	KetHon bit,			  
	TrinhDoVH varchar(10),
	DiaChi nvarchar(50),
	SoCMT varchar(11),
	NgayCap date,
	
	MaTinh smallint,    
	SoTK varchar(20),	     
	MaNH smallint,		  
	NoiCap nvarchar(20),
	MaSoThue varchar(20)
)
INSERT INTO tblNhanVien
VALUES ('NV0002',N'Lưu Thị',N'Mỹ Linh','thilinh',1,1,1,1,2,'02-02-2015','03-02-2015',0,'01677197143','hungdh@at9b.com',
'03-04-2015',null,'12-02-1994',N'Hà Nội',N'Hai Bà Trưng - Hà Nội',1,0,1,'hungdh0x5e@gmail.com',0,
'12/12',N'141 Chiến Thắng - Tân Triều - Thành Trì - HN','142646918','04-29-2009',1,'711A120939',1,N'Hà Nội','12314')

INSERT INTO tblNhanVien
VALUES ('NV0001',N'Đỗ Huy',N'Hùng','hungdh',1,1,1,1,2,'02-02-2015','03-02-2015',1,'01677197143','hungdh@at9b.com',
'03-04-2015',null,'12-02-1994',N'Hà Nội',N'Hai Bà Trưng - Hà Nội',1,0,1,'hungdh0x5e@gmail.com',0,
'12/12',N'141 Chiến Thắng - Tân Triều - Thành Trì - HN','142646918','04-29-2009',1,'711A120939',1,N'Hà Nội','124125')

CREATE TABLE tblGiaDinh(
	MaGiaDinh smallint PRIMARY KEY IDENTITY( 1, 1 ), 
	MaNV varchar(6),
	MaMQH smallint,
	Ten nvarchar(30),
	NgaySinh date,
	NgheNghiep nvarchar(20),
	DiaChi nvarchar(20),
	SDT char(11)
)
INSERT INTO tblGiaDinh
VALUES ('NV0001',1,N'Đỗ Huy Hoàng','02-02-1970',N'Công Nhân',N'Hải Dương','0987312989') 
CREATE TABLE tblSucKhoe(
	MaPhieuSK smallint PRIMARY KEY IDENTITY(1,1),
	MaNV varchar(6),
	NgayKham date,
	TenBenhVien nvarchar(30),
	ChieuCao smallint,
	CanNang smallint,
	ThiLuc varchar(10),
	MaNhomMau smallint,
	MaTinhTrangSK smallint,
	GhiChu nvarchar(50)
)
INSERT INTO tblSucKhoe
VALUES('NV0001','06-06-2015','BV Bạch Mai',173,55,'10/10',1,1,'Tôt')

CREATE TABLE tblTaiLieu(
	MaTaiLieu smallint PRIMARY KEY IDENTITY(1,1),
	MaNV varchar(6),
	Name nvarchar(50),
	NgayLuu date,
	DuLieu varbinary(MAX),
	PhanMoRong varchar(5),
	MaLoaiTL smallint
)

CREATE TABLE tblKinhNghiemLV(
	MaKinhNghiemLV smallint PRIMARY KEY IDENTITY(1,1),
	MaNV varchar(6),
	TenCty nvarchar(30),
	ChucDanh nvarchar(30),
	CongViec nvarchar(30),
	TimeBatDau date,
	TimeKetThuc date,
	LiDo nvarchar(30),
	-- Thong tin ng lien he
	TenNguoiLienHe nvarchar(30),
	SDT varchar(11),
	Email varchar(20),
	ChucVu nvarchar(20)
)

CREATE TABLE tblThongTinKyNang(
	MaThongTinKyNang smallint PRIMARY KEY IDENTITY(1,1),
	MaNV varchar(6),
	MaKyNang smallint,
	MaXepLoaiKyNang smallint,
	GhiChu nvarchar(30),
	NgayHieuLuc date
)

create table tblThongTinHocVan(
	MaThongTinHocVan smallint primary key identity (1,1),
	MaNV varchar(6),
	MaLoaiHocVan smallint,
	MaLoaiTotNghiep smallint,
	TenKhoaHoc nvarchar(45),
	TenTruong nvarchar(45),
	TuNam smallint,
	DenNam smallint
)

CREATE TABLE tblDanToc (
	MaDanToc smallint primary key IDENTITY( 1, 1 ),
	TenDanToc nvarchar(20)
)

-- Bảng Tôn Giáo
CREATE TABLE tblTonGiao(
	MaTonGiao smallint primary key IDENTITY( 1, 1 ),
	TenTonGiao nvarchar(20)
)
INSERT INTO tblTonGiao VALUES(N'Không')
INSERT INTO tblTonGiao VALUES(N'Phật Giáo')
INSERT INTO tblTonGiao VALUES(N'Đạo Giáo')

-- Bảng quốc gia
CREATE TABLE tblQuocGia(
	MaQuocGia smallint identity (1,1),
	TenQuocGia nvarchar(20)
)
INSERT INTO tblQuocGia VALUES(N'Việt Nam')
INSERT INTO tblQuocGia VALUES(N'Vương quốc Anh')
INSERT INTO tblQuocGia VALUES(N'Thái Lan')
 
-- Bảng mã tỉnh
CREATE TABLE tblTinh(
	MaTinh smallint primary key IDENTITY( 1, 1 ),
	TenTinh nvarchar(20)
)
INSERT INTO tblTinh VALUES(N'Hà Nội')
INSERT INTO tblTinh VALUES(N'Hải Dương')
INSERT INTO tblTinh VALUES(N'Hải Phòng')

-- Bảng mã ngân hàng
CREATE TABLE tblNganHang(
	MaNH smallint primary key IDENTITY( 1, 1 ),
	TenNH nvarchar(50)
)

-- Bảng Mối Quan Hệ
CREATE TABLE tblMoiQuanHe(
	MaMQH smallint PRIMARY KEY IDENTITY(1,1),
	TenMQH nvarchar(30)
)

-- Bảng Nhóm Máu
CREATE TABLE tblNhomMau(
	MaNhomMau smallint PRIMARY KEY IDENTITY(1,1),
	TenNhomMau char(3)
)

-- Bảng TinhTrangSK
CREATE TABLE tblTinhTrangSK(
	MaTinhTrangSK smallint PRIMARY KEY IDENTITY(1,1),
	TenTinhTrang nvarchar(15)
)

-- Bảng Kỹ năng
CREATE TABLE tblKyNang(
	MaKyNang smallint IDENTITY(1,1),
	TenKyNang nvarchar(15)
)

-- Bảng Xếp Loại Kỹ Năng
CREATE TABLE tblXepLoaiKyNang(
	MaXepLoaiKyNang smallint PRIMARY KEY IDENTITY(1,1),
	TenXepLoai nvarchar(15)
)

CREATE TABLE tblLoaiTaiLieu(
	MaLoaiTL smallint PRIMARY KEY IDENTITY(1,1),
	TenLoaiTL nvarchar(30)
)

CREATE TABLE tblLoaiHopDong(
	MaLoaiHopDong smallint primary key IDENTITY(1,1),
	TenLoaiHopDong nvarchar(20),
	SoThang smallint,
	DongBHXH bit,
	TiLeDong real,
	MauHopDong varbinary(MAX),
	PhanMoRong varchar(5)
)
INSERT INTO tblLoaiHopDong 
VALUES(N'Hợp đồng thử việc',2,1,0.5,NULL,NULL)
INSERT INTO tblLoaiHopDong 
VALUES(N'Hợp đồng 1 năm',12,1,0.5,NULL,NULL)

CREATE TABLE tblPhongBan(
	MaPhongBan smallint primary key IDENTITY( 1, 1 ),
	TenPhongBan nvarchar(30),
	SoPhong varchar(10)
)
INSERT INTO tblPhongBan VALUES (N'Phòng Kỹ Thuật','601')
INSERT INTO tblPhongBan VALUES (N'Phòng Kế Toán','201')

CREATE TABLE tblLoaiNV (
	MaLoaiNV smallint primary key IDENTITY(1,1),
	TenLoaiNV nvarchar(20)
)
INSERT INTO tblLoaiNV VALUES(N'Lao động trực tiếp')
INSERT INTO tblLoaiNV VALUES(N'Lao động gián tiếp')

-- Bảng trạng thái làm việc(đang, nghỉ)
CREATE TABLE tblTrangThaiLV (
	MaTrangThai smallint primary key IDENTITY(1,1),
	TenTrangThai nvarchar(20)
)
INSERT INTO tblTrangThaiLV VALUES(N'Đang làm việc')
INSERT INTO tblTrangThaiLV VALUES(N'Nghỉ ốm')
INSERT INTO tblTrangThaiLV VALUES(N'Nghỉ thai sản')
INSERT INTO tblTrangThaiLV VALUES(N'Nghỉ hẳn')

CREATE TABLE tblChucVu(
	MaChucVu smallint primary key IDENTITY(1,1),
	TenChucVu nvarchar(30)
)
INSERT INTO tblChucVu VALUES(N'Giám Đốc')
INSERT INTO tblChucVu VALUES(N'Trưởng phòng')
INSERT INTO tblChucVu VALUES(N'Nhân Viên')

create table tblLoaiHocVan(
	MaLoaiHocVan smallint primary key identity (1,1),
	TenLoaiHocVan varchar(30)
)
insert into tblLoaiHocVan values(N'Trung học cơ sở')
insert into tblLoaiHocVan values(N'Trung học phổ thông')
insert into tblLoaiHocVan values(N'Đại học')
insert into tblLoaiHocVan values(N'Cao đẳng')
insert into tblLoaiHocVan values(N'Trung cấp')

create table tblLoaiTotNghiep(
	MaLoaiTotNghiep smallint primary key identity (1,1),
	TenLoaiTotNghiep nvarchar(30)
)
insert into tblLoaiTotNghiep values(N'Xuất sắc')
insert into tblLoaiTotNghiep values(N'Giỏi')
insert into tblLoaiTotNghiep values(N'Khá')
insert into tblLoaiTotNghiep values(N'Trung bình')
insert into tblLoaiTotNghiep values(N'Yếu')

-- Bảng thành viên công đoàn
CREATE TABLE tblCongDoan(
	MaNV varchar(6),
	NgayThamGia date,
	CoThamGia bit,
	PRIMARY KEY(MaNV)
)
INSERT INTO tblCongDoan VALUES('NV0001',NULL,0);
INSERT INTO tblCongDoan VALUES('NV0002','07-07-2015',1);
