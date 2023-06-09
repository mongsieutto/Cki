USE [CuoiKy]
GO
/****** Object:  Table [dbo].[ChiTietMuonSach]    Script Date: 12/18/2022 12:58:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietMuonSach](
	[NgayMuon] [datetime] NOT NULL,
	[NgayTra] [datetime] NULL,
	[TienCoc] [bigint] NULL,
	[MaDG] [varchar](13) NOT NULL,
	[MaSach] [varchar](11) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDG] ASC,
	[NgayMuon] ASC,
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DocGia]    Script Date: 12/18/2022 12:58:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DocGia](
	[MaDG] [varchar](13) NOT NULL,
	[DienThoai] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[HoTenDG] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sach]    Script Date: 12/18/2022 12:58:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sach](
	[MaSach] [varchar](11) NOT NULL,
	[GiaBia] [bigint] NULL,
	[NamXB] [int] NULL,
	[TacGia] [nvarchar](50) NULL,
	[TuaSach] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietMuonSach] ([NgayMuon], [NgayTra], [TienCoc], [MaDG], [MaSach]) VALUES (CAST(N'2022-12-18T12:29:43.920' AS DateTime), NULL, 15000, N'DG01', N'S01')
INSERT [dbo].[ChiTietMuonSach] ([NgayMuon], [NgayTra], [TienCoc], [MaDG], [MaSach]) VALUES (CAST(N'2022-12-18T12:29:48.427' AS DateTime), NULL, 15000, N'DG02', N'S01')
INSERT [dbo].[ChiTietMuonSach] ([NgayMuon], [NgayTra], [TienCoc], [MaDG], [MaSach]) VALUES (CAST(N'2022-12-18T12:29:53.623' AS DateTime), NULL, 15000, N'DG03', N'S01')
INSERT [dbo].[ChiTietMuonSach] ([NgayMuon], [NgayTra], [TienCoc], [MaDG], [MaSach]) VALUES (CAST(N'2022-12-18T12:30:02.497' AS DateTime), NULL, 15000, N'DG03', N'S02')
INSERT [dbo].[ChiTietMuonSach] ([NgayMuon], [NgayTra], [TienCoc], [MaDG], [MaSach]) VALUES (CAST(N'2022-12-18T12:30:22.457' AS DateTime), NULL, 15000, N'DG03', N'S02')
GO
INSERT [dbo].[DocGia] ([MaDG], [DienThoai], [Email], [HoTenDG]) VALUES (N'DG01', N'043873456', N'dg01@gmail.com', N'Nguyen Van A')
INSERT [dbo].[DocGia] ([MaDG], [DienThoai], [Email], [HoTenDG]) VALUES (N'DG02', N'043873455', N'dg02@gmail.com', N'Nguyen Van B')
INSERT [dbo].[DocGia] ([MaDG], [DienThoai], [Email], [HoTenDG]) VALUES (N'DG03', N'043873466', N'dg03@gmail.com', N'Nguyen Van C')
GO
INSERT [dbo].[Sach] ([MaSach], [GiaBia], [NamXB], [TacGia], [TuaSach]) VALUES (N'S01', 10000, 2022, N'Le Quoc Phong', N'Cuoi Ky JAVA PT')
INSERT [dbo].[Sach] ([MaSach], [GiaBia], [NamXB], [TacGia], [TuaSach]) VALUES (N'S02', 5000, 2021, N'Le Quoc Phong', N'Cuoi Ky HSK JAVA')
GO
ALTER TABLE [dbo].[ChiTietMuonSach]  WITH CHECK ADD  CONSTRAINT [FK9tfyqggksa5etns9obi9pxa9q] FOREIGN KEY([MaDG])
REFERENCES [dbo].[DocGia] ([MaDG])
GO
ALTER TABLE [dbo].[ChiTietMuonSach] CHECK CONSTRAINT [FK9tfyqggksa5etns9obi9pxa9q]
GO
ALTER TABLE [dbo].[ChiTietMuonSach]  WITH CHECK ADD  CONSTRAINT [FKqcclw0jyf4ti2cjpcpatmko5g] FOREIGN KEY([MaSach])
REFERENCES [dbo].[Sach] ([MaSach])
GO
ALTER TABLE [dbo].[ChiTietMuonSach] CHECK CONSTRAINT [FKqcclw0jyf4ti2cjpcpatmko5g]
GO
